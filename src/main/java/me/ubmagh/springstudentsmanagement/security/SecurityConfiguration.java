package me.ubmagh.springstudentsmanagement.security;

import me.ubmagh.springstudentsmanagement.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").permitAll(); // default login page
        http.csrf().disable(); // ⚠ CSRF Disabled !! (delete action)

        http.authorizeRequests().antMatchers("/").permitAll(); // permit home & students list
        http.authorizeRequests().antMatchers("/webjars/**", "/js/**", "/css/**", "/images/**").permitAll(); // permit static resources

        http.exceptionHandling().accessDeniedPage("/pages/errors/403");
    }

}

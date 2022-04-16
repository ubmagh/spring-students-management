package me.ubmagh.springstudentsmanagement.security.services;

import lombok.AllArgsConstructor;
import me.ubmagh.springstudentsmanagement.security.entities.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    private ISecurityService securityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = securityService.loadUserByUsername(username);

        Collection<GrantedAuthority> authorities1 = appUser.getRoles().stream().map(
                appRole -> new SimpleGrantedAuthority( appRole.getRoleName() )
        ).collect(Collectors.toList());

        //User springSecUser = new User( appUser.getUsername(), appUser.getPassword(), authorities ) ;
        User springSecUser = new User( appUser.getUsername(), appUser.getPassword(), authorities1 ) ;
        return springSecUser;
    }
}

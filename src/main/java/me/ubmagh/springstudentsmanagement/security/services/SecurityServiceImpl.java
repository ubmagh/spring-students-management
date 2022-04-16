package me.ubmagh.springstudentsmanagement.security.services;

import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import me.ubmagh.springstudentsmanagement.security.entities.AppRole;
import me.ubmagh.springstudentsmanagement.security.entities.AppUser;
import me.ubmagh.springstudentsmanagement.security.repositories.AppRoleRepository;
import me.ubmagh.springstudentsmanagement.security.repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j // Get a log attribut
@AllArgsConstructor
@Transactional
public class SecurityServiceImpl implements ISecurityService {


    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public AppUser saveNewUser(String username, String password, String verifyPassword) {
        if( ! password.equals(verifyPassword) ) throw new RuntimeException(" Les deux mots de passe ne sont pas identiques ! ");
        String hashedPassword = passwordEncoder.encode( password) ;
        AppUser appUser = new AppUser();
        appUser.setActive(true);
        appUser.setPassword(hashedPassword);
        appUser.setUsername(username);
        appUser.setId( UUID.randomUUID().toString() );
        AppUser savedUser = appUserRepository.save( appUser ); // ?? !
        return savedUser ;
    }

    @Override
    public AppRole saveNewRole(String roleName, String description) {

        AppRole role = appRoleRepository.findByRoleName( roleName );
        if( role != null ) throw new RuntimeException("Le role '"+roleName+"' existe déjà !");
        role = new AppRole();
        role.setRoleName(roleName);
        role.setDesciption( description);
        AppRole saved = appRoleRepository.save( role );
        return saved;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user = appUserRepository.findByUsername( username );
        if( user ==null )
            throw new RuntimeException(" l'utilisateur qui a l'username '"+username+"' est introuvable !");
        AppRole role = appRoleRepository.findByRoleName( roleName);
        if( role ==null )
            throw new RuntimeException(" Le role '"+roleName+"' est introuvable !");
        user.getRoles().add(role);
    }

    @Override
    public void removeRoleFromUser(String username, String roleName) {
        AppUser user = appUserRepository.findByUsername( username );
        if( user ==null )
            throw new RuntimeException(" l'utilisateur qui a l'username '"+username+"' est introuvable !");
        AppRole role = appRoleRepository.findByRoleName( roleName);
        if( role ==null )
            throw new RuntimeException(" Le role '"+roleName+"' est introuvable !");
        user.getRoles().remove(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}

package me.ubmagh.springstudentsmanagement.security.services;

import me.ubmagh.springstudentsmanagement.security.entities.AppRole;
import me.ubmagh.springstudentsmanagement.security.entities.AppUser;

public interface ISecurityService {
    AppUser saveNewUser(String username, String password, String verifyPassword);
    AppRole saveNewRole(String roleName, String description);
    void addRoleToUser( String username, String roleName);
    void removeRoleFromUser( String username, String roleName);
    AppUser loadUserByUsername( String username );
}

package me.ubmagh.springstudentsmanagement.security.repositories;

import me.ubmagh.springstudentsmanagement.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {

    AppRole findByRoleName( String roleName);

}

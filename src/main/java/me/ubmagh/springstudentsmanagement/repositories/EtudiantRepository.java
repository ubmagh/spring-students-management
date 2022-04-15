package me.ubmagh.springstudentsmanagement.repositories;

import me.ubmagh.springstudentsmanagement.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, String> {
    Page<Etudiant> findByNomContainsOrPrenomContains(String nomKey, String prenomKey, Pageable pageable);

}

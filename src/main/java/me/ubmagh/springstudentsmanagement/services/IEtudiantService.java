package me.ubmagh.springstudentsmanagement.services;

import me.ubmagh.springstudentsmanagement.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEtudiantService {


    public Etudiant createEtudiant(Etudiant etudiant);
    public Page<Etudiant> findByNom(String keyword, Pageable pageable);
    public void deleteById( String id);

}

package me.ubmagh.springstudentsmanagement.services;

import me.ubmagh.springstudentsmanagement.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEtudiantService {


    public Etudiant createEtudiant(Etudiant etudiant);
    public Page<Etudiant> findByNomOrPrenom(String keyword, Pageable pageable);
    public Etudiant findById( String id);
    public void save( Etudiant etudiant);
    public void deleteById( String id);

}

package me.ubmagh.springstudentsmanagement.services;

import lombok.AllArgsConstructor;
import me.ubmagh.springstudentsmanagement.entities.Etudiant;
import me.ubmagh.springstudentsmanagement.repositories.EtudiantRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class EtudiantServiceImpl implements IEtudiantService {

    private EtudiantRepository etudiantRepository;

    public Etudiant createEtudiant(Etudiant etudiant){
        etudiant.setId(UUID.randomUUID().toString());
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Page<Etudiant> findByNomOrPrenom(String keyword, Pageable pageable) {
        return etudiantRepository.findByNomContainsOrPrenomContains( keyword, keyword, pageable);
    }

    @Override
    public void deleteById(String id) {
        etudiantRepository.deleteById(id);
    }
}

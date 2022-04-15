package me.ubmagh.springstudentsmanagement.web;

import lombok.AllArgsConstructor;
import me.ubmagh.springstudentsmanagement.entities.Etudiant;
import me.ubmagh.springstudentsmanagement.services.EtudiantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// url mapping is prefixed with /etudiants
public class EtudiantsController {

    @Autowired
    private EtudiantServiceImpl etudiantService;

    @GetMapping("/etudiants")
    public String liste( Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size,
                         @RequestParam(value = "keyword", defaultValue = "") String keyword){
        Page<Etudiant> etudiantsList = etudiantService.findByNomOrPrenom( keyword, PageRequest.of(page, size));
        model.addAttribute("etudiants", etudiantsList.getContent() );
        model.addAttribute("tab", "etudiants");

        int[] pages ;
        if( etudiantsList.getTotalPages()>7 ) {
            pages = new int[7];
            if( page<=3 ){
                for(int i=0; i<7; i++)
                    pages[i]=i;
            }else{
                int j =0;
                if( page>= ( etudiantsList.getTotalPages()-3 )){
                    for(int i=etudiantsList.getTotalPages()-7; i<etudiantsList.getTotalPages(); i++)
                        pages[j++]=i;
                }else{
                    for(int i=page-3; i<(page+4); i++)
                        pages[j++]=i;
                }
            }
        }else {
            pages = new int[etudiantsList.getTotalPages()];
            for(int i=0; i<etudiantsList.getTotalPages(); i++)
                pages[i]=i;
        }
        model.addAttribute("pages", pages );
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("keyword", keyword);
        model.addAttribute("maxPages", etudiantsList.getTotalPages());
        return "pages/etudiants/list";
    }

}

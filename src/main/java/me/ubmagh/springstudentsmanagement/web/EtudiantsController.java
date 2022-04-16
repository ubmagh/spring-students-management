package me.ubmagh.springstudentsmanagement.web;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import me.ubmagh.springstudentsmanagement.entities.Etudiant;
import me.ubmagh.springstudentsmanagement.services.EtudiantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@Controller
// url mapping is prefixed with /etudiants
public class EtudiantsController {

    @Autowired
    private EtudiantServiceImpl etudiantService;

    @GetMapping("/etudiants")
    public String liste( Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size,
                         @RequestParam(value = "keyword", defaultValue = "") String keyword,
                         @RequestParam(value = "added", defaultValue = "false") String added,
                         @RequestParam(value = "updated", defaultValue = "false") String updated
    ){
        Page<Etudiant> etudiantsList = etudiantService.findByNomOrPrenom( keyword, PageRequest.of(page, size));
        model.addAttribute("etudiants", etudiantsList.getContent() );
        model.addAttribute("tab", "etudiants");
        model.addAttribute("added", added);
        model.addAttribute("updated", updated);
        if( page<0 )
            page = 0;

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
        if( etudiantsList.getContent().size()==0 && page>1)
            return this.liste( model, page-1, size, keyword, added, updated );
        return "pages/etudiants/list";
    }

    @GetMapping("/etudiants/new")
    public String add( Model model){
        model.addAttribute("tab", "etudiants");
        model.addAttribute("etudiant", new Etudiant() );
        return "pages/etudiants/create_form";
    }

    @PostMapping("/etudiants/new")
    public String save(Model model, @Valid Etudiant etudiant, BindingResult bindingResult){
        model.addAttribute("tab", "etudiants");
        model.addAttribute("etudiant", etudiant );
        if(bindingResult.hasErrors())
            return "pages/etudiants/create_form";
        etudiantService.createEtudiant(etudiant);
        return "redirect:/etudiants?added=true";
    }


    @GetMapping("/etudiants/{id}")
    public String edit(Model model, @PathVariable String id,
                       @RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "size", defaultValue = "10") int size,
                       @RequestParam(value = "keyword", defaultValue = "") String keyword){
        model.addAttribute("tab", "etudiants");
        Etudiant et = etudiantService.findById( id);
        if ( et==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Etudiant introuvable");
        model.addAttribute("etudiant", et );
        model.addAttribute("page", page );
        model.addAttribute("size", size );
        model.addAttribute("keyword", keyword );
        return "pages/etudiants/edit_form";
    }


    @PostMapping("/etudiants/put")
    public String put(Model model, @Valid Etudiant etudiant, BindingResult bindingResult,
                      @RequestParam(value = "page", defaultValue = "0") int page,
                      @RequestParam(value = "size", defaultValue = "10") int size,
                      @RequestParam(value = "keyword", defaultValue = "") String keyword){
        model.addAttribute("tab", "etudiants");
        model.addAttribute("etudiant", etudiant );
        model.addAttribute("page", page );
        model.addAttribute("size", size );
        model.addAttribute("keyword", keyword );
        if(bindingResult.hasErrors())
            return "pages/etudiants/edit_form";
        etudiantService.save(etudiant);
        return "redirect:/etudiants?updated=true&page="+page+"&size="+size+"&keyword="+keyword;
    }


    @DeleteMapping("/etudiants/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        Etudiant et = etudiantService.findById( id);
        if ( et==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Etudiant introuvable");
        etudiantService.deleteById(id);
    }


}

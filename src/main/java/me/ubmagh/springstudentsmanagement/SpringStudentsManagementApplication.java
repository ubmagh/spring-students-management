package me.ubmagh.springstudentsmanagement;

import me.ubmagh.springstudentsmanagement.entities.Etudiant;
import me.ubmagh.springstudentsmanagement.entities.GenresEnum;
import me.ubmagh.springstudentsmanagement.helpers.HelperFunctions;
import me.ubmagh.springstudentsmanagement.services.EtudiantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringStudentsManagementApplication {

    @Autowired
    EtudiantServiceImpl etudiantService;

    public static void main(String[] args) {
        SpringApplication.run(SpringStudentsManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner runner (){
        return args -> {
            Etudiant et1 = new Etudiant( null, "MAGHDAOUI", "Ayoub", "ayoub@ayoub.me", HelperFunctions.parseDate("2000-06-01"), GenresEnum.MASCULIN, false),
                    et2 = new Etudiant( null, "ALLAT", "Mouad", "mouad@mouad.me", HelperFunctions.parseDate("2000-01-01"), GenresEnum.MASCULIN, true),
                    et3 = new Etudiant( null, "GHalbz", "Hassan", "ayoub@ayoub.me", HelperFunctions.parseDate("2000-04-01"), GenresEnum.MASCULIN, false);

            Stream.of( et1, et2, et3).forEach(et-> etudiantService.createEtudiant(et) );

        };
    }
}

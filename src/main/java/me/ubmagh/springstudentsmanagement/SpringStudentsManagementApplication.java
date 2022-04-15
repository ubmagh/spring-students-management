package me.ubmagh.springstudentsmanagement;

import com.github.javafaker.Faker;
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

    // @Bean
    CommandLineRunner data_with_faker (){
        Faker faker = new Faker();
        return args -> {
            int nbr_etud = 77;
            while ( nbr_etud-->0 )
                etudiantService.createEtudiant(
                        new Etudiant( null, faker.name().lastName(), faker.name().firstName(), faker.internet().emailAddress(), faker.date().birthday( 14, 20), faker.options().option(GenresEnum.class), faker.bool().bool() )
                );
        };
    }

    CommandLineRunner basic_data (){
        return args -> {
            Etudiant et1 = new Etudiant( null, "MAGHDAOUI", "Ayoub", "ayoub@ayoub.me", HelperFunctions.parseDate("2000-06-01"), GenresEnum.MASCULIN, false),
                    et2 = new Etudiant( null, "ALLAT", "Mouad", "mouad@mouad.me", HelperFunctions.parseDate("2000-01-01"), GenresEnum.MASCULIN, true),
                    et3 = new Etudiant( null, "GHalbz", "Hassan", "ayoub@ayoub.me", HelperFunctions.parseDate("2000-04-01"), GenresEnum.MASCULIN, false);

            Stream.of( et1, et2, et3).forEach(et-> etudiantService.createEtudiant(et) );

        };
    }
}

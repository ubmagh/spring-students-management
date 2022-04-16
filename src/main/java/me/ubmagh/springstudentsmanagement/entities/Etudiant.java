package me.ubmagh.springstudentsmanagement.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Etudiant {

    @Id
    private String id;

    @Size(min = 3, max = 50, message = "Le nom doit avoir une longueur entre 3 et 50")
    private String nom;
    @Size(min = 3, max = 50, message = "Le prenom doit avoir une longueur entre 3 et 50")
    private String prenom;
    @Email(message = "Adresse email invalide")
    @NotEmpty(message = "Saisissez l'adresse email ! ")
    private String email;

    @Past(message = "Date de naissance invalide !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Date de  naissance obligatoire !")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Saisissez le sexe !")
    private GenresEnum genre;

    @NotNull(message = "Valeur invalide !")
    private boolean enRegle;

}

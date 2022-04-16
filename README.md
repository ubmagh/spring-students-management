# spring-students-management

Application JEE en spring pour gérer les étudiant.

<div style="text-align: center;">
<img src="./assets/ennoncé.png" width="450">
</div>

# Réalisation :

<br/>

> ## 1- Initialisation du projet :

* Avec intellij j'ai créer ce projet avec les dépendences suivantes : 

<img src="./assets/1.png" width="350">

<br/>

> ## 2- Saisir la configuration du projet :

* Dans `ressources/application.properties` j'ai saisi la configuration de l'application : configuration de la base de données, le port ...

<img src="./assets/2.png" width="350">

<br/>

> ## 3- Créer l'entité Etudiant : 

* Création de l'entité `entities/Etudiant` avec l'enumeration `entities/GenresEnum` pour l'attribut genre de l'Etudiant.

<img src="./assets/3.png" width="350">

<img src="./assets/4.png" width="350">


<br/>

> ## 4- Créer le repository de l'entité etudiant :

* Création du repository `repositories/EtudiantRepository`, avec une méthode qui sera utilisée lors de la recherche par nom.

<img src="./assets/5.png" width="350">


<br/>

> ## 5- Créer l'interface service et son implementation  :

* Créé l'interface `services/IEtudiantService`

<img src="./assets/6.png" width="350">


* et son implémentation `services/EtudiantServiceImpl`

<img src="./assets/7.png" width="350">

<br/>

> ## 6- Ajouter Bootstrap & JQuery comme dépendences

* Ajouter ces dépendences dans le fichier `pom.xml` 

<img src="./assets/8.png" width="350">


<br/>

> ## 7- Créer le controlleur web + les templates (views)

* Le controlleur `web/MainController` 

<img src="./assets/9.png" width="350">

* Le template de base `resources/templates/layouts/BaseLayout.html` : 

<img src="./assets/10.png" width="350">

* Le template (view) de la page principale (index) `resources/templates/pages/home.html` :

<img src="./assets/11.png" width="350">

* j'ai aussi ajouté des fichiers ressources dans le chemin des ressources statiques :

<img src="./assets/12.png" width="350">


<br/>

> ## 8- Configuration du package Spring Security

* L'application necéssite une configuration de sécurité, pour pouvoir accéder à la page principale index, pour cela j'ai créé la class `security/SecurityConfiguration`

<img src="./assets/13.png" width="350">

* J'ai découvert que l'application manque les dépendances de thymeleaf, je les ai ajoutés : 

<img src="./assets/14.png" width="350">

* Après avoir lancé l'application, voici la page principale sur le navigateur :

<img src="./assets/15.png" width="550">


<br/>

> ## 9- Ajouter des données à la BD :

* Pour ajouter des données fictives à la BD, j'ai créé la fonction BEAN suivante dans le programme principal de l'app : 

<img src="./assets/16.png" width="550">

* voici le contenu de la table `etudiant` dans la BD

<img src="./assets/17.jpg" width="550">




<br/>

> ## 10- Ajouter le package faker  :

* Pour générer des données nombreuses et adéquates, j'ai installé faker :

<img src="./assets/18.png" width="400">

* et j'ai mis à jour la fonction BEAN dans le programme pricipal : 

<img src="./assets/19.png" width="550">

* voici le contenu de la table `etudiant` dans la BD

<img src="./assets/20.png" width="400">


<br/>

> ## 11- Ajouter le package spring-boot-devtools  :

* pour eviter de redémarrer à chaque modification l'application.

<img src="./assets/21.png" width="350">




<br/>

> ## 12- La page d'acceuil et la page contennant la liste des étudiants

* la page d'acceuil contient une zone de text pour rechercher un étudiant, la recherche est redirigée vers la liste des étudiants.

<img src="./assets/22.png" width="600">

* J'ai créé le controlleur `web/EtudiantController` qui va s'occuper de toutes les pages en relation avec l'entité `Etudiant`, toutes ses routes vont etre préfixées par `/etudiants`.
* J'ai créé dedans une fonction qui va retourner le template de la liste des étudiants paginée

<img src="./assets/23.png" width="350">

* Ensuite, j'ai créé le template (view) `resources/templates/pages/etudiants/list.html` :

<img src="./assets/24.png" width="350">

* voici le rendu de la liste des étudiants :

<img src="./assets/25.png" width="600">


<br/>

> ## 13- La page d'insértion d'un nouveau étudiant

* intaller d'abord la dependance de validation

<img src="./assets/32.png" width="400">

* Ajouter les annotations de validation à l'entité `Etudiant` : 

<img src="./assets/26.png" width="400">

* créer la fonction `add` sur le controlleur `web/EtudiantController` qui va retourner le formulaire pour créer le nouveau étudiant :

<img src="./assets/27.png" width="400">

* Créé le template (view) du formulaire sur le chemin `resource/pages/etudiants/create_form.html` : :

<img src="./assets/28.png" width="400">

* en accédant sur le chemin `localhost:8080/etudiants/new`, voici ce que s'affiche : 

<img src="./assets/29.png" width="600">

* Ensuite, j'ai créé la fonction (la route) pour traiter le formulaire envoyé : 

<img src="./assets/30.png" width="350">

* Après l'insertion (sans erreurs dans la validation), une redirection vers la liste des étudiants occure : 

<img src="./assets/31.png" width="600">


<br/>

> ## 14- Modifier les étudiants

* créer la fonction `edit` sur le controlleur `web/EtudiantController` qui va retourner le formulaire pour modifier l'étudiant par son id :

<img src="./assets/33.png" width="400">

* Créé le template (view) du formulaire sur le chemin `resource/pages/etudiants/edit_form.html` : :

<img src="./assets/34.png" width="400">

* en accédant sur le chemin `localhost:8080/etudiants/562a2a46-59f3-4217-92af-d142098f226e`, voici ce que s'affiche :

<img src="./assets/35.png" width="600">

* mettre à jour la liste des étudiants avec un bouton de modification pour chaque ligne :

<img src="./assets/36.png" width="600">


* créer la fonction `put` sur le controlleur `web/EtudiantController` qui va retourner le formulaire traiter le formulaire et sauvegarder les changements :

<img src="./assets/37.png" width="400">





<br/>

> ## 15- Supprimer les étudiants

* créer la fonction `delete` sur le controlleur `web/EtudiantController` qui va supprimer l'étudiant par son id :

<img src="./assets/38.png" width="400">

* Pour résoudre les contraintes de sécurité pour éffectuer la suppression, j'ai désactivé la vérification CSRF :

<img src="./assets/39.png" width="400">

* Ensuite j'ai ajouté sur la liste des étudiants le bouton de suppression et une boite de dialog de confirmation, ainsi le code javascript(JQuery) pour envoyer la requette ajax de suppression :

<img src="./assets/40.png" width="450">

<img src="./assets/41.png" width="450">



<br/>
<br/>

> ## Fin .
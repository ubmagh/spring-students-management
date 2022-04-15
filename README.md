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

* pour eviter de redémarrer à chaque modification toute l'app.

<img src="./assets/21.png" width="350">




<br/>
<br/>

> ## Fin .
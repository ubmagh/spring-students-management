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



<br/>
<br/>

## > Fin .
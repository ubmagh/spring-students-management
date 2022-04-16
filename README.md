# spring-students-management

Application JEE en spring pour gérer les étudiant.

<div style="text-align: center;">
<img src="./assets/ennoncé.png" width="450">
</div>

# Rapport :

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

> ## 16- Sécuriser l'accès à l'application avec un système d'authentification basé sur Spring security en utilisant la stratégie UseDetails Service


* Créer les deux entités : `security/entities/AppUser` & `security/entities/AppRole`

<img src="./assets/42.png" width="450">

<img src="./assets/43.png" width="450">

* Créer les deux répositories pour les deux entités précédentes dans le package `security/repositories` :

<img src="./assets/44.png" width="450">

<img src="./assets/45.png" width="450">

* Créer et implémenter l'interface (service) `security/services/ISecurityService` :

<img src="./assets/46.png" width="450">

<img src="./assets/47.png" width="450">

* Implémenter l'interface `UserDetailsService`, et défninir comment les 'utilisateurs sont chargés :

<img src="./assets/48.png" width="500">

* Dans la configuration de Spring Security, j'ai précisé l'utilisation de la stratégie user-details en passant l'objet de `UserDetailsService`, et j'ai mis à jour les droits d'accès tel que seules les ressources statiques (webjars & css & js & images) et les deux pages accueil & liste des étudiants, qui sont accessibles par le public :

<img src="./assets/49.png" width="700">

* Dans le programme principal, j'ai défini la fonction BEAN qui va fournir à l'application toujours un PasswordEncoder de type `BCryptPasswordEncoder` pour Hasher les mots de passe, et une deuxième fonction BEAN pour créer deux premiers utilisateurs avec deux roles `ADMIN` & `USER` : 

<img src="./assets/50.png" width="700">


* Au relancement de l'application, trois nouvelles tables sont crées, avec les données dedans :

<img src="./assets/51.png" width="350">  |  <img src="./assets/52.png" width="350">  |  <img src="./assets/53.png" width="350">

* J'ai revenu sur la configuration de sécurité pour mettre à jour les droits d'accès : 

<img src="./assets/54.png" width="700">

* Ensuite, j'ai créé la classe de configuration `security/MethodSecurityConfig` pour activer l'utilisation des annotation pour sécuriser l'accès aux routes [voir ce lien](https://www.baeldung.com/spring-security-method-security) :

<img src="./assets/55.png" width="350">

* Et enfin pour chaque route dans le controlleur `web/EtudiantsController` j'ai spécifié quel utilisateur peut y accéder avec l'annotation `@PreAuthorize()` : 

<img src="./assets/56.png" width="400">

* Ajouter le package `thymeleaf-extras-springsecurity5` pour avoir un contexte de sécurité dans les template :

<img src="./assets/57.png" width="400">

* j'ai fait les changements sur les templates qui sont adéquats à ces modifications de sécurité, voici la page de la liste des étudiants ( utilisateur authentifié : admin) : 

<img src="./assets/58.png" width="700">

* La page de la liste des étudiants ( utilisateur authentifié : user) :

<img src="./assets/59.png" width="700">



<br/>

> ## 17- D'autres fonctionnalités :

* Ajout d'une page personnalisée pour l'erreur HTTP:403 (forbidden), lors d'un accès non authorisé et une pour l'erreur HTTP:404 page introuvable. ces deux pages sont placées dans le chemin `templates/pages/errors/`:

  * pour ça j'ai créé le controlleur qui permet de gérer les errerurs HTTP : 

    <img src="./assets/60.png" width="700">

  * et j'ai créé les templates nécessaires dans le chemin `resources/pages/errors` :
    
    <img src="./assets/61.png" width="400">
  
* Ajout d'une page personnalisée login :
  * modifier la configuration de spring sécurité :
    <img src="./assets/62.png" width="400">
  * ensuite, j'ai créé le controlleur `security/SecurityController` pour retourner la page login pour toute requette GET vers le chemin 'GET' :
    <img src="./assets/63.png" width="700">
  * et enfin j'ai créé le template  `resources/pages/security/login.html`
    <img src="./assets/64.png" width="400">
  * Voici la page de login ;
    <img src="./assets/65.png" width="700">



<br/>
<br/>
<br/>

> ## Fin 👾 . 

[ Bonus ](https://youtu.be/m4-HM_sCvtQ)

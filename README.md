# TP Rest Controller Pokemon – Groupe 2

## À propos du projet

L'objectif de cette API va être de gérer des pokemons, leurs dresseurs, des types de pokemon, leurs espèces, les attaques et enfin les objets que peuvent acheter les dresseurs.

L'API va permettre à travers chaque Controlleur qui correspondra à sa classe (PokemonControlleur, par exemple) de créer, éditer et supprimer les entités en base de données.

## Création des branches et nommage des commits

**Langue à respecter pour le nommage** : `Français` -> Par exemple : `Ajout : Classe Pokemon pour la persister en base`

- Ajout : ajout d'une nouvelle fonctionnalité.
- Modification : modification d'une fonctionnalité déjà implémentée en précisant la modification apportée.
- Refacto : refactoring de code, de nommage. Ce qui modifie le code sans ajouter de fonctionnalités ou corriger de bugs.
- Fix : correction de bug.

Les noms des branches devront être en lien avec les prénoms des personnes qui les gèrent :

(yannis)

Pour le nommage des commits, il faut respecter ce nommage afin que ce soit homogène :

[Ajout, Modification, Refacto, Fix] : [message explicite court]

Exemple, si je veux ajouter un commit car j'ai développé une nouvelle classe -> 
`Ajout : Classe Pokemon pour la persisté en base`

---

## Nommage des classes et des fichiers

**Langue à respecter pour le nommage** : `Français` -> par exemple : PokemonControlleur

- Le nom des fichiers devra avoir un nommage de type Pascal Case : NomFichier


- Le nom des classes devra avoir un nommage de type Pascal Case: NomDeMaClasse


- Le nom des fonctions devra avoir un nommage de type Camel Case : nomDeMaFonction


- Le nom des constantes devra avoir un nommage de type Upper Case : NOMDECONSTANTE


- Le nom des variables devra avoir un nommage de type Camel Case : nomVariable

## Nommage pour les toString()

Pour le nommage des toString(), il faut respecter ce nommage afin que ce soit homogène :

```java
@Override
public String toString() {
    return "NomClasse(attribut1=..., attribut2=...)";
}
```

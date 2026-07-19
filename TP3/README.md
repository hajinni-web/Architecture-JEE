TP3 — Application Web Spring Boot

# Technologies utilisées

# Fonctionnalités

- Authentification des utilisateurs
- Gestion des rôles USER / ADMIN
- Liste des produits
- Recherche par nom
- Pagination
- Ajout d'un produit
- Modification d'un produit
- Suppression d'un produit
- Validation des formulaires
- Déconnexion
- Gestion de la page d'accès refusé (403)


# Structure du projet

```
src
│
├── main
│   ├── java
│   │
│   ├── entities
│   ├── repositories
│   ├── security
│   ├── web
│   └── SpringMvcApplication
│
└── resources
    ├── templates
    ├── static
    └── application.properties
```

---

# Comptes de connexion

| Utilisateur | Mot de passe | Rôle |
|-------------|--------------|------|
| admin | 1234 | ADMIN |
| user1 | 1234 | USER |
| user2 | 1234 | USER |

---

# Captures d'écran

## 1. Page de connexion

img width="654" height="592" alt="image" src="https://github.com/user-attachments/assets/23880387-0704-4989-b432-18f3ae2d026a" />

---

## 2. Liste des produits

<img width="945" height="384" alt="image" src="https://github.com/user-attachments/assets/20614dea-7a82-47f9-9efb-851ad07a0cb2" />


## 4. Ajout d'un produit

<img width="945" height="733" alt="image" src="https://github.com/user-attachments/assets/66ab0925-b62b-4e41-8a34-c9d427c71868" />

## 8. Accès refusé (403)

<img width="945" height="696" alt="image" src="https://github.com/user-attachments/assets/e8773b87-e8c1-4a13-b47f-d55c89392767" />


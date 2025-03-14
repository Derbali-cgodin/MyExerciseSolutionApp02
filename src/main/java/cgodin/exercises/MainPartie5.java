package cgodin.exercises;

import cgodin.exercises.dao.EtudiantDAO;
import cgodin.exercises.entities.Etudiant;

import java.util.List;
import java.util.Scanner;

public class MainPartie5 {
    public static void main(String[] args) {
        EtudiantDAO etudiantDAO = new EtudiantDAO();
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n=== Menu Gestion des Étudiants ===");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Afficher tous les étudiants");
            System.out.println("3. Modifier un étudiant");
            System.out.println("4. Supprimer un étudiant");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option : ");

            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide !");
                scanner.next();
            }
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            switch (choix) {
                case 1:
                    ajouterEtudiant(etudiantDAO, scanner);
                    break;
                case 2:
                    afficherEtudiants(etudiantDAO);
                    break;
                case 3:
                    modifierEtudiant(etudiantDAO, scanner);
                    break;
                case 4:
                    supprimerEtudiant(etudiantDAO, scanner);
                    break;
                case 5:
                    System.out.println("Fermeture du programme...");
                    break;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        } while (choix != 5);

        scanner.close();
    }

    // Méthode pour ajouter un étudiant
    private static void ajouterEtudiant(EtudiantDAO dao, Scanner scanner) {
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Email : ");
        String email = scanner.nextLine();
        System.out.print("Âge : ");
        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un âge valide !");
            scanner.next();
        }
        int age = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante

        Etudiant etudiant = new Etudiant(nom, email, age);
        dao.ajouterEtudiant(etudiant);
    }

    // Méthode pour afficher tous les étudiants
    private static void afficherEtudiants(EtudiantDAO dao) {
        List<Etudiant> etudiants = dao.lireEtudiants();
        if (etudiants.isEmpty()) {
            System.out.println("Aucun étudiant trouvé.");
        } else {
            System.out.println("\nListe des étudiants :");
            for (Etudiant e : etudiants) {
                System.out.println(e);
            }
        }
    }

    // Méthode pour modifier un étudiant
    private static void modifierEtudiant(EtudiantDAO dao, Scanner scanner) {
        System.out.print("ID de l'étudiant à modifier : ");
        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un ID valide !");
            scanner.next();
        }
        int id = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante

        System.out.print("Nouveau nom : ");
        String nom = scanner.nextLine();
        System.out.print("Nouvel email : ");
        String email = scanner.nextLine();
        System.out.print("Nouvel âge : ");
        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un âge valide !");
            scanner.next();
        }
        int age = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante

        Etudiant etudiant = new Etudiant(nom, email, age);
        dao.mettreAJourEtudiant(id, etudiant);
    }

    // Méthode pour supprimer un étudiant
    private static void supprimerEtudiant(EtudiantDAO dao, Scanner scanner) {
        System.out.print("ID de l'étudiant à supprimer : ");
        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un ID valide !");
            scanner.next();
        }
        int id = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante

        dao.supprimerEtudiant(id);
    }
}

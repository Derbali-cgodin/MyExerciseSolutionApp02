package cgodin.exercises;

import cgodin.exercises.dao.EtudiantDAO;
import cgodin.exercises.entities.Etudiant;

import java.util.List;

public class MainPartie4 {

    public static void main(String[] args) {
        EtudiantDAO etudiantDAO = new EtudiantDAO();

        // Ajouter des étudiants
        //etudiantDAO.ajouterEtudiant(new Etudiant("Paul Dupont", "paul.dupont@example.com", 23));
       //etudiantDAO.ajouterEtudiant(new Etudiant("Marie Curie", "marie.curie@example.com", 25));

        // Lire et afficher les étudiants
        List<Etudiant> etudiants = etudiantDAO.lireEtudiants();
        System.out.println("Liste des étudiants :");
        for (Etudiant e : etudiants) {
            System.out.println(e);
        }

        // Mettre à jour un étudiant (changer l'âge de Paul Dupont)
        //etudiantDAO.mettreAJourEtudiant(4, new Etudiant("Paul Dupont", "paul.dupont@example.com", 26));

        // Supprimer un étudiant
        //etudiantDAO.supprimerEtudiant(5);

        // Lire à nouveau pour vérifier les modifications
        System.out.println("Après modifications :");
        etudiants = etudiantDAO.lireEtudiants();
        for (Etudiant e : etudiants) {
            System.out.println(e);
        }
    }
}

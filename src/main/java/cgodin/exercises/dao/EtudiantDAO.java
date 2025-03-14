package cgodin.exercises.dao;

import cgodin.exercises.entities.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO {
    private static final String URL = "jdbc:mysql://mysql-myderbaliplan.alwaysdata.net:3306/myderbaliplan_db";
    private static final String USER = "404056_teacher";  // Remplacez par votre utilisateur MySQL
    private static final String PASSWORD = "Cgodin2025";  // Remplacez par votre mot de passe

    // Ajouter un étudiant
    public void ajouterEtudiant(Etudiant etudiant) {
        String sql = "INSERT INTO etudiants (nom, email, age) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, etudiant.getNom());
            pstmt.setString(2, etudiant.getEmail());
            pstmt.setInt(3, etudiant.getAge());
            pstmt.executeUpdate();
            System.out.println("Étudiant ajouté avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout : " + e.getMessage());
        }
    }

    // Lire tous les étudiants
    public List<Etudiant> lireEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();
        String sql = "SELECT * FROM etudiants";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Etudiant etudiant = new Etudiant(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("email"),
                        rs.getInt("age")
                );
                etudiants.add(etudiant);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la lecture : " + e.getMessage());
        }
        return etudiants;
    }

    // Mettre à jour un étudiant
    public void mettreAJourEtudiant(int id, Etudiant etudiant) {
        String sql = "UPDATE etudiants SET nom = ?, email = ?, age = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, etudiant.getNom());
            pstmt.setString(2, etudiant.getEmail());
            pstmt.setInt(3, etudiant.getAge());
            pstmt.setInt(4, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Étudiant mis à jour !");
            else System.out.println("Aucun étudiant trouvé avec cet ID.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour : " + e.getMessage());
        }
    }

    // Supprimer un étudiant
    public void supprimerEtudiant(int id) {
        String sql = "DELETE FROM etudiants WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Étudiant supprimé !");
            else System.out.println("Aucun étudiant trouvé avec cet ID.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression : " + e.getMessage());
        }
    }
}

package cgodin.exercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainPartie2 {
    private static final String URL = "jdbc:mysql://mysql-myderbaliplan.alwaysdata.net:3306/myderbaliplan_db";
    private static final String USER = "404056_teacher";  // Remplacez par votre utilisateur MySQL
    private static final String PASSWORD = "Cgodin2025";  // Remplacez par votre mot de passe

    public static Connection getConnection() {
        try {
            // Charger le driver (optionnel pour les nouvelles versions de Java)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir la connexion
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie !");
            return connection;
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC introuvable : " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erreur de connexion : " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        // Tester la connexion
        getConnection();
    }
}

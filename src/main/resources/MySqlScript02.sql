-- 1. Créer la base de données
CREATE DATABASE IF NOT EXISTS gestion_etudiants;

-- 2. Utiliser la base de données
USE gestion_etudiants;

-- 3. Créer la table etudiants
CREATE TABLE IF NOT EXISTS etudiants (
                                         id INT AUTO_INCREMENT PRIMARY KEY,
                                         nom VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    age INT CHECK (age >= 0)
    );

-- 4. Insérer des enregistrements dans la table etudiants
INSERT INTO etudiants (nom, email, age) VALUES
                                            ('Alice Dupont', 'alice.dupont@example.com', 22),
                                            ('Jean Martin', 'jean.martin@example.com', 24),
                                            ('Sophie Durand', 'sophie.durand@example.com', 21);

-- 5. Vérifier les données insérées
SELECT * FROM etudiants;

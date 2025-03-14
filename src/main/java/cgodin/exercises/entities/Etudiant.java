package cgodin.exercises.entities;

public class Etudiant {
    private int id;
    private String nom;
    private String email;
    private int age;

    // Constructeurs
    public Etudiant() {}

    public Etudiant(int id, String nom, String email, int age) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.age = age;
    }

    public Etudiant(String nom, String email, int age) {
        this.nom = nom;
        this.email = email;
        this.age = age;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "Etudiant{id=" + id + ", nom='" + nom + "', email='" + email + "', age=" + age + "}";
    }
}

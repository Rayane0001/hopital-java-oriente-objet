public abstract class Personne {
    // Déclaration des variables d'instance.
    private String nom, prenom, adresse, ville, codePostal;
    private int age;

    // Constructeur de la classe Personne.
    public Personne(String nom, String prenom, String adresse, String ville, String codePostal, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.age = age;
    }

    // Getters et setters pour les variables d'instance.
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getVille() {
        return ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public int getAge() {
        return age;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

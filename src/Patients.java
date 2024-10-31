// La classe Patients hérite de la classe Personne
public class Patients extends Personne{
    // Déclaration de la variable d'instance numeroSecuriteSociale
    private String numeroSecuriteSociale;

    // Constructeur de la classe Patients
    public Patients(String nom, String prenom, String adresse, String ville, String codePostal, String numeroSecuriteSociale, int age) {
        // Appel au constructeur de la classe parente Personne
        super(nom, prenom, adresse, ville, codePostal, age);
        // Initialisation de la variable d'instance numeroSecuriteSociale
        this.numeroSecuriteSociale = numeroSecuriteSociale;
    }

    // Redéfinition de la méthode toString() de la classe Object
    @Override
    public String toString(){
        return "%s %s - %s, %s %s - %s - %d ans".formatted(this.getNom(), this.getPrenom(), this.getAdresse(), this.getVille(), this.getCodePostal(), numeroSecuriteSociale, this.getAge());
    }

    // Getter pour le numéro de sécurité sociale
    public String getNumeroSecuriteSociale() {
        return numeroSecuriteSociale;
    }

    public void setNumeroSecuriteSociale(String numeroSecuriteSociale) {
        this.numeroSecuriteSociale = numeroSecuriteSociale;
    }
}

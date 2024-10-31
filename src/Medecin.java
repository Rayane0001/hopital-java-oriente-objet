public class Medecin extends Personne {
    // Déclaration des variables d'instance
    private String specialisation, numeroTel;

    // Constructeur de la classe Medecin
    public Medecin(String nom, String prenom, String adresse, String ville, String codePostal, String specialisation, int age, String numeroTel){
        super(nom, prenom, adresse, ville, codePostal, age);
        this.specialisation=specialisation;
        this.numeroTel = numeroTel;
    }

    // Getter pour la spécialisation du médecin
    public String getSpecialisation(){
        return specialisation;
    }

    // Méthode pour convertir l'objet Medecin en chaîne de caractères
    @Override
    public String toString(){
        return "%s %s - %s, %s %s - %s - %d ans - %s".formatted(this.getNom(), this.getPrenom(), this.getAdresse(), this.getVille(), this.getCodePostal(), specialisation, this.getAge(), numeroTel);
    }


    public String getNumeroTel() {
        return numeroTel;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }
}

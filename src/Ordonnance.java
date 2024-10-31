import java.time.LocalDate;

public class Ordonnance {
    // Déclaration des variables d'instance
    private Patients patient; // Le patient à qui l'ordonnance est destinée
    private Medecin medecin; // Le médecin qui a rédigé l'ordonnance
    private String medicament; // Le médicament prescrit
    private String posologie; // La posologie du médicament
    private int dureeTraitement; // La durée du traitement en jours
    private LocalDate datePrescription; // La date de prescription de l'ordonnance

    // Constructeur de la classe Ordonnance
    public Ordonnance(Patients patient, Medecin medecin, String medicament, String posologie, int dureeTraitement, LocalDate datePrescription) {
        this.patient = patient;
        this.medecin = medecin;
        this.medicament = medicament;
        this.posologie = posologie;
        this.dureeTraitement = dureeTraitement;
        this.datePrescription = datePrescription;
    }

    // Méthode pour convertir l'ordonnance en chaîne de caractères

    public String toString() {
        return "Ordonnance pour " + patient.getNom() + " :\n" +
                "Médecin : " + medecin.getNom() + "\n" +
                "Médicament : " + medicament + "\n" +
                "Posologie : " + posologie + "\n" +
                "Durée du traitement : " + dureeTraitement + " jours\n" +
                "Date de prescription : " + datePrescription;
    }

    // Méthode pour vérifier si le traitement est terminé
    public boolean traitementTermine() {
        LocalDate dateFinTraitement = LocalDate.of(datePrescription.getYear(), datePrescription.getMonth(), datePrescription.getDayOfMonth() + dureeTraitement);
        LocalDate dateActuelle = LocalDate.now();

        if (dateActuelle.getYear() > dateFinTraitement.getYear()) {
            return true;
        } else if (dateActuelle.getYear() == dateFinTraitement.getYear()) {
            if (dateActuelle.getMonthValue() > dateFinTraitement.getMonthValue()) {
                return true;
            } else if (dateActuelle.getMonthValue() == dateFinTraitement.getMonthValue()) {
                return dateActuelle.getDayOfMonth() > dateFinTraitement.getDayOfMonth();
            }
        }
        return false;
    }

    // Getters et setters pour les variables d'instance
    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public String getPosologie() {
        return posologie;
    }

    public void setPosologie(String posologie) {
        this.posologie = posologie;
    }

    public int getDureeTraitement() {
        return dureeTraitement;
    }

    public void setDureeTraitement(int dureeTraitement) {
        this.dureeTraitement = dureeTraitement;
    }

    public LocalDate getDatePrescription() {
        return datePrescription;
    }

    public void setDatePrescription(LocalDate datePrescription) {
        this.datePrescription = datePrescription;
    }
}
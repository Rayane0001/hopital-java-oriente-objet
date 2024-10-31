 import java.time.LocalDateTime;

 public class Rdv {
     // Déclaration des variables d'instance
    private LocalDateTime dateRendezVous;
    private Medecin medecin;
    private Patients patient;
    private StatutRdv statut;

     // Ceci est le constructeur de la classe Rdv
    public Rdv(LocalDateTime dateRendezVous, Medecin medecin, Patients patient, StatutRdv statut) {
        this.dateRendezVous = dateRendezVous;
        this.medecin = medecin;
        this.patient = patient;
        this.statut = statut;
    }

    // Getters et setters
    public LocalDateTime getDateRendezVous() {
        return dateRendezVous;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public Patients getPatient() {
        return patient;
    }

    public StatutRdv getStatut() {
        return statut;
    }

    public void setDateRendezVous(LocalDateTime dateRendezVous) {
        this.dateRendezVous = dateRendezVous;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }
    public void setStatut(StatutRdv statut) {
        this.statut = statut;
    }

    // Initialisation de l'énumération StatutRdv pour les différents statuts d'un rendez-vous
    public enum StatutRdv { A_VENIR, PASSE, ANNULE }
}

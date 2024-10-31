public class Facturation{
    // Déclaration des variables d'instance
    private Patients patient;
    private Medecin medecin;
    private Rdv rdv;
    private double coutConsultation;
    private boolean estPaye;

    // Constructeur de la classe Facturation
    public Facturation(Patients patient, Medecin medecin, Rdv rdv, double coutConsultation, boolean estPaye) {
        this.patient = patient;
        this.medecin = medecin;
        this.rdv = rdv;
        this.coutConsultation = coutConsultation;
        this.estPaye = estPaye;
    }

    // Méthode pour générer la facture
    public void genererFacture() {
        System.out.println("Facture pour " + patient.getNom() + " :");
        System.out.println("Consultation avec " + medecin.getNom() + " le " + rdv.getDateRendezVous());
        System.out.println("Coût de la consultation : " + coutConsultation + " euros");
        System.out.println("Statut du paiement : " + (estPaye ? "Payé" : "Non payé"));
    }

    // Méthode pour payer la facture
    public void payerFacture() {
        this.estPaye = true;
    }

    // Getters et setters pour les variables d'instance
    public Patients getPatient() {
        return patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public Rdv getRdv() {
        return rdv;
    }

    public double getCoutConsultation() {
        return coutConsultation;
    }

    public boolean isEstPaye() {
        return estPaye;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public void setRdv(Rdv rdv) {
        this.rdv = rdv;
    }

    public void setCoutConsultation(int coutConsultation) {
        this.coutConsultation = coutConsultation;
    }

    public void setEstPaye(boolean estPaye) {
        this.estPaye = estPaye;
    }
}

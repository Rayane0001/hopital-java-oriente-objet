public class Feedback{
    // Déclaration des variables d'instance
    private String avis;
    private int note;
    private static final int NOTE_MAX = 10;
    private static final int NOTE_MIN =0;
    private Patients patient;
    private Medecin medecin;
    private static Feedback[] tousLesFeedbacks = new Feedback[100];
    private static int nbFeedbacks = 0;

    // Constructeur de la classe Feedback
    public Feedback(String avis, int note, Patients patient, Medecin medecin){
        this.avis = avis;
        this.note = note;
        this.patient = patient;
        this.medecin = medecin;
        // Ajout du feedback au tableau de tous les feedbacks
        if (nbFeedbacks < tousLesFeedbacks.length) {
            tousLesFeedbacks[nbFeedbacks] = this;
            nbFeedbacks++;
        } else {
            System.out.println("Plus d'espace pour de nouveaux feedbacks");
        }
    }

    // Méthode pour laisser un feedback
    public void laisserFeedback(String avis, int note, Patients patient, Medecin medecin) {
        // teste si les notes sont comprises entre les bornes
        if (note > NOTE_MAX) {
            System.out.println("La note ne peut pas dépasser " + NOTE_MAX);
        } else if (note < NOTE_MIN) {
            System.out.println("La note ne peut pas dépasser " + NOTE_MIN);
        } else {
            this.avis = avis;
            this.note = note;
        }
    }
    // Méthode pour obtenir tous les feedbacks
    public static Feedback[] getTousLesFeedbacks() {
        return tousLesFeedbacks;
    }

    // Méthode pour calculer la moyenne des notes d'un médecin
    public static double getMoyenneNotesMedecin(Medecin medecin) {
        int totalNotes = 0;
        int nombreFeedbacks = 0;
        for (int i = 0; i < nbFeedbacks; i++) {
            Feedback feedback = tousLesFeedbacks[i];
            if (feedback.getMedecin() == medecin) {
                totalNotes += feedback.getNote();
                nombreFeedbacks++;
            }
        }
        if (nombreFeedbacks == 0) {
            return 0;
        } else {
            return (double) totalNotes / nombreFeedbacks;
        }
    }
    // Getters et setters pour les variables d'instance
    public void setAvis(String avis) {
        this.avis = avis;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getAvis() {
        return avis;
    }

    public int getNote() {
        return note;
    }

    public Patients getPatient() {
        return patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public static int getNbFeedbacks() {
        return nbFeedbacks;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public static void setTousLesFeedbacks(Feedback[] tousLesFeedbacks) {
        Feedback.tousLesFeedbacks = tousLesFeedbacks;
    }

    public static void setNbFeedbacks(int nbFeedbacks) {
        Feedback.nbFeedbacks = nbFeedbacks;
    }
}




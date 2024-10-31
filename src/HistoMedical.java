public class HistoMedical {
    // Déclaration des variables d'instance
    private Rdv[] listeRdvs; // Liste des rendez-vous du patient
    private Ordonnance[] listeOrdos; // Liste des ordonnances du patient
    public static final int MAX_TABL = 999; // Taille maximale des tableaux
    private int nbRdvs, nbOrdos; // Compteurs du nombre de rendez-vous et d'ordonnances
    private Patients patient; // Le patient concerné par l'historique médical

    // Constructeur de la classe HistoMedical
    public HistoMedical(Patients patient) {
        this.patient = patient;
        this.listeRdvs = new Rdv[MAX_TABL];
        this.nbRdvs = 0;
        this.listeOrdos = new Ordonnance[MAX_TABL];
        this.nbOrdos = 0;
    }

    // Méthode pour ajouter un rendez-vous à l'historique
    public void ajouterRdv(Rdv rdv) {
        if (nbRdvs < MAX_TABL) {
            listeRdvs[nbRdvs++] = rdv;
        }
    }

    // Méthode pour ajouter une ordonnance à l'historique
    public void ajouterOrdo(Ordonnance ordo) {
        if (nbOrdos < MAX_TABL) {
            listeOrdos[nbOrdos++] = ordo;
        }
    }

    // Méthode pour afficher l'historique médical du patient
    public void afficherHistorique() {
        System.out.println("Historique des RDVs pour " + patient.getNom() + " :");
        for (int i = 0; i < nbRdvs; i++) {
            System.out.println(listeRdvs[i].getDateRendezVous() + " avec " + listeRdvs[i].getMedecin().getNom());
        }

        System.out.println("Historique des ordonnances pour " + patient.getNom() + " :");
        for (int i = 0; i < nbOrdos; i++) {
            System.out.println(listeOrdos[i].getMedicament() + " prescrit par " + listeOrdos[i].getMedecin().getNom());
        }
    }
}

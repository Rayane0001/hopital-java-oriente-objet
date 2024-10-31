import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.*;

public class Clinique {
    private static final int maxTailleTableau = 999;

    public static Medecin getMedecinParNom(String nom, Medecin[] listeMedecins) {
        for (Medecin medecin : listeMedecins) {
            if (medecin != null && medecin.getNom().equalsIgnoreCase(nom)) {
                return medecin;
            }
        }
        return null;
    }

    public static Patients getPatientParNom(String nom, Patients[] listePatients) {
        for (Patients patient : listePatients) {
            if (patient != null && patient.getNom().equalsIgnoreCase(nom)) {
                return patient;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Patients[] listePatients = new Patients[maxTailleTableau];
        Medecin[] listeMedecins = new Medecin[maxTailleTableau];
        Ordonnance[] listeOrdonnances = new Ordonnance[maxTailleTableau];
        Rdv[] listeRdvs = new Rdv[maxTailleTableau];
        Facturation[] listeFacturations = new Facturation[maxTailleTableau];




        //   -------------------------------------
        //   |                TEST               |
        //  --------------------------------------



        // Création de plusieurs patients avec leurs informations personnelles
        Patients patient1 = new Patients("Dupont", "Jean", "1 rue de la Paix", "Paris", "75000", "53152437", 19);
        Patients patient2 = new Patients("Durand", "Marie", "2 rue de la Liberté", "Lyon", "69000", "53152438", 25);
        Patients patient3 = new Patients("Clément", "Goustiaux", "3 rue de la République", "Marseille", "13000", "53152439", 32);
        Patients patient4 = new Patients("Lefevre", "Sophie", "4 rue de la Mairie", "Toulouse", "31000", "53152440", 42);

        // Création de plusieurs médecins avec leurs informations personnelles
        Medecin medecin1 = new Medecin("Martin", "Pierre", "3 rue de la République", "Marseille", "13000", "Reins", 32, "53152439");
        Medecin medecin2 = new Medecin("Lefevre", "Sophie", "4 rue de la Mairie", "Toulouse", "31000", "Cancers", 42, "53152440");

        // Création de plusieurs rendez-vous avec les informations correspondantes
        Rdv rdv1 = new Rdv(LocalDateTime.of(2021,12,7,12,0), medecin1, patient1, Rdv.StatutRdv.A_VENIR);
        Rdv rdv3 = new Rdv(LocalDateTime.of(2023,12,8,16,0), medecin1, patient1, Rdv.StatutRdv.PASSE);
        Rdv rdv2 = new Rdv(LocalDateTime.of(2021,12,7,14,0), medecin2, patient2, Rdv.StatutRdv.PASSE);

        // Création de plusieurs ordonnances avec les informations correspondantes
        Ordonnance ordo1 = new Ordonnance(patient1, medecin1, "Aspirine", "1 comprimé par jour", 7, LocalDate.of(2020, 2, 12));
        Ordonnance ordo2 = new Ordonnance(patient2, medecin2, "Doliprane", "2 comprimés par jour", 10, LocalDate.of(2020, 3, 15));

        // Création de plusieurs factures avec les informations correspondantes
        Facturation facture1 = new Facturation(patient1, medecin1, rdv1, 50, false);
        Facturation facture2 = new Facturation(patient2, medecin2, rdv2, 60, true);

        // Création de plusieurs feedbacks avec les informations correspondantes
        Feedback feedback1 = new Feedback( "Très bon médecin, à l'écoute", 10, patient1,medecin1);
        Feedback feedback2 = new Feedback( "J'ai eu mal",0,patient2,medecin2);
        Feedback feedback3 = new Feedback( "attente plus longue que d'habitude", 8, patient2,medecin1);
        Feedback feedback4 = new Feedback( "On m'a facturé un smic...", 2, patient3,medecin1);

        // Affichage de la moyenne des notes d'un médecin
        System.out.println(Feedback.getMoyenneNotesMedecin(medecin1));




        //   -------------------------------------
        //   |                MENU               |
        //  --------------------------------------



        Scanner in = new Scanner(System.in);
        boolean enCoursExecution = true;
        while(enCoursExecution){
            System.out.println("===[Gestion des dossiers médicaux]===\n" + //
                               "Veuillez sélectionner une option :\n" + //
                               "1. Ajouter un patient \n"+
                               "2. Supprimer un patient \n"+
                               "3. Ajouter un médecin \n"+
                               "4. Supprimer un médecin \n"+
                               "5. Ajouter une ordonnance\n"+
                               "6. Supprimer une ordonnance\n"+
                               "7. Ajouter un rendez-vous\n"+
                               "8. Supprimer un rendez-vous\n"+
                               "9. Créer une facture\n"+
                               "10. Rechercher un patient\n"+
                               "11. Rechercher un médecin\n"+
                               "0. Quitter l'interface");

            int entree = in.nextInt();
            in.nextLine(); // consomme le '\n' laissé par nextInt()
            switch (entree) { //ajouter un patient
                case 1:
                    System.out.println("Entrez le nom, prénom, l'adresse, la ville, le code postal, le numéro de sécurité sociale ainsi que l'âge du patient (séparés par des virgules)");
                    String entreePatient = in.nextLine();
                    String[] patientInfo = entreePatient.split(",");
                    Patients newPatient = new Patients(patientInfo[0].trim(), patientInfo[1].trim(), patientInfo[2].trim(), patientInfo[3].trim(), patientInfo[4].trim(), patientInfo[5].trim(), Integer.parseInt(patientInfo[6].trim()));
                    // Ajoutez le nouveau patient au tableau
                    for (int i = 0; i < listePatients.length; i++) {
                        if (listePatients[i] == null) {
                            listePatients[i] = newPatient;
                            break;
                        }
                    }
                    break;
                case 2: //supprimer un patient
                    System.out.println("Entrez le nom du patient à supprimer");
                    String patientName = in.nextLine();
                    boolean patientTrouve = false;
                    for (int i = 0; i < listePatients.length; i++) {
                        if (listePatients[i] != null && listePatients[i].getNom().equalsIgnoreCase(patientName)) {
                            listePatients[i] = null;
                            patientTrouve = true;
                            System.out.println("Patient supprimé avec succès.");
                            break;
                        }
                    }
                    if (!patientTrouve) {
                        System.out.println("Aucun patient trouvé avec ce nom.");
                    }
                    break;
                case 3: //ajouter un medecin
                    System.out.println("Entrez le nom, prénom, l'adresse, la ville, le code postal, la spécialisation, l'âge ainsi que le numéro de téléphone du médecin (séparés par des virgules)");
                    String entreeMedecin = in.nextLine();
                    String[] medecinInfo = entreeMedecin.split(",");
                    Medecin nouveauMedecin = new Medecin(medecinInfo[0].trim(),
                                                         medecinInfo[1].trim(),
                                                         medecinInfo[2].trim(),
                                                         medecinInfo[3].trim(),
                                                         medecinInfo[4].trim(),
                                                         medecinInfo[5].trim(),
                                                         Integer.parseInt(medecinInfo[6].trim()),
                                                         medecinInfo[7].trim());
                    // Ajoutez le nouveau patient au tableau
                    for (int i = 0; i < listeMedecins.length; i++) {
                        if (listeMedecins[i] == null) {
                            listeMedecins[i] = nouveauMedecin;
                            break;
                        }
                    }
                    break;
                case 4: //suprimer un medecin
                    System.out.println("Entrez le nom du médecin à supprimer");
                    String nomMedecin = in.nextLine();
                    boolean medecinTrouve = false;
                    for (int i = 0; i < listePatients.length; i++) {
                        if (listeMedecins[i] != null && listeMedecins[i].getNom().equalsIgnoreCase(nomMedecin)) {
                            listeMedecins[i] = null;
                            medecinTrouve = true;
                            System.out.println("Médecin trouvé avec succès.");
                            break;
                        }
                    }
                    if (!medecinTrouve) {
                        System.out.println("Aucun médecin trouvé avec ce nom.");
                    }
                    break;
                case 5:
                    System.out.println("Entrez le nom du medecin, le nom du patient, le médicament, la posologie, la duree du traitement sous l'ordre suivant :année, mois, jour (tout séparés par des virgules)");
                    String entreeOrdo = in.nextLine();
                    String[] ordoInfo = entreeOrdo.split(",");
                    Medecin medecinOrdo = getMedecinParNom(ordoInfo[0].trim(), listeMedecins);
                    Patients patientOrdo = getPatientParNom(ordoInfo[1].trim(), listePatients);
                    if (medecinOrdo != null && patientOrdo != null) {
                        Ordonnance Ordonnance = new Ordonnance(patientOrdo,
                                medecinOrdo,
                                ordoInfo[2].trim(),
                                ordoInfo[3].trim(),
                                Integer.parseInt(ordoInfo[4].trim()),
                                LocalDate.of(Integer.parseInt(ordoInfo[5].trim()), Integer.parseInt(ordoInfo[6].trim()), Integer.parseInt(ordoInfo[7].trim()))
                        );
                        // Ajoutez la nouvelle ordonnance au tableau
                        for (int i = 0; i < listeOrdonnances.length; i++) {
                            if (listeOrdonnances[i] == null) {
                                listeOrdonnances[i] = Ordonnance;
                                System.out.println("Ordonnance ajoutée avec succès.");
                                break;
                            }
                        }
                    } else {
                        System.out.println("Médecin ou patient non trouvé.");
                    }
                    break;
                case 6: // supprimer une ordonnance
                    System.out.println("Entrez le nom du médecin et du patient dont vous voulez supprimer l'ordonnance (séparés par une virgule)");
                    String entreeOrdonnance = in.nextLine();
                    String[] ordonnanceInfo = entreeOrdonnance.split(",");
                    String nomMedecinOrdonnance = ordonnanceInfo[0].trim();
                    String nomPatientOrdonnance = ordonnanceInfo[1].trim();
                    boolean ordonnanceTrouvee = false;
                    for (int i = 0; i < listeOrdonnances.length; i++) {
                        if (listeOrdonnances[i] != null && listeOrdonnances[i].getMedecin().getNom().equalsIgnoreCase(nomMedecinOrdonnance) && listeOrdonnances[i].getPatient().getNom().equalsIgnoreCase(nomPatientOrdonnance)) {
                            listeOrdonnances[i] = null;
                            ordonnanceTrouvee = true;
                            System.out.println("Ordonnance supprimée avec succès.");
                            break;
                        }
                    }
                    if (!ordonnanceTrouvee) {
                        System.out.println("Aucune ordonnance trouvée avec ce médecin et ce patient.");
                    }
                    break;
                case 7: // ajouter un rendez vous
                    System.out.println("Entrez l'annee, le jour,le mois, l'heure, et les minutes du rendez vous (séparés par des virgules)");
                    String entreeRdvAjouter = in.nextLine();
                    String[] rdvInfoAjouter = entreeRdvAjouter.split(",");
                    String nomMedecinRdvAjouter = rdvInfoAjouter[0].trim();
                    String nomPatientRdv = rdvInfoAjouter[1].trim();
                    int anneeRdvAjouter = Integer.parseInt(rdvInfoAjouter[2].trim());
                    int moisRdvAjouter = Integer.parseInt(rdvInfoAjouter[3].trim());
                    int jourRdvAjouter = Integer.parseInt(rdvInfoAjouter[4].trim());
                    int heureRdvAjouter = Integer.parseInt(rdvInfoAjouter[5].trim());
                    int minuteRdvAjouter = Integer.parseInt(rdvInfoAjouter[6].trim());
                    Rdv.StatutRdv statutRdvAjouter = Rdv.StatutRdv.valueOf(rdvInfoAjouter[7].trim().toUpperCase());
                    Medecin medecinRdvAjouter = getMedecinParNom(nomMedecinRdvAjouter, listeMedecins);
                    Patients patientRdvAjouter = getPatientParNom(nomPatientRdv, listePatients);
                    if (medecinRdvAjouter != null && patientRdvAjouter != null) {
                        Rdv nouveauRdv = new Rdv(LocalDateTime.of(anneeRdvAjouter, moisRdvAjouter, jourRdvAjouter, heureRdvAjouter, minuteRdvAjouter), medecinRdvAjouter, patientRdvAjouter, statutRdvAjouter);
                        // Ajoutez le nouveau rendez-vous au tableau
                        for (int i = 0; i < listeRdvs.length; i++) {
                            if (listeRdvs[i] == null) {
                                listeRdvs[i] = nouveauRdv;
                                System.out.println("Rendez-vous ajouté avec succès.");
                                break;
                            }
                        }
                    } else {
                        System.out.println("Médecin ou patient non trouvé.");
                    }
                    break;
                case 8:  //supprime un rendez-vous s'il existe
                    System.out.println("Entrez le nom du médecin et du patient dont vous voulez supprimer le rendez-vous (séparés par une virgule)");
                    String entreeRdvSupprimer = in.nextLine();
                    String[] rdvInfoSupprimer = entreeRdvSupprimer.split(",");
                    String nomMedecinRdvSupprimer = rdvInfoSupprimer[0].trim();
                    String nomPatientRdvSupprimer = rdvInfoSupprimer[1].trim();
                    boolean rdvTrouveSupprimer = false;
                    for (int i = 0; i < listeRdvs.length; i++) {
                        if (listeRdvs[i] != null && listeRdvs[i].getMedecin().getNom().equalsIgnoreCase(nomMedecinRdvSupprimer) && listeRdvs[i].getPatient().getNom().equalsIgnoreCase(nomPatientRdvSupprimer)) {
                            listeRdvs[i] = null;
                            rdvTrouveSupprimer = true;
                            System.out.println("Rendez-vous supprimé avec succès.");
                            break;
                        }
                    }
                    if (!rdvTrouveSupprimer) {
                        System.out.println("Aucun rendez-vous trouvé avec ce médecin et ce patient.");
                    }
                    break;
                case 9:
                    System.out.println("Entrez le nom du médecin, le nom du patient, le coût de la consultation et le statut du paiement (séparés par des virgules)");
                    String entreeFacture = in.nextLine();
                    String[] factureInfo = entreeFacture.split(",");
                    String nomMedecinFacture = factureInfo[0].trim();
                    String nomPatientFacture = factureInfo[1].trim();
                    double coutConsultationFacture = Double.parseDouble(factureInfo[2].trim());
                    boolean estPayeFacture = Boolean.parseBoolean(factureInfo[3].trim());
                    Medecin medecinFacture = getMedecinParNom(nomMedecinFacture, listeMedecins);
                    Patients patientFacture = getPatientParNom(nomPatientFacture, listePatients);
                    if (medecinFacture != null && patientFacture != null) {
                        Facturation nouvelleFacture = new Facturation(patientFacture, medecinFacture, null, coutConsultationFacture, estPayeFacture);
                        // Ajoutez la nouvelle facture au tableau
                        for (int i = 0; i < listeFacturations.length; i++) {
                            if (listeFacturations[i] == null) {
                                listeFacturations[i] = nouvelleFacture;
                                System.out.println("Facture créée avec succès.");
                                break;
                            }
                        }
                    } else {
                        System.out.println("Médecin ou patient non trouvé.");
                    }
                    break;
                case 10:
                    System.out.println("Entrez le nom du patient à rechercher");
                    String nomPatientRecherche = in.nextLine();
                    Patients[] patientsTrouves = Recherche.rechercherParNom(nomPatientRecherche, listePatients);
                    if (patientsTrouves.length > 0) {
                        System.out.println("Patients trouvés : ");
                        for (Patients patient : patientsTrouves) {
                            if (patient != null) {
                                System.out.println("Nom : " + patient.getNom());
                                System.out.println("Prénom : " + patient.getPrenom());
                                System.out.println("Adresse : " + patient.getAdresse());
                                System.out.println("Ville : " + patient.getVille());
                                System.out.println("Code Postal : " + patient.getCodePostal());
                                System.out.println("Numéro de sécurité sociale : " + patient.getNumeroSecuriteSociale());
                                System.out.println("Age : " + patient.getAge());
                                System.out.println("--------------------");
                            }
                        }
                    } else {
                        System.out.println("Aucun patient trouvé avec ce nom.");
                    }
                    break;
                case 11:
                    System.out.println("Entrez le nom du médecin à rechercher");
                    String nomMedecinRecherche = in.nextLine();
                    Medecin[] medecinsTrouves = Recherche.rechercherParNom(nomMedecinRecherche, listeMedecins);
                    if (medecinsTrouves.length > 0) {
                        System.out.println("Médecins trouvés : ");
                        for (Medecin medecin : medecinsTrouves) {
                            if (medecin != null) {
                                System.out.println("Nom : " + medecin.getNom());
                                System.out.println("Prénom : " + medecin.getPrenom());
                                System.out.println("Adresse : " + medecin.getAdresse());
                                System.out.println("Ville : " + medecin.getVille());
                                System.out.println("Code Postal : " + medecin.getCodePostal());
                                System.out.println("Spécialisation : " + medecin.getSpecialisation());
                                System.out.println("Age : " + medecin.getAge());
                                System.out.println("Numéro de téléphone : " + medecin.getNumeroTel());
                                System.out.println("--------------------");
                            }
                        }
                    } else {
                        System.out.println("Aucun médecin trouvé avec ce nom.");
                    }
                    break;
                case 0:
                    System.out.println("Fermeture du programme");
                    enCoursExecution=false;
                break;

                default:
                    System.out.println("Veuillez entrez une valeur valide");
                break;
            }
        }
    }
}

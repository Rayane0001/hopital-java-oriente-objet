// La classe Recherche fournit des méthodes pour effectuer des recherches sur des patients.
public class Recherche {
    // La méthode rechercherParNom recherche des patients par nom dans une liste de patients.
    // Elle renvoie un tableau de Patients contenant tous les patients dont le nom correspond à la recherche.
    public static Patients[] rechercherParNom(String nom, Patients[] listePatients) {
        // Création d'un tableau pour stocker les résultats de la recherche.
        Patients[] resultats = new Patients[listePatients.length];
        int count = 0;
        // Parcours de la liste des patients.
        for (Patients patient : listePatients) {
            // Si le patient n'est pas null et que son nom correspond à la recherche, il est ajouté aux résultats.
            if (patient != null && patient.getNom().equalsIgnoreCase(nom)) {
                resultats[count++] = patient;
            }
        }
        // La méthode renvoie le tableau de résultats.
        return resultats;
    }
    public static Medecin[] rechercherParNom(String nom, Medecin[] listeMedecins) {
        Medecin[] resultats = new Medecin[listeMedecins.length];
        int count = 0;
        for (Medecin medecin : listeMedecins) {
            if (medecin != null && medecin.getNom().equalsIgnoreCase(nom)) {
                resultats[count++] = medecin;
            }
        }
        return resultats;
    }
}
abstract class Document {
    private String titre;
    private String auteur;
    private int annee;
    private boolean disponible;

    public Document(String titre, String auteur, int annee) {
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
        this.disponible = true; // Par défaut, un document est disponible
    }

    public boolean estDisponible() {
        return disponible;
    }

    public void emprunter() {
        if (disponible) {
            disponible = false;
            System.out.println("Le document \"" + titre + "\" a été emprunté.");
        } else {
            System.out.println("Le document \"" + titre + "\" n'est pas disponible pour emprunt.");
        }
    }

    public void retourner() {
        disponible = true;
        System.out.println("Le document \"" + titre + "\" a été retourné.");
    }

    public void reserver() {
        if (disponible) {
            disponible = false;
            System.out.println("Le document \"" + titre + "\" a été réservé.");
        } else {
            System.out.println("Le document \"" + titre + "\" n'est pas disponible pour réservation.");
        }
    }

    public int getAnnee() {
        return annee;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getTitre() {
        return titre;
    }

    public abstract void afficherDetails();

    public abstract String getType();
}


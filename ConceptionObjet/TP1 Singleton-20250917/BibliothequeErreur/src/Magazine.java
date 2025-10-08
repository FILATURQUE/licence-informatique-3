class Magazine extends Document {
    private int numero;
    private String mois;

    public Magazine(String titre, String auteur, int annee, int numero, String mois) {
        super(titre, auteur, annee);
        this.numero = numero;
        this.mois = mois;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Magazine: \"" + getTitre() + "\" n°" + numero + " de " + mois + " " + getAnnee());
    }

    @Override
    public String getType() {
        return "Magazine";
    }

}


class Noeud {
    int v;
    Noeud fg;
    Noeud fd;

    Noeud(Noeud fg, int v, Noeud fd) {
        this.fg = fg;
        this.v = v;
        this.fd = fd;
    }

    public String toString(){
        String sb = "[";
        if (fg!=null)sb += fg.toString();
        sb += v;
        if (fd!=null)sb += fd.toString();
        return sb + "]";

    }
    boolean testABR(int min, int max){
        return (min <= v) && (v <= max) && ((fg != null) ? fg.testABR(min, v) : true) && ((fd != null) ? fd.testABR(v, max) : true);
    }
}

public class Arbre {
    Noeud racine;

    public Arbre() {
        racine = null;
    }

    public Arbre(Arbre ag, int v, Arbre ad) {
        racine = new Noeud(ag.racine, v, ad.racine);
    }

    public String toString() {
        if (racine == null) {
            return "";
        } else {
            return racine.toString();
        }
    }

    public boolean testABR() {
        return (racine == null) ? true : racine.testABR(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public void inser(int value){
        if (racine == null) {
            racine = new Noeud(racine, value, racine);
        } else {
            if (racine.v > value) racine.fg = new Noeud(null, value, null);
            else racine.fd = new Noeud(null, value, null);
        }   
    }
}

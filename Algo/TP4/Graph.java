import java.util.ArrayList;

enum Color {
        Blanc,
        Gris,
        Noir
}

class Arrete {
    double poids;
    int cible;
    Arrete(double poids, int cible){
        this.poids=poids;
        this.cible=cible;
    }
}

class Sommet{
    ArrayList<Arrete> voisins;
    Color couleur;
    int debut,fin,pi,id;
    double distance;

    Sommet(){
        couleur = Color.Blanc;
        debut = Integer.MAX_VALUE;
        voisins = new ArrayList<>();
    }

}

public class Graph {
    private
        ArrayList<Sommet> sommets;

    public Graph(){
        sommets = new ArrayList<>();
    }

    public double getNbSommet(){
        return ((double) sommets.size());
    }

    public double getDistance(int i){
        return sommets.get(i).distance;
    }

    public int getParent(int i){
        return i % 2 == 0 ? i / 2 : (i-1)/2;
    }

    public void ajoutArete(int i, int j, double poids) {
        if (j > sommets.size()-1) {
            throw new IllegalArgumentException("j n'existe pas");
        } else if(i > sommets.size()-1) {
            throw new IllegalArgumentException("i n'existe pas");
        }else {
            if (!sommets.get(i).voisins.contains(j)){
                sommets.get(i).voisins.add(new Arrete(poids,j));
            }
        }
    }

    public void ajoutSommet(){
        Sommet s = new Sommet();
        s.id = sommets.size();
        sommets.add(s);
        
    }

    @Override
    public String toString() {
        if (sommets.isEmpty()) {
            return "digraph{\n}";
        }
        String dot = "digraph{\n";
        for (int i = 0; i < sommets.size(); i++) {
            dot = dot + sommets.get(i).id + ";\n";
        }
        for (int i = 0; i < sommets.size(); i++) {
            if (!sommets.get(i).voisins.isEmpty()) {
                for (int j = 0; j < sommets.get(i).voisins.size(); j++) {
                    dot = dot + i + "->" + sommets.get(i).voisins.get(j).cible + " [label="+'"'+sommets.get(i).voisins.get(j).poids+'"'+"];\n";
                }
            }
        }
        return dot + "}";
    }

    public double poidsTotal(){
        double p = 0;
        for (int i = 0; i < sommets.size(); i++) {
            for (Arrete a : sommets.get(i).voisins) {
                p += a.poids;
            }
        }
        return p;
    }
    
    public void initSourceUnique(int s){
        for (int i = 0; i < sommets.size(); i++) {
            sommets.get(i).distance = Double.MAX_VALUE;
            sommets.get(i).pi = -1;
        }
        sommets.get(s).distance = 0;
    }

    public void relacherVoisins(int u){
        Sommet su = sommets.get(u);
        for (Arrete v : su.voisins) {
            if (sommets.get(v.cible).distance > (su.distance + v.poids)) {
                sommets.get(v.cible).distance = su.distance + v.poids;
                sommets.get(v.cible).pi = u;
            }
        }
    }

    public boolean bellmanFord(int s){
        initSourceUnique(s);
        for (int i = 1; i < sommets.size()-1; i++) {
            relacherVoisins(i);
        }
    }
}   

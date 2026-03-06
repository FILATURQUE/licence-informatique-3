error id: file://<WORKSPACE>/Algo/TM3/Graph.java:Sommet#voisins.
file://<WORKSPACE>/Algo/TM3/Graph.java
empty definition using pc, found symbol in pc: 
found definition using semanticdb; symbol Sommet#voisins.
empty definition using fallback
non-local guesses:

offset: 273
uri: file://<WORKSPACE>/Algo/TM3/Graph.java
text:
```scala
import java.util.ArrayList;

enum Color {
        Blanc,
        Gris,
        Noir
}

class Sommet{
    ArrayList<Integer> voisins;
    Color couleur;
    int debut,fin,pi,id;

    Sommet(){
        couleur = Color.Blanc;
        debut = Integer.MAX_VALUE;
        voisins@@ = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

}

public class Graph {
    private
        ArrayList<Sommet> sommets;

    public Graph(){
        sommets = new ArrayList<>();
    }

    public void ajoutSommet(){
        Sommet nSom = new Sommet();
        if (sommets.isEmpty()) {
            nSom.setId(0);
            sommets.add(nSom);
        } else {
            nSom.setId(sommets.size());
            sommets.add(nSom);
        }
    }

    public void ajoutArete(int i, int j) {
        if (j > sommets.size()-1) {
            throw new IllegalArgumentException("j n'existe pas");
        } else if(i > sommets.size()-1) {
            throw new IllegalArgumentException("i n'existe pas");
        }else {
            if (!sommets.get(i).voisins.contains(j)){
                sommets.get(i).voisins.add(j);
            }
        }
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
                    dot = dot + i + "->" + sommets.get(i).voisins.get(j) + ";\n";
                }
            }
        }
        return dot + "}";
    }
    public boolean existeArete(int i, int j){
        if (j > sommets.size()-1) {
            throw new IllegalArgumentException("j n'existe pas");
        } else if(i > sommets.size()-1) {
            throw new IllegalArgumentException("i n'existe pas");
        } else {
            return (sommets.get(i).voisins.contains(j));
        }
    }

    public int getNbSommets(){
        return sommets.size();
    }

    public int getNbAretes(){
        int nb = 0;
        for (int i = 0; i < sommets.size(); i++) {
            nb += sommets.get(i).voisins.size();                              
        }
        return nb;
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: 
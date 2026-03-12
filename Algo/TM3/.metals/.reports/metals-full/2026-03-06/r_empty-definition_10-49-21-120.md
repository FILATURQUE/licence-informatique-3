error id: file://<WORKSPACE>/Graph.java:java/lang/IllegalArgumentException#
file://<WORKSPACE>/Graph.java
empty definition using pc, found symbol in pc: java/lang/IllegalArgumentException#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 1010
uri: file://<WORKSPACE>/Graph.java
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
        voisins = new ArrayList<>();
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
        if (sommets.isEmpty()){
            nSom.setId(0);
            sommets.add(nSom);
        }
        nSom.setId(sommets.size());
        sommets.add(nSom);
    }

    public void ajoutArete(int i, int j){
        // if (sommets.get(i).voisins.contains(j)) System.out.println("Arete existe deja");
        if (sommets.size() < i || sommets.size() < j ||  sommets.size() < i && sommets.size() < j){
            throw new IllegalArgumentExc@@eption("i ou j n'existe pas");
        }
        sommets.get(i).voisins.add(j);
    }

    @Override
    public String toString(){
        return "digraph{}"; 
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/lang/IllegalArgumentException#
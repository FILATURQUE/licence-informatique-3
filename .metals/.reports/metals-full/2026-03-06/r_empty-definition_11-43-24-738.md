error id: file://<WORKSPACE>/Test.java:java/util/ArrayList#isEmpty().
file://<WORKSPACE>/Test.java
empty definition using pc, found symbol in pc: java/util/ArrayList#isEmpty().
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 1391
uri: file://<WORKSPACE>/Test.java
text:
```scala

import java.util.ArrayList;

public class Test {

    enum Color {
        Blanc,
        Gris,
        Noir
    }

    static class Sommet {

        ArrayList<Integer> voisins;
        Color couleur;
        int debut, fin, pi, id;

        Sommet() {
            couleur = Color.Blanc;
            debut = Integer.MAX_VALUE;
            voisins = new ArrayList<>();
        }

        public void setId(int id) {
            this.id = id;
        }

    }

    public static class Graph {

        private ArrayList<Sommet> sommets;

        public Graph() {
            sommets = new ArrayList<>();
        }

        public void ajoutSommet() {
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
            // if (sommets.get(i).voisins.contains(j)) System.out.println("Arete existe deja");
            if (sommets.size() < i || sommets.size() < j || sommets.size() < i && sommets.size() < j) {
                throw new IllegalArgumentException("i ou j n'existe pas");
            }
            sommets.get(i).voisins.add(j);
        }

        @Override
        public String toString() {
            if (sommets.isEmp@@ty()) {
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
    }
    public static void main(String[] args) {
        Graph g = new Graph();
        g.ajoutSommet();
        g.ajoutSommet();
        System.out.println(g.sommets.size());
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/util/ArrayList#isEmpty().
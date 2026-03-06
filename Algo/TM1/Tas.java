import java.util.ArrayList;

public class Tas {
    private ArrayList<Integer> tas;
    private int n;

    // Question 3 - Initialisation du constructeur
    public Tas(ArrayList<Integer> tab) {
        this.tas = tab;
        this.n = tas.size();
        if (this.n > 0)
            n--;
    }

    public Tas() {
        this.tas = new ArrayList<Integer>();
    }

    // Question 2 - public static getFilsGauche, getFilsDroit et getParent
    public static int getFilsGauche(int parent) {
        return 2 * parent + 1;
    }

    public static int getFilsDroit(int parent) {
        return 2 * parent + 2;
    }

    public static int getParent(int fils) {
        return (int) (fils - 1) / 2;
    }

    // Question 3 - methode est vide
    public boolean estVide() {
        return tas.size() < 1;
    }

    @Override
    public String toString() {
        return this.estVide() ? "" : affString(0);
    }

    // A REVOIR Question 4
    public String affString(int i) {
        int filsGauche = getFilsGauche(i);
        int filsDroit = getFilsDroit(i);

        return "[" + tas.get(i) +
                ((filsGauche <= n) ? affString(filsGauche) : "") +
                ((filsDroit <= n) ? affString(filsDroit) : "") +
                "]";
    }

    // Question 5
    public boolean testTas(int i) {
/*         int parent = tas.get(i);

        if (getFilsGauche(i) < n)
            return true;

        int filsGauche = tas.get(getFilsGauche(i));
        
        if (filsGauche > parent) {
            return false;
        } 
       
        if (getFilsDroit(i) < n)
            return testTas(getFilsGauche(i));

        int filsDroit = tas.get(getFilsDroit(i));
        
        if (filsDroit > parent) {
            return false;
        }

        return testTas(getFilsGauche(i)) && testTas(getFilsDroit(i)); */

        if (getFilsGauche(i) > n) return true;

        if (getFilsDroit(i) > n) return testTas(getFilsGauche(i));

        return 
            tas.get(i) > tas.get(getFilsGauche(i)) && 
            tas.get(i) > tas.get(getFilsDroit(i));
    }

    public boolean testTas() {
        return estVide() ? true : testTas(0);
    }
}

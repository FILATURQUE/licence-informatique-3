import java.util.concurrent.locks.*;

public class TM2 {

    static class Variable{

        int partager = 0;
        boolean flag = false;
        Lock lk = new ReentrantLock();
        
    }

    static class Producteur implements Runnable{

        Variable v;

        public Producteur(Variable v) {
            this.v = v;
        }

        @Override
        public void run() {
            while (true) {
                v.lk.lock();
                try {
                    if (!v.flag) {
                        v.flag = true;
                        v.partager++;
                        System.out.println("Le GoaT a produit 1 FLAG!");
                    }
                } finally {
                    v.lk.unlock();
                }
                
            }
        }
        
    }

    static class Consommateur implements Runnable{
        String nom;
        Variable v;

        public Consommateur(String n, Variable v) {
            this.nom = n;
            this.v = v;
        }

        @Override
        public void run(){
            while (true) {
                v.lk.lock();
                try {
                    if (v.flag) {
                        v.flag = false;
                        v.partager++;
                        System.out.println(nom+" a manger le flag!  :"+v.partager);
                    }
                } finally {
                    v.lk.unlock();
                }
            }
        }
    }
    public static void main(String[] args) {
        Variable v = new Variable();
        Producteur p = new Producteur(v);
        Thread t1 = new Thread(p);
        t1.start();

        for (int i = 0; i < 5; i++) {
            Consommateur c = new Consommateur("Patrick"+" "+i, v);
            Thread t2 = new Thread(c);
            t2.start();
        }

    }
}
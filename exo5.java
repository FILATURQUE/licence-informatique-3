import java.util.Random;

public class exo5 {
    static class Variable{
        int x = 0;
    }

    static class Drapo{
        Boolean flag = false;
    }
    static class Producteur extends Thread{
        Variable partage;
        Drapo d;
        
        public Producteur(Drapo dr, Variable v) {
            this.d = dr;
            this.partage = v;
        }
        
        public void run(){
            while (true){
                while(d.flag){
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } 
                }
                d.flag = true;
                partage.x++;
                System.out.println(partage.x);
            }
        }
    }
    static class Consommateur extends Thread{
        String name;
        Drapo d;
        Producteur p;

        public Consommateur(String n, Drapo dr, Producteur pr){
            this.name = n;
            this.d=dr;
            this.p = pr;
        }

        public void run(){
            while (true) {
                while (!d.flag) {
                    try {
                        sleep(new Random().nextInt(100));
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } 
                }
                d.flag = false;
                System.out.print(name+"\n");
            }
        }
        }
    public static void main(String[] args) {
        Variable v = new Variable();
        Drapo d = new Drapo();
        Producteur p = new Producteur(d,v);

        p.start();

        Consommateur c1 = new Consommateur("patrique",d,p);
        Consommateur c2 = new Consommateur("parikue",d,p);
        Consommateur c4 = new Consommateur("patrie",d, p);
        Consommateur c3 = new Consommateur("prickhe",d,p);
        Consommateur c5 = new Consommateur("pqueh",d,p);
        

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();

    }
}

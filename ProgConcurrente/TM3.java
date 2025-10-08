public class TM3 {
    
    public static void main(String[] args) {
        Data d = new Data();
        Tache tache = new Tache(d);
        /* Thread t1 = new Thread(tache);
        Thread t2 = new Thread(tache);
        
        t1.start();
        t2.start(); */

        for (int i = 0; i < 50; i++) {
            Thread t = new Thread(tache);
            t.start();
        }
        
    }
}

/* class Data{
    int x;
    Object o;

    public Data(){
        x=0;
        this.o=new Object();
    }

    public void increment(){
        synchronized (o){
            x++;
        }
    }
} */

// Avec this
class Data {
    int x;
    
    public Data()
    {
        this.x = 0;
    }

    public synchronized void increment(){
        x++;
    }
    
}

class Tache implements Runnable {
    private Data d;

    public Tache(Data d) {
        this.d=d;
    }
    
    
    
    public void run() {
        for (int i=0; i<10000; i++) {
            d.increment();
        }
        System.out.println(d.x);
    }
    
}

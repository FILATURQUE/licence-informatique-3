import java.util.concurrent.locks.*;

public class Exo4 {

    static class Filosof implements Runnable{
        String n;
        int health = 20;
        Lock right;
        Lock left;

        public Filosof(String n, Lock r, Lock l) {
            this.n = n;
            this.right = r;
            this.left = l;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (health == 0) {
                    System.out.println(n+" has been slayed.");
                    return;
                }
                if (right.tryLock() && left.tryLock()) {
                    right.unlock();
                    left.unlock();
                    System.out.println(n+" a bien manger ce batard");
                    System.out.println(health);
                    if (health < 20) {
                        health++;
                        System.out.println(health);
                    }
                } else {
                    System.out.println(health);
                    health--;
                }

            }
        }        
    }

    public static void main(String[] args) {
        int length = 5;
        Lock[] l = new Lock[length];
        for (int i = 0; i < l.length; i++) {
            l[i] = new ReentrantLock();
        }
        Filosof [] filosofs = new Filosof[length];
        for (int i = 0; i < filosofs.length-1; i++) {
            filosofs[i] = new Filosof("caca "+i,l[i],l[i+1]);
            new Thread(filosofs[i]).start();    
        }
        Filosof f = new Filosof("caca 5", l[length-1], l[0]);
        Thread t = new Thread(f);
        t.start();
    }   

}

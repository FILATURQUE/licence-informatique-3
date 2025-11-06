public class TM5 {
    // Exercice 1 et 2 

    public static class Hammam {
    
        private int maxSeat;
        private int currentSeat = 0;
        private int tookBath = 0;

        public Hammam(int nbSeat){
            this.maxSeat = nbSeat;
        }

        public synchronized int getCurrentSeat() {
            return currentSeat;
        }

        public synchronized void setTookBath(int tookBath) {
            this.tookBath = tookBath;
            notifyAll();
        }

        private boolean isFull(){
            return currentSeat >= maxSeat;
        }
        
        public boolean isDirty(){
            return tookBath >= 12;
        }

        public synchronized void enter(){
            while (isFull() || isDirty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            currentSeat++;
            System.out.println("Le client "+ Thread.currentThread().threadId()+ " rentre dans le hammam.");
        }

        public synchronized void out(){
            currentSeat--;
            System.out.println("Le client "+ Thread.currentThread().threadId()+" sort du hammam.");
            notifyAll();
        }

        public void takeBath(){
            tookBath ++;
            // System.out.println("Le client "+ Thread.currentThread().threadId()+" prends son bain.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static class Client extends Thread{

        private Hammam h;

        public Client (Hammam h){
            this.h = h;
        }
        
        public void run(){
            while (true) {
                h.enter();
                h.takeBath();
                h.out();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
        }
    }

    public static class Cleaner extends Thread {
        private Hammam h;

        public Cleaner(Hammam h){
            this.h = h;
        }

        public void run(){
            while (true) {
                synchronized(h){
                    while (!h.isDirty() || h.getCurrentSeat() != 0) {
                        try {
                            h.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("Le cleaner fait son job et nettoie la crasse des autres.");
                h.setTookBath(0);
            }
        }
    }

    public static void main(String[] args) {
        Hammam h = new Hammam(4);
        for (int i = 0; i < 12; i++) {
            new Client(h).start();
        }
        new Cleaner(h).start();
    }
}

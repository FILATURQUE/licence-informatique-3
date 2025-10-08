import java.util.Random;
import java.util.concurrent.locks.*;


public class Philosophe implements Runnable{
    String name;
    int health=10;
    Lock droit;
    Lock gauche ;

    public Philosophe(String n, Lock d, Lock g){
        name=n;
        droit=d;
        gauche=g;
    }

    @Override
    public void run() {
        while(true){
            if (health<0){
                System.out.println(name+" nous a tristement quitté suite à une terrible famine");
                return;
            }
            if (droit.tryLock()){
                if (gauche.tryLock()){
                    try {
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    droit.unlock();
                    gauche.unlock();
                    System.out.println(name+" a pu manger");
                    health++;
                }
            }
            System.out.println(name+" n'a pas pris de baguettes");
            health-=2;
        }
    }

    public static void main(String[] args) {
        int lenght=6;
        Philosophe philosophes[] = new Philosophe[lenght];
        Lock l[] =new Lock[lenght];

        for (int j=0; j<lenght;j++){
            l[j]=new ReentrantLock();
        }

        for (int i=0;i<lenght-1;i++){
            philosophes[i]= new Philosophe("Pascal"+i, l[i], l[i+1]);
            new Thread(philosophes[i]).start();
        }
        philosophes[lenght-1]=new Philosophe("Aristote", l[lenght-1], l[0]);
        new Thread(philosophes[lenght-1]).start();;
    }
}
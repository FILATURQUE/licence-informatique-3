public class tm2 {
    /* 
class Variable{
    int x;
    Lock lk;

    public Variable() {
        this.lk = new ReentrantLock();
    }

    
}
public class TM2{
    static Variable v = new Variable();
    public static void main(String[] args) throws InterruptedException {
        
        Runnable run = () -> {
            for (int i = 0; i < 10000; i++) {
                v.lk.lock();
                v.x++;
                v.lk.unlock();
            }
        };
        for (int i = 0; i < 50; i++) {
            
            Thread t1 = new Thread(run);
            t1.start();
            t1.join();
    
        }
        System.out.println(v.x);
    }

}
 */

}

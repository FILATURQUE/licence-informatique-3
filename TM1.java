import java.util.Random;

public class TM1 {
    static class To extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                System.out.print("a");
            }
        }
    }
    static class Tt extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                System.out.print("<");
            }
        }
    }
    static class T3 extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                System.out.print("c");
            }
        }
    }
    static class Tf extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                System.out.print("%");
            }
        }
    }
    static class T5 extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                System.out.print("e");
            }
        }
    }
    static class Ts extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                System.out.print("f");
            }
        }
    }
    static class T7 extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                System.out.print("g");
            }
        }
    }
    static class Te extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                System.out.print("h");
            }
        }
    }
    static class Tn extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                System.out.print("i");
            }
        }
    }
    static class T10 extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                System.out.print("j");
            }
        }
    }

    static class Q2 extends Thread{
        @Override
        public void run(){
            for (int i = 1; i <= 1000; i++) {
                try {
                    Thread.sleep(new Random().nextInt(100));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.print(" "+i);
            }
        }
    }
    static class Q2bis extends Thread{
        @Override
        public void run(){
            for (int i = 1; i <= 1000; i++) {
                try {
                    Thread.sleep(new Random().nextInt(100));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.print(" "+i);
            }
        }
    }
    static class Variable{
        int x;
    }

    static class Q3 extends Thread{
        Variable v;
        public Q3(Variable y){
            this.v=y;
        };
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                v.x++;
                System.out.println(v.x);
            }
        }
    }
    static class Q3bis extends Thread{
        Variable v;
        public Q3bis(Variable y){
            this.v=y;
        };
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                v.x++;
                System.out.println(v.x);
            }
        }
    }

    static class Q4 extends Thread{
        Variable v;
        public Q4(Variable i){
            this.v =i;
        }
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                v.x++;
                System.out.println(v.x);
            }
        }
    }

    static class Q4bis extends Thread{
        Variable v;
        public Q4bis(Variable i){
            this.v =i;
        }
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                v.x--;
                System.out.println(v.x);
            }
        }
    }
    
    public static void main(String[] args){

        // Question 1 
        /* To t1 = new To();
        Tt t2 = new Tt();
        T3 t3 = new T3();
        Tf t4 = new Tf();
        T5 t5 = new T5();
        Ts t6 = new Ts();
        T7 t7 = new T7();
        Te t8 = new Te();
        Tn t9 = new Tn();
        T10 t10 = new T10();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start(); */

        // Question 2
/*         Q2 q1 = new Q2();
        Q2bis q2 = new Q2bis();

        q1.start();
        q2.start();
 */ 
        // Question 3
        /* Variable v = new Variable();
        Q3 q1 = new Q3(v);
        Q3bis q2 = new Q3bis(v);
        q1.start();
        q2.start(); */

        // Question 4 
        /* Variable v = new Variable();
        Q4 q1 = new Q4(v);
        Q4bis q2 = new Q4bis(v);
        Q4 q3 = new Q4(v);
        Q4bis q4 = new Q4bis(v);
        q1.start();
        q2.start();
        q3.start();
        q4.start(); */
    }
}

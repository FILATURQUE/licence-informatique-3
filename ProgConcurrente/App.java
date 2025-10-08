public class App 
{

    public static void main(String[] args) 
    {
        Airport cdg = new Airport("Charle de gaules");
        for (int i = 0; i < 10; i++) {
            new Thread(new Airplane("Boeing "+i, cdg)).start();
        }
    }
}

public class Airplane implements Runnable
{
    ControlTower c;
    String name;
    Airport a;
    Boolean atterit = false;

    public Airplane(String n, Airport a)
    {
        this.c = ControlTower.getTower();
        this.name = n;
        this.a = a;

    }

    @Override
    public void run() 
    {
        while (!atterit) 
        {
            if (c.isRunwayFree()) {
                a.atterir();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                a.bouge();
                c.free();
                atterit = true;
            }
            else 
            {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    
}


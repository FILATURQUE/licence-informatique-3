public class ControlTower 
{
    
    private static ControlTower instance = null;
    private boolean is_runway_free = true;

    public boolean getIs_runway_free() {
        return is_runway_free;
    }

    private ControlTower()
    {
        System.out.println("The control tower has been created");
    }

    public static ControlTower getTower()
    {
        if (instance == null) 
        {
            instance = new ControlTower();
        }
        return instance;
    }

    public synchronized boolean isRunwayFree()
    {
        if (is_runway_free) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            is_runway_free = false;
            return true;

        } 
        else 
        {
            return false;
        }
    }

    public void free()
    {
        is_runway_free = true;
    }
    
}

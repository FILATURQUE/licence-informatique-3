public class Airport 
{
    String name;
    int plane_on_runway = 0;

    public Airport (String n)
    {
        this.name = n;
    }

    public boolean crash()
    {
        System.out.println("CRASHHHH BANDIT COUTE !!");
        return true;
    }

    public void atterir()
    {
        if (plane_on_runway > 1) {
            crash();   
        } 
        else 
        {
            plane_on_runway++;
            System.out.println("L'avion a atteri a l'aeroport: "+name);
        }
    
    }

    public void bouge()
    {
        plane_on_runway--;
        System.out.println("L'avion a bouge de l'aeroport: "+name);
    }
}

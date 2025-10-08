
public class Airport
{
    
    //TO DO declarer les variables planes_on_runway et accident 
    private static int planes_on_runway=0;
    private static boolean accident=false;


    public static synchronized void add_plane_to_runway()
    {
        planes_on_runway++;
        check_runways();
    }
    
    public static synchronized void remove_plane_from_runway()
    {
        planes_on_runway--;
        check_runways();
    }
    
    public static synchronized void check_runways()
    {
        if(planes_on_runway>1)
        {
            accident=true;
        }
    }
    
    public static synchronized boolean hasAccident()
    {
        return accident;
    }
}

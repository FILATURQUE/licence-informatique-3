
public class Main
{
   
    public static void main(String args[])
    {
     
        /* MyImage i = dog.buildImage();
        i.display(); */     
 
        /* i.paintOver("img/Hat.png", 280,5);
        i.display();

        i.paintOver("img/Sunglasses.png", 250, 46);
        i.display(); */
 
        /* MyImage picture = new Hat(new Sunglasses(new Dog().buildImage()).buildImage()).buildImage();
        picture.display(); */
        Picture picture = new Hat(new Sunglasses(new Penguin())); 
        picture.buildImage().display(); 
    }
        
}

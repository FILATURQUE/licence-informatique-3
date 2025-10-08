public class Dog implements Picture{

    private String path;

        public Dog()
        {
            path = "img/Dog.jpg";
            
        }
        @Override
        public MyImage buildImage()
        {
            return new MyImage(path);
        }
        
        
    }
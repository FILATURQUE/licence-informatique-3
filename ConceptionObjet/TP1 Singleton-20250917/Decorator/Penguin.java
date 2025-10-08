public class Penguin implements Picture {

    private String path;

    public Penguin (){
        this.path = "img/Penguin.jpg";
    }

    @Override
    public MyImage buildImage(){
        return new MyImage(path);
    }
}
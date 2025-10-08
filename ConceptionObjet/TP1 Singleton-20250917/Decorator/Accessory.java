public abstract class Accessory implements Picture
{
    protected String path;
    protected int x, y;
    protected Picture baseImage;

    public Accessory(Picture baseImage, String path, int x, int y) 
    {
        this.baseImage = baseImage;
        this.path = path;
        this.x = x;
        this.y = y;
    }

    public MyImage buildImage()
    {
        MyImage image = baseImage.buildImage();
        image.paintOver(path, x, y);
        return image;
    }
}
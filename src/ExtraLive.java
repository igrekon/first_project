import java.util.Random;


public class ExtraLive {
    public int x, y;
   public final String image = "\uD83D\uDC93";

    public ExtraLive(int sizeBoard) {
        Random r = new Random();
        this.x = r.nextInt(sizeBoard);
        this.y = r.nextInt(sizeBoard);
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public String getImage() { return image; }
}



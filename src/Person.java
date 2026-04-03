
import java.util.Random;

public class Person {
    int x, y;
    String image = "\uD83E\uDDD9\u200D";
    int live = 3;


    Person(int sizeBoard) {
        Random r = new Random();
        y = sizeBoard;
        int n = r.nextInt(sizeBoard);
        x = n == 0 ? 1 : n;
    }

    void move(int x, int y)
    {
        this.x = x;
        this.y = y;
    }




    public boolean moveCorrect(int x, int y){
        return this.x == x && Math.abs(this.y - y) == 1 || this.y == y && Math.abs(this.x - x) == 1;
    }



    void  downLive(){
        this.live-=1;
    }
}

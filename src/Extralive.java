import java.util.Random;

public class Extralive {
    public static void main(String[] args) {
        int lives = 0;
        Random random = new Random();



        if (lives <= 0) {
            if (random.nextDouble() < 0.5) {
                lives++;
                System.out.println("Удача улыбнулась тебе! Дополнительная жизнь у тебя в кармане!");
            } else {
                System.out.println("Шанс не сработал(");
            }
        }

    }
}


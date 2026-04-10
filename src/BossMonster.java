import java.util.Scanner;
import java.util.random.RandomGenerator;

public class BossMonster {
    private String image = "\uD83D\uDC7E";

    BossMonster(int sizeBoard) {
        super(sizeBoard);
    }

    //    @Override
    public String getImage() {
        return image;
    }

    //    @Override
    public void setImage(String image) {
        this.image = image;
    }

//    @Override
    public boolean monsterTask(int difficultGame) {
        System.out.println("Реши хард задачу:");
        if (difficultGame == 4){
            return monsterTask(difficultGame);
        }else {
            RandomGenerator r = null;
            int x = r.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
            int y = r.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
            int z = r.nextInt(100 * (difficultGame - 1), 100 * difficultGame);
            int trueAnswer = x % y / z;
            System.out.println("Реши сложнейший пример: " + x + " % " + y + " / " + z + " = ?");
            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt();
            if (trueAnswer == ans) {
                System.out.println("Лучший! Ты разорвал боссмонстра");
                return true;
            }
            System.out.println("Ты проиграл боссу, но играть можно и дальше)!");
            return false;
        }

    }

    public boolean monsterTask() {
        return super.monsterTask(0);
    }
}

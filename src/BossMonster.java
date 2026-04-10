

import java.util.Random;
import java.util.Scanner;

// Добавляем наследование, чтобы super(sizeBoard) работал
public class BossMonster extends Monster {
    private String image = "\uD83D\uDC7E";

    BossMonster(int sizeBoard) {
        super(sizeBoard);
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean taskMonster(int difficultGame) {
        System.out.println("--- БИТВА С БОСС МОНСТРОМ ---");

        Random r = new Random();

        // Генерация чисел с защитой от нуля
        int x = r.nextInt(10 * difficultGame) + 10;
        int y = r.nextInt(10 * difficultGame) + 5;
        int z = r.nextInt(5 * difficultGame) + 1; // Чтобы не было деления на 0

        int trueAnswer = (x % y) / z;

        System.out.println("Реши сложнейший пример: (" + x + " % " + y + ") / " + z + " = ?");
        System.out.print("Твой ответ: ");

        Scanner sc = new Scanner(System.in);
        try {
            int ans = sc.nextInt();
            if (trueAnswer == ans) {
                System.out.println("Лучший! Ты разорвал босс-монстра!");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Это даже не число...");
        }

        System.out.println("Монстра босс оказался лучше тебя, ты проиграл! (Правильный ответ: " + trueAnswer + ")");
        return false;
    }


    public boolean taskMonster() {
        return this.taskMonster(1);
    }
}

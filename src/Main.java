

//import java.util.Random;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        String person = "\uD83E\uDDD9\u200D";
//        int personLive = 3;
//
//
//        String monster = "\uD83E\uDDDF\u200D";
//        int sizeBoard = 3;
//        int personX = 3;
//        int personY = 6;
//
//        int step = 0;
//        String gamingField = "+ —— + —— + —— +\n"
//                + "|    |    | \uD83C\uDFE0 |\n"
//                + "+ —— + —— + —— +\n"
//                + "|    | " + monster + " |    |\n"
//                + "+ —— + —— + —— +\n"
//                + "| " + person + " |    |    |\n"
//                + "+ —— + —— + —— +";
//
//        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");
//
//        Scanner sc = new Scanner(System.in);
//        String answer = sc.nextLine();
//        System.out.println("Ваш ответ:\t" + answer);
//
//
//
//
//        switch (answer) {
//            case "ДА" -> {
//                System.out.println("Выбери сложность игры(от 1 до 5):");
//                int difficultGame = sc.nextInt();
//                System.out.println("Выбранная сложность:\t" + difficultGame);
//
//
//                System.out.println(gamingField);
//                System.out.println("Количество жизней:\t" + personLive + "\n");
//                System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;" +
//                        "\nКоординаты персонажа - (x: " + personX + ", y: " + personY + "))");
//                int x = sc.nextInt();
//                int y = sc.nextInt();
//                System.out.println(x + ", " + y);
//
//                if (x != personX && y != personY) {
//                    System.out.println("Неккоректный ход");
//                    if (personLive < 0){
//                        System.out.println("Удача улыбнулась тебе! Дополнительная жизнь у тебя в кармане!");
//                } else if (Math.abs(x - personX) == 1 || Math.abs(y - personY) == 1) {
//                    personX = x;
//                    personY = y;
//                    step++;
//                    System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY +
//                            "\nХод номер: " + step);
//                } else {
//                    System.out.println("Координаты не изменены");
//                }
//            }
//            case "НЕТ" -> System.out.println("Жаль, приходи еще!");
//            default -> System.out.println("Данные введены неккоректно");
//
//            }
//        }
//    }
//}
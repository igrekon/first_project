import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        String castle = "\uD83C\uDFF0";
        int personLive = 3;
        int sizeBoard = 5;
        int personX = 1;
        int personY = 5;
        int monsterY = 2;
        int step = 0;
        boolean finish = false;

        Person person = new Person(sizeBoard);

        String castles = "\\uD83C\\uDFF0";
        String extralive = "❤"; // доп жизнь, ее увидеть - сразу забирай
        String monster = "\uD83D\uDC79";


        Random r = new Random();


        int n = r.nextInt(sizeBoard);
        if (n == 0) {
            person.x = 1;
        } else {
            person.x = n;
        }

        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        System.out.println("Ваш ответ:\t" + answer);
        int castleY = 1;

        Random random = new Random();


        int castleX = 1 + random.nextInt(sizeBoard);
        int monsterX = 1 + random.nextInt(sizeBoard);
        String[][] board = new String[sizeBoard][sizeBoard];


        String leftBlock = " | ";
        String rightBlock = " |";
        String wall = " + —— + —— + —— + —— + —— + ";


        for (int y = 1; y <= sizeBoard; y++) {
            for (int x = 1; x <= sizeBoard; x++) {
                board[y - 1][x - 1] = "  ";
            }
        }

        int count_monster = sizeBoard * sizeBoard - sizeBoard - 1;
        for (int i = 0; i <= count_monster; i++) {
            board[random.nextInt(sizeBoard - 1)][random.nextInt(sizeBoard)] = monster;
        }


        int health_ = 3;
        for (int i = 1; i <= health_; i++) {
            board[random.nextInt(sizeBoard - 1)][random.nextInt(sizeBoard)] = extralive;
        }
        board[random.nextInt(sizeBoard - 1)][random.nextInt(sizeBoard)] = monster;

        board[castleY - 1][castleX - 1] = castle;
        board[personY - 1][personX - 1] = person.image;


        while ((personLive > 0) && !(castleX == personX && castleY == personY)) {


            for (int y = 1; y <= sizeBoard; y++) {
                System.out.println(wall);
                for (int x = 1; x <= sizeBoard; x++) {
                    System.out.print(leftBlock);
                    System.out.print(board[y - 1][x - 1]);
                }
                System.out.println(rightBlock);
            }
            System.out.println(wall);
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (person.moveCorrect(x, y)) {
                String next = board[y - 1][x - 1];
                if (next.equals("  ")) {
                    if (step == 0) {
                        board[0][4] = "  ";
                    }
                    step++;
                    board[person.y - 1][person.x - 1] = "  ";
                    person.move(x, y);
                    board[y - 1][x - 1] = person.image;

                    System.out.println("Ход корректный; Новые координаты: " + person.x + ", " + person.y +
                            "\\nХод номер: " + step);
                } else if (next.equals(castle)) {
                    System.out.println("Вы прошли игру!");
                    break;
                } else if (next.equals(extralive)) {
                    board[person.y - 1][person.x - 1] = "  ";
                    person.move(x, y);
                    step++;
                    board[y - 1][x - 1] = person.image;
                    personLive++;
                    System.out.println("Удача улыбнулась тебе! Дополнительная жизнь у тебя в кармане! " + personLive + " жизней");
                    System.out.println("Ход корректный; Новые координаты: " + person.x + ", " + person.y +
                            "\\nХод номер: " + step);

                } else if (next.equals(monster)) {
                    personLive--;
                    System.out.println("Вам попался монстр, -1 жизнь " + personLive + " жизней");
                    board[y - 1][x - 1] = "  ";


                } else {

                    boolean success = ShakeMonster();
                    if (success) {
                        System.out.println("Верно! Ты победил монстра");
                        personLive++;
                        board[person.y - 1][person.x - 1] = "  ";
                        personX = x;
                        personY = y;
                        person.move(x, y);
                        board[personY - 1][personX - 1] = person.image;

                        step++;
                    } else {
                        System.out.println("Ты проиграл эту битву!");
                        personLive -= 1;
                        person.live -= 1;
                    }


                }
            } else {
                System.out.println("Некорректный ход");
            }
            if (personLive <= 0) {
                {
                    personLive++;
                    System.out.println("Верно! Ты победил монстра");
                    personLive++;
                    board[person.y - 1][person.x - 1] = "  ";
                    personX = x;
                    personY = y;
                    person.move(x, y);
                    board[personY - 1][personX - 1] = person.image;
                }
                {
                    break;
                }
            }


//        switch (answer) {
//            case "ДА" -> {
//                System.out.println("Выбери сложность игры(от 1 до 5):");
//                int difficultGame = sc.nextInt();
//                System.out.println("Выбранная сложность:\t" + difficultGame);
//                while (true) {
//                    board[person.getY() - 1][person.getX() - 1] = person.getImage();
//                    outputBoard(board, person.getLive());
//                    System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;" +
//                            "\nКоординаты персонажа - (x: " + person.getX() + ", y: " + person.getY() + "))");
//                    int x = sc.nextInt();
//                    int y = sc.nextInt();
//
//
//                    if (person.moveCorrect(x, y)) {
//                        String next = board[y - 1][x - 1];
//                        if (next.equals("  ")) {
//                            board[person.getY() - 1][person.getX() - 1] = "  ";
//                            person.move(x, y);
//                            step++;
//                            System.out.println("Ход корректный; Новые координаты: " + person.getX() + ", " + person.getY() +
//                                    "\nХод номер: " + step);
//                        } else if (next.equals(castle)) {
//                            System.out.println("Вы прошли игру!");
//                            break;
//                        }else {
//                            for (Monster monster : arrMonster) {
//                                if (monster.conflictPerson(x, y)) {
//                                    if (monster.taskMonster(difficultGame)) {
//                                        board[person.getY() - 1][person.getX() - 1] = "  ";
//                                        person.move(x, y);
//
//                                    } else {
//                                        person.downLive();
//                                    }
//                                    break;
//                                }
//                            }
//                        }
//                    } else {
//                        System.out.println("Неккоректный ход");
//                    }
//                }
//            }
//            case "НЕТ" -> System.out.println("Жаль, приходи еще!");
//            default -> System.out.println("Данные введены неккоректно");
//        }

        }
        if (personLive == 0) {
            System.out.println("Закончились жизни. Итог:    " + step + " ходов");
        }
        static boolean perliv(){
            Random p = new Random();
            int x = r.nextInt(400);
            int y = r.nextInt(400);
            int trueAnswer = x + y;
            System.out.println("последний шанс");
            System.out.println("Реши пример: " + x + " + " + y + " = ?");
            Scanner scx = new Scanner(System.in);
            int ans = scx.nextInt();
            if (trueAnswer == ans) {
                System.out.println("Верно! Ты победил монстра");
                return ;
            } else {
                System.out.println("Ты проиграл эту битву!");

                return ;
            }


        }
        public static boolean ShakeMonster() {
            System.out.println("Решите задачу.");
            Random k = new Random();
            int x = r.nextInt(400);
            int y = r.nextInt(400);
            int trueAnswer = x + y;
            System.out.println("Реши пример: " + x + " + " + y + " = ?");
            Scanner scx = new Scanner(System.in);
            int ans = scx.nextInt();
            return ;
        }

    }
}





















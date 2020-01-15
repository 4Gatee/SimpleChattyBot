package bot;

import java.util.Scanner;

import static java.lang.Thread.sleep;

class BotEngine {
    private static void loadingAnimation(int length, long ms) throws InterruptedException {
        long time = java.lang.System.currentTimeMillis();
        int currentLength = 0;
        while (time + ms > java.lang.System.currentTimeMillis()) {
            //If dots number = length, remove all dots
            if (currentLength == length) {
                for (int i = 0; i < length; i++) {
                    System.out.print("\b");
                }
                currentLength = 0;
            }

            System.out.print(".");
            currentLength++;
            sleep(400);
        }

        //At finish remove all dots
        for (int i = 0; i < currentLength; i++) {
            System.out.print("\b");
        }
    }

    //Приветствие
    static void greeting () throws InterruptedException {
        loadingAnimation(3, 1000);
        System.out.println("Hello! My name is Unity.");
        loadingAnimation(3, 1000);
        System.out.println("I was created in 2020.");
    }

    //Запрос, проверка и вывод имени
    static void remindName (Scanner scanner) throws InterruptedException {
        loadingAnimation(3, 1000);
        System.out.println("Please, remind me your name.");
        String name;
        while (true) {
            name = scanner.nextLine();
            boolean nameIsOk = false;
            String error = null;

            if (name == null || name.isEmpty() || name.replace(" ", "").isEmpty()) {
                error = "Your name is empty, please try again.";
            } else if (name.length() > 40) {
                error = "Your name is too long (more than 40 chars), please try again.";
            } else {
                nameIsOk = true;
            }

            if (nameIsOk) {
                break;
            } else {
                loadingAnimation(5, 2000);
                System.out.println(error);
            }
        }
            loadingAnimation(5, 2000);
            System.out.println("What a great name your have, " + name + "!");
    }

    //Запрос, вычисление, проверка и вывод возвраста
    static void guessAge (Scanner scanner) throws InterruptedException {
        loadingAnimation(3, 1000);
        System.out.println("Let me guess your age.");
        loadingAnimation(3, 1000);
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");

        int age;
        while (true) {
            boolean ageIsOk = false;
            String error = null;
            age = calculateAge(scanner);

            if (age <= 0) {
                error = "Your age is invalid (" + age + "), try to type again.";
            } else if (age > 120) {
                error = "You are too old (" + age + " years), maybe you are immortal... Try again please.";
            } else {
                ageIsOk = true;
            }

            if (ageIsOk) {
                break;
            } else {
                loadingAnimation(5, 2000);
                System.out.println(error);
            }
        }

        loadingAnimation(5, 2000);
        analyzeAge(age);
    }

    //Получение цифр из командной строки и вычисление возраста
    private static int calculateAge(Scanner scanner) {
        int r3 = scanner.nextInt();
        int r5 = scanner.nextInt();
        int r7 = scanner.nextInt();
        return (r3 * 70 + r5 * 21 + r7 * 15) % 105;
    }

    //Анализ возраста и вывод соответствующего сообщения
    private static void analyzeAge(int age) throws InterruptedException {
        if (age < 10) {
            System.out.println("You are just a little larva (" + age + " years), it's too early to start programming.. :(");
        } else if (age < 16) {
            System.out.println("You are too young for this shit (only " + age + " years old), first finish your school homework! ;)");
        } else if (age <= 40) {
            System.out.println("Your age is " + age + "; that's a good time to start programming!");
        } else if (age <= 60) {
            System.out.println("You are pretty old, " + age + " years. But you can still try!");
        } else if (age <= 120) {
            System.out.println("Oh my god! " + age + " years old! You are as ancient as dinosaurs, holy shit... o_O");
            loadingAnimation(3, 1000);
            System.out.println("OK. Well, let's continue.");
        }
    }

    //Запрос, проверка и счет до определенного числа
    static void countNumber (Scanner scanner) throws InterruptedException {
        loadingAnimation(3, 1000);
        System.out.println("Now I will prove to you that I can count to any number you want. Enter a number.");

        int num = scanner.nextInt();
        if (num < 0) {
            for (int i = 0; i >= num; i--) {
                loadingAnimation(1, 400);
                System.out.println(i + "!");
            }
        } else if (num > 0) {
            for (int i = 0; i <= num; i++) {
                loadingAnimation(1, 400);
                System.out.println(i + "!");
            }
        } else {
            loadingAnimation(1, 400);
            System.out.println("0!");
        }
    }

    //Вопрос по программированию, получение ответа, проверка, вывод сообщения.
    static void quiz (Scanner scanner) throws InterruptedException {
        loadingAnimation(3, 1000);
        System.out.println("Now let's test your programming knowledge.");
        loadingAnimation(3, 1000);
        System.out.println("Why do we use methods?");

        while (true) {
            loadingAnimation(5, 2000);
            System.out.println("1. To repeat a statement multiple times.");
            System.out.println("2. To decompose a program into several small subroutines.");
            System.out.println("3. To determine the execution time of a program.");
            System.out.println("4. To interrupt the execution of a program.");

            int answer = scanner.nextInt();
            boolean isAnswerOk = false;
            String error = null;

            if (answer < 1 || answer > 4) {
                error = "There is no such answer, please try again.";
            } else if (answer != 2) {
                error = "Your answer is not correct, try one more time";
            } else {
                isAnswerOk = true;
            }

            if (isAnswerOk) {
                break;
            } else {
                loadingAnimation(5, 2000);
                System.out.println(error);
            }
        }
        loadingAnimation(5, 2000);
        System.out.println("Congratulations, it was the right answer! Have a nice day :)");
    }
}
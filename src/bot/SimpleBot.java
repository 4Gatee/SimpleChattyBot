package bot;

import java.util.Scanner;
import static bot.BotEngine.*;

public class SimpleBot {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        greeting();
        remindName(scanner);
        guessAge(scanner);
        countNumber(scanner);
        quiz(scanner);
    }
}
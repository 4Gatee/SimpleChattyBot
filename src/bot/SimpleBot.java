package bot;
import java.util.Scanner;

public class SimpleBot {
    public static void main(String[] args) {
        System.out.println("Hello! My name is Quantro.");
        System.out.println("I was created in 2020.");
        System.out.println("Please, remind me your name.");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("What a great name your have, " + name + "!");
    }
}
package bullscows;

import java.util.Scanner;

public class Bullscows {
    private String secret;
    private int bulls;
    private int cows;

    public Bullscows() {
        bulls = 0;
        cows = 0;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");

        int size;

        while (true) {
            size = sc.nextInt();

            if (size < 10) {
                break;
            } else {
                System.out.printf("Error: can't generate a secret number " +
                        "with a length of %d because there aren't enough unique digits.\n", size);
            }
        }

        randomSecretCode(size);
        System.out.println("Okay, let's start a game!");

        int i = 1;

        while (bulls != secret.length()) {
            bulls = 0;
            cows = 0;
            System.out.printf("Turn %d:\n", i++);
            grader(sc.next());
            printGrader();
        }

        System.out.println("Congratulations! You guessed the secret code.");
    }

    public void grader(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < secret.length(); j++) {
                if (s.charAt(i) == secret.charAt(i)) {
                    bulls++;
                    break;
                } else if (s.charAt(i) == secret.charAt(j)) {
                    cows++;
                }
            }
        }
    }

    public void printGrader() {
        String bull = bulls == 1 ? "bull" : "bulls";
        String cow = cows == 1 ? "cow" : "cows";

        if (bulls > 0 && cows > 0) {
            System.out.printf("Grade: %d %s and %d %s\n", bulls, bull, cows, cow);
        } else if (bulls > 0) {
            System.out.printf("Grade: %d %s\n", bulls, bull);
        } else if (cows > 0) {
            System.out.printf("Grade: %d %s\n", cows, cow);
        } else {
            System.out.println("Grade: None");
        }
    }

    public void randomSecretCode(int size) {
        StringBuilder secretCode = new StringBuilder();
        boolean[] digits = new boolean[10];

        for (int i = 0; i < size; i++) {
            int digit = (int) (Math.random() * 9 + 1);

            if (digits[digit]) {
                i--;
            } else {
                digits[digit] = true;
                secretCode.append(digit);
            }
        }

        secret = secretCode.toString();
    }
}

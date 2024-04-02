package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Bullscows bullscows = new Bullscows();
            bullscows.randomSecretCode(sc.nextInt());
        }
    }
}

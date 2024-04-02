package bullscows;

public class Bullscows {
    public void randomSecretCode(int size) {
        if (size < 10) {
            String secretCode;

            boolean check;
            do {
                long pseudoRandomNumber = System.nanoTime();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(pseudoRandomNumber).reverse();

                while (stringBuilder.charAt(0) == '0') {
                    stringBuilder.deleteCharAt(0);
                }

                secretCode = stringBuilder.substring(0, size);
                check = false;
                boolean[] digits = new boolean[10];

                for (int i = 0; i < secretCode.length(); i++) {
                    int digit = Character.getNumericValue(secretCode.charAt(i));
                    if (digits[digit]) {
                        check = true;
                    }
                    digits[digit] = true;
                }

            } while (check);

            System.out.printf("The random secret number is %s.", secretCode);
        } else {
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.", size);
        }
    }
}

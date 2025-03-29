package HW_4113056010;
import java.util.Random;
import java.util.Scanner;

class BullsAndCows {
    int[] codeArray;
    public BullsAndCows() {}
    public BullsAndCows(int input, int digits) {
        this.codeArray = splitToArray(input, digits);
    }
    int[] splitToArray(int num, int digits) {
        int[] result = new int[digits];
        for (int i = digits - 1; i >= 0; i--) {
            result[i] = num % 10;
            num /= 10;
        }
        return result;
    }
    boolean hasDuplicate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) return true;
            }
        }
        return false;
    }
    int[] generateCodeArray(int digits) {
        Random rand = new Random();
        int[] code = new int[digits];
        int index = 0;
        while (index < digits) {
            int n = rand.nextInt(10);
            boolean dup = false;
            for (int i = 0; i < index; i++) {
                if (code[i] == n) {
                    dup = true;
                    break;
                }
            }
            if (!dup) {
                code[index++] = n;
            }
        }
        return code;
    }
    void setCode(int[] codeArray) {
        this.codeArray = new int[codeArray.length];
        for (int i = 0; i < codeArray.length; i++) {
            this.codeArray[i] = codeArray[i];
        }
    }
    int[] checkBullsAndCows(int[] guess) {
        int bulls = 0, cows = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == codeArray[i]) {
                bulls++;
            } else {
                for (int j = 0; j < guess.length; j++) {
                    if (i != j && guess[i] == codeArray[j]) {
                        cows++;
                        break;
                    }
                }
            }
        }
        return new int[]{bulls, cows};
    }
    void printCode() {
        System.out.print("Number to guess: ");
        for (int i = 0; i < codeArray.length; i++) {
            System.out.print(codeArray[i]);
            if (i != codeArray.length - 1) System.out.print("-");
        }
        System.out.println();
    }
}

public class HW3_4113056010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int digits;
        BullsAndCows game;
        while (true) {
            System.out.print("Enter number of digits in code (3, 4 or 5): ");
            digits = sc.nextInt();
            if (digits == 0) {
                int input;
                while (true) {
                    System.out.print("Enter code:");
                    input = sc.nextInt();
                    System.out.print("Enter number of digits in code: ");
                    digits = sc.nextInt();
                    if (digits <= 0 || digits > 10) {
                        System.out.println("Invalid number of digits. Please enter a number from 1 to 10.");
                        continue;
                    }
                    int temp = input;
                    int count = 0;
                    while (temp > 0) {
                        count++;
                        temp /= 10;
                    }
                    if (count > digits) {
                        System.out.println("You can only enter " + digits + " digits.");
                        continue;
                    }
                    game = new BullsAndCows(input, digits);
                    if (game.hasDuplicate(game.codeArray)) {
                        System.out.println("Each number must be different.");
                        continue;
                    }
                    break;
                }
                game.printCode();
                break;
            } else if (digits > 0 && digits <= 10) {
                game = new BullsAndCows();
                int[] code = game.generateCodeArray(digits);
                game.setCode(code);
                game.printCode();
                break;
            } else {
                System.out.println("Invalid input. Please enter a number from 1 to 10, or 0 for custom code.");
            }
        }
        while (true) {
            System.out.print("Enter Guess: ");
            int guessInput = sc.nextInt();
            int temp = guessInput;
            int count = 0;
            while (temp > 0) {
                count++;
                temp /= 10;
            }
            if (count > digits) {
                System.out.println("You can only enter " + digits + " digits.");
                continue;
            }
            int[] guess = game.splitToArray(guessInput, digits);
            if (game.hasDuplicate(guess)) {
                System.out.println("Each number must be different.");
                continue;
            }
            int[] result = game.checkBullsAndCows(guess);
            int bulls = result[0];
            int cows = result[1];
            if (bulls == digits) {
                System.out.print(bulls + " bulls ... ");
                for (int i = 0; i < digits; i++) {
                    System.out.print(guess[i]);
                    if (i != digits - 1) System.out.print("-");
                }
                System.out.print(" is correct!");
                return;
            }
            System.out.println(bulls + " bulls");
            System.out.println(cows + " cows");
        }
    }
}

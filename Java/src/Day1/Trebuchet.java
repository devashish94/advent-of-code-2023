package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trebuchet {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            File file = new File("src/Day1/input");
            Scanner read = new Scanner(file);
            int sum = 0;
            while (read.hasNextLine()) {
                String line = read.nextLine();
                int firstNumber = getFirstNumber(line);
                int lastNumber = getLastNumber(line);
                sum += 10 * firstNumber + lastNumber;
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            System.out.println(e.getMessage());
        }
    }

    private static int getLastNumber(String line) {
        for (int i = line.length() - 1; i >= 0; i--) {
            if (Character.isDigit(line.charAt(i))) {
                return line.charAt(i) - '0';
            }
        }
        return 0;
    }

    private static int getFirstNumber(String line) {
        for (char c : line.toCharArray()) {
            if (Character.isDigit(c)) {
                return c - '0';
            }
        }
        return 0;
    }
}

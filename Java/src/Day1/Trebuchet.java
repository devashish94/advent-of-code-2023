package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Trebuchet {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Day1/input");
        Scanner read = new Scanner(file);

        int sum = 0;
        while (read.hasNextLine()) {
            String line = read.nextLine();

            List<Integer> arr = new LinkedList<>();
            for (char c : line.toCharArray()) {
                if (Character.isDigit(c)) {
                    arr.add(c - '0');
                }
            }
            sum += arr.get(0) * 10 + arr.get(arr.size() - 1);
        }
        System.out.println(sum);
    }
}

package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Scratchcards {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Day4/input");
        Scanner read = new Scanner(file);

        int sum = 0;
        while (read.hasNextLine()) {
            String[] input = read.nextLine().strip().split(":")[1].strip().split("\\|");

            List<Integer> winning = parseNumbers(input[0]);
            List<Integer> myNumbers = parseNumbers(input[1]);

            int count = 0;
            for (Integer n : myNumbers) {
                if (winning.contains(n)) {
                    count++;
                }
            }

            if (count != 0) {
                sum += 1 << (count - 1);
            }
        }
        System.out.println(sum);
    }

    private static List<Integer> parseNumbers(String input) {
        List<Integer> save = new ArrayList<>();
        for (String number : input.strip().split(" ")) {
            if (!number.isBlank()) {
                save.add(Integer.parseInt(number));
            }
        }
        return save;
    }
}

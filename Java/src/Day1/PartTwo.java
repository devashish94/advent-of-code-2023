package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Day1/input");
        Scanner read = new Scanner(file);

        int sum = 0;
        while (read.hasNextLine()) {
            String line = read.nextLine();

            String[] arr = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], i + 1);
            }

            List<Integer> save = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    save.add(line.charAt(i) - '0');
                }
                for (String s : arr) {
                    if (line.substring(i).startsWith(s)) {
                        save.add(map.get(s));
                    }
                }
            }
            sum += save.get(0) * 10 + save.get(save.size() - 1);
        }
        System.out.println(sum);
    }
}

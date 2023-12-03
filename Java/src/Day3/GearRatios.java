package Day3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GearRatios {
    public static void main(String[] args) throws IOException {
        Scanner read = new Scanner(new File("src/Day3/input"));

        ArrayList<String> arr = new ArrayList<>();
        while (read.hasNextLine()) {
            arr.add(read.nextLine());
        }

        // this is called clean code 🙂
        ArrayList<String> save = new ArrayList<>();
        for (int row = 0; row < arr.size(); row++) {
            boolean partNumber = false;
            StringBuilder number = new StringBuilder();
            for (int i = 0; i < arr.get(row).length(); i++) {
                boolean digit = Character.isDigit(arr.get(row).charAt(i));
                if (digit) {
                    number.append(arr.get(row).charAt(i));
                    if (!partNumber) {
                        partNumber = checkPartNumber(arr, row, i);
                    }
                    if (i + 1 == arr.get(row).length()) {
                        if (partNumber) { // see how perfectly it violates DRY
                            save.add(number.toString());
                            partNumber = false;
                        }
                        number = new StringBuilder();
                    }
                } else {
                    if (partNumber) { // DRY 💪
                        save.add(number.toString());
                        partNumber = false;
                    }
                    number = new StringBuilder();
                }
            }
        }

        int sum = save
                .stream()
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println(sum);
    }

    private static boolean checkSymbol(char check) {
        return String.valueOf(check).matches("[^A-Za-z0-9.]");
    }

    // i need to learn that short trick asap
    private static boolean checkPartNumber(ArrayList<String> arr, int row, int i) {
        // NEWS
        if (row > 0 && checkSymbol(arr.get(row - 1).charAt(i))) {
            return true;
        } else if (row < arr.size() - 1 && checkSymbol(arr.get(row + 1).charAt(i))) {
            return true;
        } else if (i > 0 && checkSymbol(arr.get(row).charAt(i - 1))) {
            return true;
        } else if (i < arr.get(row).length() - 1 && checkSymbol(arr.get(row).charAt(i + 1))) {
            return true;
        }

        // Diagonal
        else if (i < arr.get(row).length() - 1 && row < arr.size() - 1 && checkSymbol(arr.get(row + 1).charAt(i + 1))) {
            return true;
        } else if (i < arr.get(row).length() - 1 && row > 0 && i < arr.get(row).length() && checkSymbol(arr.get(row - 1).charAt(i + 1))) {
            return true;
        } else if (i > 0 && row < arr.size() - 1 && checkSymbol(arr.get(row + 1).charAt(i - 1))) {
            return true;
        } else return i > 0 && row > 0 && checkSymbol(arr.get(row - 1).charAt(i - 1));
    }
}

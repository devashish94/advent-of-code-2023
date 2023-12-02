package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class CubeConundrum {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner read = new Scanner(new File("src/Day2/input"));

        int sum = 0, gameCount = 1;
        while (read.hasNextLine()) {
            String line = read.nextLine();

            String gameRounds = line.split(": ")[1].strip();
            gameRounds = gameRounds.replace(";", ",");
            String[] gameRoundSubsets = gameRounds.split(", ");

            HashMap<String, Integer> check = new HashMap<>();
            check.put("red", 12);
            check.put("green", 13);
            check.put("blue", 14);

            boolean possible = true;
            for (String gameRound : gameRoundSubsets) {
                int count = Integer.parseInt(gameRound.split(" ")[0]);
                String ballType = gameRound.split(" ")[1];
                if (count > check.get(ballType)) {
                    possible = false;
                }
            }
            if (possible) {
                sum += gameCount;
            }
            gameCount++;
        }
        System.out.println(sum);
    }
}

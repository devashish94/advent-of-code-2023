package Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WaitForIt {
    private static List<Integer> parseInputOne(String url, int line) throws IOException {
        List<String> firstLine = new java.util.ArrayList<>(List.of(Files.readAllLines(Paths.get(url))
                .get(line)
                .split(": ")[1]
                .strip()
                .split(" ")));

        firstLine.removeIf(String::isBlank);

        return firstLine
                .stream()
                .map(Integer::parseInt)
                .toList();
    }

    private static void partOne(String url) throws IOException {
        List<Integer> times = parseInputOne(url, 0);
        List<Integer > distances = parseInputOne(url, 1);

        int product = 1;
        for (int i = 0; i < times.size(); i++) {
            int record = distances.get(i);
            int count = 0;
            for (int timeHold = 0; timeHold <= times.get(i); timeHold++) {
                if (timeHold * (times.get(i) - timeHold) > record) {
                    count++;
                }
            }
            product *= count;
            System.out.println(count);
        }
        System.out.println(product);
    }

    private static long parseInputTwo(String url, int line) throws IOException {
        Path path = Paths.get(url);
        String firstLine = Files.readAllLines(path)
                .get(line)
                .split(": ")[1]
                .strip()
                .replace(" ", "");
        return Long.parseLong(firstLine);
    }

    private static void partTwo(String url) throws IOException {
        long time = parseInputTwo(url, 0);
        long recordDistance = parseInputTwo(url, 1);

        int count = 0;
        for (int holdTime = 0; holdTime <= time; holdTime++) {
            if (holdTime * (time - holdTime) > recordDistance) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        String url = "src/Day6/input";
        partTwo(url);
    }
}

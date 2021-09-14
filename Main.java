package phonebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String dataPath = "C:/Users/ensla/Downloads/directory.txt";
        String findPath = "C:/Users/ensla/Downloads/find.txt";

        List<String> data = Files.readAllLines(Paths.get(dataPath));
        List<String> find = Files.readAllLines(Paths.get(findPath));
        String[] dataArr = new String[data.size()];
        dataArr = data.toArray(dataArr);
        String[] findArr = new String[find.size()];
        findArr = find.toArray(findArr);

        linearSearch(dataArr, findArr);

    }

    static void linearSearch (String[] data, String[] find) {
        long entriesFound = 0;
        long entries = find.length;
        System.out.println("Start searching...");
        long startTime = System.currentTimeMillis();
        for (String str : find) {
            for (String input : data) {
                if (input.contains(str)) {
                    entriesFound++;
                    break;
                }
            }
        }
        long endTime = System.currentTimeMillis();

        System.out.print("Found " + entriesFound + " / " + entries + " entries.");
        calcTimeTaken(startTime, endTime);
    }

    static void calcTimeTaken (long startTime, long endTime) {
        long timeDiff = endTime - startTime;
        long ms = timeDiff % 1000;
        long sec = timeDiff / 1000 % 60;
        long min = timeDiff / 1000 / 60;
        System.out.printf(" Time taken: %d min. %d sec. %d ms.", min, sec, ms);
    }
}
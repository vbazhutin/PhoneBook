package phonebook;

import java.util.List;

import static phonebook.LinearSearch.linearSearch;
import static phonebook.TimeTaken.calcTimeTaken;

public class LinearSearchAlgo {
    static long linearSearchTime = 0;

    static void linearSearchAlgo(List<String> data, List<String> find) {
        long algoStartTime = System.currentTimeMillis();
        long entriesFound = 0;
        long entriesTotal = find.size();
        System.out.println("Start searching (linear search)...");
        for (int i = 0; i < find.size(); i++) {
            if (linearSearch(data, find.get(i)) != -1) {
                entriesFound++;
            }
        }
        long algoEndTime = System.currentTimeMillis();
        linearSearchTime = algoEndTime - algoStartTime;
        System.out.printf("Found %s / %s entries.%nTime taken: %s%n"
                , entriesFound, entriesTotal, calcTimeTaken(algoStartTime, algoEndTime));
    }
}

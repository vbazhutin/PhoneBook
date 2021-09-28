package phonebook;

import java.util.List;

import static phonebook.BubbleSort.bubbleSort;
import static phonebook.JumpSearch.jumpSearch;
import static phonebook.LinearSearch.linearSearch;
import static phonebook.TimeTaken.calcTimeTaken;

public class BubbleSortAndJumpSearchAlgo {
    static void bubbleSortAndJumpSearchAlgo(List<String> data, List<String> find) {
        int entriesFound = 0;
        boolean sortFlag;
        System.out.println("\nStart searching (bubble sort + jump search)...");
        long startTime = System.currentTimeMillis();
        long sortStart = System.currentTimeMillis();
        sortFlag = bubbleSort(data);
        long sortEnd = System.currentTimeMillis();
        long searchStart = System.currentTimeMillis();
        for (int i = 0; i < find.size(); i++) {
            if (sortFlag) {
                if (jumpSearch(data, find.get(i)) != -1) {
                    entriesFound++;
                }
            } else {
                if (linearSearch(data, find.get(i)) != -1) {
                    entriesFound++;
                }
            }
        }
        long endTime = System.currentTimeMillis();

        System.out.printf("Found %d / %d entries. Time taken: %s"
                , entriesFound, find.size(), calcTimeTaken(startTime, endTime));
        if (sortFlag) {
            System.out.printf("%nSorting time: %s", calcTimeTaken(sortStart, sortEnd));
        } else {
            System.out.printf("%nSorting time: %s - STOPPED, moved to linear search", calcTimeTaken(sortStart, sortEnd));
        }
        System.out.printf("%nSearching time: %s%n", calcTimeTaken(searchStart, endTime));
    }
}

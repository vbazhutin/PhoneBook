package phonebook;

import java.util.List;

import static phonebook.LinearSearchAlgo.linearSearchTime;

public class BubbleSort {
    static boolean bubbleSort(List<String> array) {
        long sortStartTime = System.currentTimeMillis();
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = 0; j < array.size() - i - 1; j++) {
                /* if a pair of adjacent elements has the wrong order it swaps them */
                if (array.get(j).compareTo(array.get(j + 1)) > 0) {
                    String temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
                // Check if the time taken so far is more than time taken to do linear search
                long sortMidTime = System.currentTimeMillis();
                long timeDiff = sortMidTime - sortStartTime;
                if (timeDiff > linearSearchTime * 10) {
                    return false;
                }
            }
        }
        return true;
    }
}

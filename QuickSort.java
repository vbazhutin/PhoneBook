package phonebook;

import java.util.List;

import static phonebook.LinearSearchAlgo.linearSearchTime;

public class QuickSort {
    public static boolean quickSort(List<String> array, int left, int right) {
        long sortStartTime = System.currentTimeMillis();
        if (left < right) {
            // Check if the time taken so far is more than time taken to do linear search
            long sortMidTime = System.currentTimeMillis();
            long timeDiff = sortMidTime - sortStartTime;
            if (timeDiff > linearSearchTime * 10) {
                return false;
            }
            int pivotIndex = partition(array, left, right); // the pivot is already on its place
            quickSort(array, left, pivotIndex - 1);  // sort the left subarray
            quickSort(array, pivotIndex + 1, right); // sort the right subarray
        }
        return true;
    }

    private static int partition(List<String> array, int left, int right) {
        String pivot = array.get(right);  // choose the rightmost element as the pivot
        int partitionIndex = left; // the first element greater than the pivot

        /* move large values into the right side of the array */
        for (int i = left; i < right; i++) {
            if (array.get(i).compareTo(pivot) < 0) { // may be used '<' as well
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }

        swap(array, partitionIndex, right); // put the pivot on a suitable position

        return partitionIndex;
    }

    private static void swap(List<String> array, int i, int j) {
        String temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}

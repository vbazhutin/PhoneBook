package phonebook;

import java.util.List;

public class BinarySearch {
    static int binarySearch(List<String> array, String target) {
        int left = 0;
        int right = array.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // the index of the middle element
            int res = target.compareTo(array.get(mid));
            if (res == 0) {
                return mid; // the element is found, return its index
            } else if (res < 0) {
                right = mid - 1; // go to the left subarray
            } else {
                left = mid + 1;  // go to the right subarray
            }
        }
        return -1; // the element is not found
    }
}

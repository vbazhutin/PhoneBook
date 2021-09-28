package phonebook;

import java.util.List;

public class JumpSearch {
    static int jumpSearch(List<String> array, String target) {
        int currentRight = 0; // right border of the current block
        int prevRight = 0; // right border of the previous block
        /* Check the first element */
        if (array.get(currentRight).compareTo(target) == 0) {
            return 0;
        }
        /* Calculating the jump length over array elements */
        int jumpLength = (int) Math.sqrt(array.size());
        /* Finding a block where the element may be present */
        while (currentRight < array.size() - 1) {
            /* Calculating the right border of the following block */
            currentRight = Math.min(array.size() - 1, currentRight + jumpLength);
            if (array.get(currentRight).compareTo(target) >= 0) {
                break; // Found a block that may contain the target element
            }
            prevRight = currentRight; // update the previous right block border
        }
        /* If the last block is reached and it cannot contain the target value => not found */
        if ((currentRight == array.size() - 1) && array.get(currentRight).compareTo(target) < 0) {
            return -1;
        }
        /* Doing linear search in the found block */
        return backwardSearch(array, target, prevRight, currentRight);
    }

    static int backwardSearch(List<String> array, String target, int leftExcl, int rightIncl) {
        for (int i = rightIncl; i > leftExcl; i--) {
            if (array.get(i).equals(target)) {
                return i;
            }
        }
        return -1;
    }
}

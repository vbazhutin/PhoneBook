package phonebook;

import java.util.List;

public class LinearSearch {
    static int linearSearch(List<String> data, String target) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals(target)) {
                return i;
            }
        }
        return -1;
    }
}

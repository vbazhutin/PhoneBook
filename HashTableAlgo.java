package phonebook;

import java.util.List;

import static phonebook.TimeTaken.calcTimeTaken;

public class HashTableAlgo {
    static void hashTableAlgo(List<String> data, List<String> find) {
        Hash.HashTable hashTable = new Hash.HashTable(data.size() * 2);
        int entriesFound = 0;
        int k = 0;
        System.out.println("\nStart searching (hash table)...");
        long startTime = System.currentTimeMillis();
        long startCreateTime = System.currentTimeMillis();
        while (k < data.size()) {
            int key = Math.abs(data.get(k).hashCode());
            String value = data.get(k);
            hashTable.put(key, value);
            k++;
        }
        long stopCreateTime = System.currentTimeMillis();
        long searchStartTime = System.currentTimeMillis();
        for (int i = 0; i < find.size(); i++) {
            System.out.println(find.get(i));
            System.out.println(Math.abs(find.get(i).hashCode()));
            if (hashTable.findKey(Math.abs(find.get(i).hashCode())) != -1) {
                entriesFound++;
            }
        }
        long endTime = System.currentTimeMillis();

        System.out.printf("Found %d / %d entries. Time taken: %s"
                , entriesFound, find.size(), calcTimeTaken(startTime, endTime));
        System.out.printf("%nCreating time: %s", calcTimeTaken(startCreateTime, stopCreateTime));
        System.out.printf("%nSearching time: %s%n", calcTimeTaken(searchStartTime, endTime));
    }
}

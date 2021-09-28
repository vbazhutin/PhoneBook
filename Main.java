package phonebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static phonebook.BubbleSortAndJumpSearchAlgo.bubbleSortAndJumpSearchAlgo;
import static phonebook.HashTableAlgo.hashTableAlgo;
import static phonebook.LinearSearchAlgo.linearSearchAlgo;
import static phonebook.QuickSortAndBinarySearchAlgo.quickSortAndBinarySearchAlgo;


public class Main {

    public static void main(String[] args) throws IOException {
        String dataPath = "C:/Users/ensla/Downloads/directory.txt";
        String findPath = "C:/Users/ensla/Downloads/find.txt";

        List<String> data = Files.readAllLines(Paths.get(dataPath));
        List<String> find = Files.readAllLines(Paths.get(findPath));

        linearSearchAlgo(data, find);
        bubbleSortAndJumpSearchAlgo(data, find);
        quickSortAndBinarySearchAlgo(data, find);
        hashTableAlgo(data, find);
    }
}
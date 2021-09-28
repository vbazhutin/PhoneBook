package phonebook;

public class TimeTaken {
    static String calcTimeTaken(long startTime, long endTime) {
        long timeDiff = endTime - startTime;
        long ms = timeDiff % 1000;
        long sec = timeDiff / 1000 % 60;
        long min = timeDiff / 1000 / 60;
        return min + " min. " + sec + " sec. " + ms + " ms.";
    }
}

package utilities;

public class Wait {
    public static void sleep(double takenSecond) {
        try {
            takenSecond *= 1000;
            Thread.sleep((long) takenSecond);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

package util;

public class Timer {
    private static long pos = 0L;

    public static void start() {
        pos = System.currentTimeMillis();
    }

    public static void end() {
        long timed = System.currentTimeMillis() - pos;
        System.out.println(" 소요시간 " + timed);
    }
}

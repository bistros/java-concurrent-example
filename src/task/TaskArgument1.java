package task;

import java.util.concurrent.Callable;

public class TaskArgument1 implements Callable<String> {
    String msg;
    long sleep = 1000L;

    public TaskArgument1(String msg, long sleep) {
        this.msg = msg;
        this.sleep = sleep;
    }

    @Override
    public String call() throws Exception {
        if (sleep > 5000) {
            throw new RuntimeException("argument is too bad!");
        }
        Thread.sleep(sleep);
        return String.format("argument is %s %d /// Thread name is %s", msg, sleep, Thread.currentThread().getName());
    }
}

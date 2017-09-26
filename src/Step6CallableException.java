import task.TaskArgument1;
import util.Timer;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Step6CallableException {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // N개의 Callable Task 중 Exception이 발생 한다면
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Timer.start();
        Callable<String> callable = new TaskArgument1("task-1", 1000);
        Callable<String> callable2 = new TaskArgument1("task-2", 10000);
        Callable<String> callable3 = new TaskArgument1("task-3", 2000);
        List<Callable<String>> tasks = Arrays.asList(callable, callable2, callable3);

        Timer.start();
        List<Future<String>> result = executorService.invokeAll(tasks);

        for (Future<String> future : result) {
            try {
                System.out.println(future.get());
            }catch(ExecutionException e ) {
                System.out.println("ExecutionException");
            }
        }

        Timer.end();
        executorService.shutdownNow();
        /**
         * TODO
         * 1. Future가 발생 할 수 있는 Exception 들은?
         * 2.
         */
    }
}

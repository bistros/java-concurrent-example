import task.TaskArgument1;
import util.Timer;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Step5CallableParam {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Callable에 파라미터를 넘기는 방법

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Timer.start();
        Callable<String> callable = new TaskArgument1("task-1", 1000);
        Callable<String> callable2 = new TaskArgument1("task-2", 2000);

        List<Callable<String>> tasks = Arrays.asList(callable, callable2);

        Timer.start();
        List<Future<String>> result = executorService.invokeAll(tasks);

        for(Future<String> future: result){
            System.out.println(future.get() );
        }
        Timer.end();
        executorService.shutdownNow();

    }
}

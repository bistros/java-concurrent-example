import task.TaskEx1;
import task.TaskEx2;
import util.Timer;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Step4Executors {
    public static void main(String[] args) throws InterruptedException {

        Timer.start();
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return new TaskEx1().run();
            }
        };
        Callable<String> callable2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return new TaskEx2().run();
            }
        };
        List<Callable<String>> tasks = Arrays.asList(callable, callable2);

        Timer.start();
        List<Future<String>> result = executorService.invokeAll(tasks);
        System.out.println(String.format("결과값 = %s %s", result.get(0), result.get(1)));
        Timer.end();
        /**
         * TODO
         * 1. 소요시간은 얼마일까
         * 2. 가장 긴 Task 시간은 2000 인데 실제로  수행되는 시간은?
         * 3. 실행이 끝나도 왜 자바 Process는 종료되지 않을까?
         * 4. newFixedThreadPool(100) 이면 시작부터 끝까지 100개의 스레드가 존재할까?
         *
         */

    }
}

import util.Timer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Step7InvokeAllOrder {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Set<Callable<String>> tasks = new HashSet<>();
        Timer.start();
        for (int i = 1; i <= 10; i++) {
            final int order = i;
            tasks.add(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(order * 500);
                    return "param is " + order;
                }
            });
        }
        List<Future<String>> taskResult = executorService.invokeAll(tasks);
        for (int i = 0; i <= 10; i++) {
            System.out.println(taskResult.get(i).get());
        }
        /**
         * 1. 출력 순서는 1부터 10까지 나올까? invokeAll을 보고 설명
         * 2. Set을 유지한채 순서를 유지하려면 무엇을 override 해야 할까?
         * 3. 그렇다면 invokeAll(List)를 쓴다면 항상 순서가 보장이 될 까?
         *      참고 : foreach, iterable, arraylist의 구현체
         */
        executorService.shutdownNow();
    }
}

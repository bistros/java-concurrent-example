import task.TaskEx1;
import task.TaskEx2;
import util.Timer;

import java.util.concurrent.Callable;

public class Step3 {
    public static void main(String[] args) throws Exception {
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
        Timer.start();
        String result1 = callable.call();
        String result2 = callable2.call();
        System.out.println(String.format("결과값 = %s %s", result1, result2));
        Timer.end();
        /**
         * TODO
         * 1. 소요시간
         * 2. Thread는 Runnable을 처리한다. 그럼 Callable은 누가 처리할까 ? Next
         */
    }
}
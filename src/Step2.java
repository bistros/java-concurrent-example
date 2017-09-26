import task.TaskEx1;
import task.TaskEx2;
import util.Timer;

import java.util.HashMap;
import java.util.Map;

public class Step2 {
    public static void main(String[] args) throws InterruptedException {
        final Map dataBox = new HashMap<String, String>();
        Timer.start();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                dataBox.put("r1", "value");
                new TaskEx1().run();
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                new TaskEx2().run();
                dataBox.put("r2", "value");
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Timer.end(); // TODO : 소요 시간은 몇초?
        /**
         * TODO
         * 1. 소요시간은 몇초일까?
         * 2. 반환값이 없어서 위의 코드에서는 어떻게 처리 했는가?
         */
    }
}

package task;

public class TaskEx2 {
    public String run() {
        System.out.println(" 작업 2 : 2초 소모");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "TASK2 - OK";
    }
}

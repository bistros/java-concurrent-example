package task;

public class TaskEx1 {
    public String run() {
        System.out.println(" 작업 1 : 1초 소모");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "TASK1 - OK";
    }
}

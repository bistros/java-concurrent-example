import task.TaskEx1;
import task.TaskEx2;
import util.Timer;

public class Step1 {
    public static void main(String[] args) {
        TaskEx1 ex1 = new TaskEx1();
        TaskEx2 ex2 = new TaskEx2();
        Timer.start();
        System.out.println(ex1.run());
        System.out.println(ex2.run());
        Timer.end();// TODO : 소요 시간은 몇초?
    }
}

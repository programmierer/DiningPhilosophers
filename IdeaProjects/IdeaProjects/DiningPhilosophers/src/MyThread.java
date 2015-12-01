/**
 * Created by abuslavsky on 27.11.2015.
 */
public class MyThread implements Runnable {

    private String _name;

    MyThread(String name) {
        _name = name;
    }

    public void run () {
        //for (;;) {
        System.out.println(_name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

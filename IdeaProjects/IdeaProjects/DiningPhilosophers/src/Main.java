/**
 * Created by abuslavsky on 27.11.2015.
 */
public class Main {

   /* static String[] _names;
    static Thread[] _threads;

    private int _parameter;

    public Main(int parameter) {
    _parameter = parameter;
    }


    public static void main(String[] args) throws InterruptedException {

        _threads = new Thread[5];
        _names = new String[_threads.length];
        Thread[] mainThreads = new Thread[_threads.length];
        for(int i = 0; i < mainThreads.length; i++) {
            mainThreads[i] = new Thread(new Main(i));
            mainThreads[i].start();
            mainThreads[i].join();
        }
        //mainThreads[0].join();
        System.out.println("Main Thread Finished");

    }
	   /* Thread[] threads = new Thread[5];
        String[] names = new String[threads.length];
        for (int i = 0; i < threads.length; i++) {
            names[i] = "Thread numb " + (i + 1);
            threads[i] = new Thread(new MyThread(names[i]));
            System.out.println("State " + names[i] + ": " + threads[i].getState());
            threads[i].start();
            System.out.println("State " + names[i] + ": " + threads[i].getState());
            Thread.sleep(500);
            System.out.println("State " + names[i] + ": " + threads[i].getState());
            Thread.sleep(2000);
            System.out.println("State " + names[i] + ": " + threads[i].getState());
        }


        private synchronized void action() {  //только один поток будет выполнять

        }
    private void action(Object lock) {
        synchronized (lock) {

        }
    }

        public void run() {
            _names[_parameter] = "Thread numb " + (_parameter + 1);
            _threads[_parameter] = new Thread(new MyThread(_names[_parameter]));
        System.out.println("State " + _names[_parameter] + ": " + _threads[_parameter].getState());
        _threads[_parameter].start();
        System.out.println("State " + _names[_parameter] + ": " + _threads[_parameter].getState());
            try {
                Thread.sleep(500);

            }  catch (InterruptedException e) {
                    e.printStackTrace();
                }
        System.out.println("State " + _names[_parameter] + ": " + _threads[_parameter].getState());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

        System.out.println("State " + _names[_parameter] + ": " + _threads[_parameter].getState());
        }



    }*/

    public static void main(String[] args) throws InterruptedException {
        int count = 2;
        World[] worlds = new World[count];
        Persona[] persons = new Persona[count];
        Object[] forks = new Object[count];
        Object[] knives = new Object[count];
        for (int i = 0; i < count; i++) {
            persons[i] = new Persona(("Persona numb" + (i + 1)));
            worlds[i] = new World(persons[i]);

        }
        for (int i = 0; i < count - 1; i++) {
            forks[i] = new Object();
            knives[i] = new Object();
        }
        for (int i = 0; i < count; i++) {
            worlds[i].setKnife(knives[((i + 1) >= count - 1) ? 0 : (i + 1)]);

        }
        for (int i = 0; i < count; i++) {
            worlds[i].setFork(forks[((i) >= count - 1 ? 0 : (i))]);

        }
    }
}
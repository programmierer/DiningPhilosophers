/**
 * Created by abuslavsky on 27.11.2015.
 */
public class World implements Runnable {

    Thread _thread;
    Persona _persona;
    Object _fork = null;
    Object _knife = null;


    public World(Persona persona) {
        _thread = new Thread(this, "World for " + persona.getName());
        _thread.start();
        _persona = persona;
    }

    public void setFork(Object fork) {
        _fork = fork;
    }

    public void setKnife(Object knife) {
        _knife = knife;
    }

    public void run() {
        System.out.println(_thread.getName() + " started.");
        while(true) {
            if (_fork == null || _knife == null) {
                Thread.yield();
                continue;
            }



            //Thread.sleep((int)(Math.random()*1000));
            synchronized (_fork) {
                try {
                    Thread.sleep((int)(Math.random()*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (_knife) {
                    _persona.setKnife(_knife);
                    _persona.setFork(_fork);
                    System.out.println(_persona.getName() + ": " + _persona.getState());
                    try {
                        Thread.sleep((int)(Math.random()*1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    _persona.setKnife(null);
                    _persona.setFork(null);
                    System.out.println(_persona.getName() + ": " + _persona.getState());
                }
                try {
                    Thread.sleep((int)(Math.random()*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
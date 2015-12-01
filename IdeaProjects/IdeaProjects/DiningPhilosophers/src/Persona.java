/**
 * Created by abuslavsky on 27.11.2015.
 */
public class Persona {

    String _name;
    State _state;
    Object _fork;
    Object _knife;


    public Persona(String name) {
        _name = name;
        _state = State.Think;

    }

    public void setKnife(Object knife) {
        _knife = knife;
        updateState();
    }

    public void setFork(Object fork) {

        _fork = fork;
        updateState();
    }
    public State getState() {
        return _state;
    }

    private void updateState() {
        _state = _fork != null && _knife != null ? State.Eat : State.Think;
    }

    public String getName() {
        return _name;
    }
}

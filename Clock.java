public class Clock {
    private int _time;

    public Clock() {
        System.out.println("Clock constructed");
    }

    public void tick() {
        _time++;
    }

    public int getTime() {
        System.out.println("TIME: " + _time);
        return _time;
    }
}
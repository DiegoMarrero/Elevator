public class Clock {
    private int time;

    public Clock() {
        System.out.println("Clock constructed");
    }

    public void tick() {
        time++;
    }

    public int getTime() {
        System.out.println("TIME: " + time);
        return time;
    }
}
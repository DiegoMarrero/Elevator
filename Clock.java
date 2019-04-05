public class Clock {

    // Class variables
    private int time;

    Clock() {

        // Initialize time at 0
        time = 0;

        System.out.println("Clock constructed");
    }

    // Increment time by 1
    public void tick() {
        time++;
    }

    // Return current time
    public int getTime() {
        return clock;
    }
}
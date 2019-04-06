import java.util.Scanner;

public class Building {
    private Floor _floor1;
    private Floor _floor2;
    private Elevator _elevator;
    private Clock _clock;
    private Scheduler _scheduler;

    public Building() {
        _floor1 = new Floor(Floor.FLOOR1);
        _floor2 = new Floor(Floor.FLOOR2);

        _elevator = new Elevator(_floor1, _floor2);
        
        _floor1.setFloorButton(_elevator);
        _floor2.setFloorButton(_elevator);
        
        _scheduler = new Scheduler(_floor1, _floor2);
        _clock = new Clock();

        System.out.println("building constructed");
    }

    public void runSimulation(int totalTime) {
        int currentTime = 0;

        while (currentTime < totalTime) {
            _clock.tick();
            currentTime = _clock.getTime();

            System.out.println("TIME: " + _clock.getTime());

            _scheduler.processTime(currentTime);
            _elevator.processTime(currentTime);

            System.out.println("Press \"ENTER\" to continue...");
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
            sc.close();
        }
    }
}
public class Building {
    private Floor floor1, floor2;
    private Elevator elevator;
    private Clock clock;
    private Scheduler scheduler;

    public Building() {
        System.out.println("building constructed");

        clock = new Clock();

        floor1 = new Floor(Floor.FLOOR1);
        floor2 = new Floor(Floor.FLOOR2);

        elevator = new Elevator(floor1,floor2);

        floor1.setFloorButton(elevator);
        floor2.setFloorButton(elevator);

        scheduler = new Scheduler(this.floor1, this.floor2);
    }

    public void runSimulation(int totalTime) {
        int currentTime = 0;

        while (currentTime < totalTime) {
            clock.tick();
            currentTime = clock.getTime();

            scheduler.processTime(currentTime);
            elevator.processTime(currentTime);
        }
    }
}
public class Elevator {
    ElevatorButton elevatorButton;

    private static final int UP = 0, DOWN = 1, travelTime = 5;

    private Person passenger;
    private Floor floor1, floor2;

    private boolean moving, floor1NeedsService, floor2NeedsService;

    private int direction, arrivalTime, currentFloor, currentBuildingClockTime;

    private Bell bell;
    private Door door;

    public Elevator(Floor floor1, Floor floor2) {
        elevatorButton = new ElevatorButton(this);
        direction = UP;
        currentFloor = Floor.FLOOR1;
        this.floor1 = floor1;
        this.floor2 = floor2;
        door = new Door();
        bell = new Bell();

        System.out.println("elevator constructed");
    }

    public void summon(int floor) {
        if (floor == Floor.FLOOR1)
            floor1NeedsService = true;
        else
            floor2NeedsService = true;
    }

    public void prepareToLeave(boolean leaving) {
        var thisFloor = isCurrentFloorFirstFloor() ? floor1 : floor2;
        
        thisFloor.elevatorLeaving();
        door.close(thisFloor);

        if (leaving)
            move();
    }

    public void processTime(int time) {
        currentBuildingClockTime = time;

        if (moving)
            processPossibleArrival();
        else
            processPossibleDeparture();
        if (!moving)
            System.out.println("elevator at rest on floor " + currentFloor);
    }

    public void passengerEnters(Person person) {
        passenger = person;

        System.out.println("person " + passenger.getID() + " enters elevator from floor " + currentFloor);
    }

    public void passengerExits() {
        passenger = null;
    }

    private void processPossibleArrival() {
        // if elevator arrived at destination
        if (currentBuildingClockTime == arrivalTime) { 

            // Update current floor
            this.currentFloor = isCurrentFloorFirstFloor() ? Floor.FLOOR2 : Floor.FLOOR1;

            boolean firstFloor = isCurrentFloorFirstFloor();

            direction = firstFloor ? UP : DOWN;

            System.out.println("elevator arrives on floor " + this.currentFloor);

            arriveAtFloor(firstFloor ? floor1 : floor2);
        } else
            System.out.println("elevator moving " + (direction == UP ? "up" : "down"));
    }

    private void processPossibleDeparture() {
        boolean currentFloor = isCurrentFloorFirstFloor();

        boolean currentFloorNeedsService = currentFloor ? floor1NeedsService : floor2NeedsService;
        boolean otherFloorNeedsService = currentFloor ? floor2NeedsService : floor1NeedsService;

        if (currentFloorNeedsService)
            arriveAtFloor(currentFloor ? floor1 : floor2);
        else if (otherFloorNeedsService)
            prepareToLeave(true);
    }

    private void arriveAtFloor(Floor arrivalFloor) {
        moving = false;

        bell.ring();
        elevatorButton.reset();

        Person floorPerson = arrivalFloor.elevatorArrived();

        door.open(passenger, floorPerson, arrivalFloor, this);

        boolean currentFloorNeedsService = isCurrentFloorFirstFloor() ? floor1NeedsService : floor2NeedsService;

        boolean otherFloorNeedsService = isCurrentFloorFirstFloor() ? floor2NeedsService : floor1NeedsService;

        if (!currentFloorNeedsService)
            prepareToLeave(otherFloorNeedsService);
        else if (isCurrentFloorFirstFloor())
            floor1NeedsService = false;
        else
            floor2NeedsService = false;
    }

    private boolean isCurrentFloorFirstFloor() {
        return currentFloor == Floor.FLOOR1;
    }

    private void move() {
        moving = true;

        arrivalTime = currentBuildingClockTime + travelTime;

        boolean goingDown = direction == DOWN;

        System.out.println("elevator begins moving " + (goingDown ? "down" : "up") + " to floor " + (goingDown ? '1' : '2') + " (arrives at time " + arrivalTime + ")");
    }
}
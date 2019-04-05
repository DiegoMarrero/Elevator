/**
 * Elevator
 */
public class Elevator {
    ElevatorButton elevatorButton;

    final int UP = 0;
    final int DOWN = 1;
    final int ELEVATOR_TRAVEL_TIME = 5;

    private Person passenger;
    private Floor floor1;
    private Floor floor2;

    private boolean moving;
    private boolean floor1NeedsService;
    private boolean floor2NeedsService;

    private int direction;
    private int arrivalTime;
    private int currentFloor;
    private int currentBuildingClockTime;

    private Bell bell;
    private Door door;

    public Elevator(Floor firstFloor, Floor secondFloor) {
        elevatorButton = new ElevatorButton(this);
        currentBuildingClockTime = 0;
        moving = false;
        direction = UP;
        currentFloor = Floor.FLOOR1;
        arrivalTime = 0;
        floor1NeedsService = false;
        floor2NeedsService = false;
        floor1 = firstFloor;
        floor2 = secondFloor;
        passenger = new Person(0);

        System.out.println("elevator constructed");
    }

    public void summonElevator(int floor) {
        if (floor == Floor.FLOOR1) {
            floor1NeedsService = true;
        } else {
            floor2NeedsService = true;
        }
    }

    public void prepareToLeave(boolean leaving) {
        Floor thisFloor = currentFloor == Floor.FLOOR1 ? floor1 : floor2;

        thisFloor.elevatortLeaving();

        door.closeDoor(thisFloor);

        if (leaving) {
            move();
        }
    }

    public void processTime(int time) {
        currentBuildingClockTime = time;

        if (moving) {
            processPossibleArrival();
        } else {
            processPossibleDeparture();
            System.out.println("elevator at rest on floor " + currentFloor);
        }
    }

    public void passengerEnters(Person person) {
        passenger = person;

        System.out.println("person " + passenger.getID() + "enters elevator from floor " + currentFloor);
    }

    public void passengerExits() {
        passenger = new Person(0);
    }

    private void processPossibleArrival() {
        if (currentBuildingClockTime == arrivalTime) {
            currentFloor = currentFloor == Floor.FLOOR1 ? Floor.FLOOR2 : Floor.FLOOR1;

            direction = currentFloor == Floor.FLOOR1 ? UP : DOWN;

            System.out.println("elevator arrives on floor " + currentFloor);

            arriveAtFloor(currentFloor == Floor.Floor1 ? floor1 : floor2);
        }

        System.out.println("elevator moving " + (direction == UP ? "up" : "down"));
    }

    private void processPossibleDeparture() {
        boolean currentFloorNeedsService = currentFloor == Floor.FLOOR1 ? floor1NeedsService : floor2NeedsService;

        boolean otherFloorNeedsService = currentFloor == Floor.FLOOR1 ? floor2NeedsService : floor1NeedsService;

        if (currentFloorNeedsService) {
            arriveAtFloor(currentFloor == Floor.FLOOR1 ? floor1 : floor2);
        } else if (otherFloorNeedsService) {
            prepareToLeave(true);
        }
    }

    private void arriveAtFloor(Floor arrivalFloor) {
        moving = false;

        System.out.println("elevator resets button");

        elevatorButton.resetButton();

        bell.ringBell();

        Person floorPerson = arrivalFloor.elevatorArrived();

        door.openDoor(passenger, floorPerson, arrivalFloor, this);

        boolean currentFloorNeedsService = currentFloor == Floor.FLOOR1 ? floor1NeedsService : floor2NeedsService;

        boolean otherFloorNeedsService = currentFloor == Floor.FLOOR1 ? floor2NeedsService : floor1NeedsService;

        if (!currentFloorNeedsService) {
            prepareToLeave(otherFloorNeedsService);
        } else if (currentFloor == Floor.FLOOR1) {
            floor1NeedsService = false;
        } else {
            floor1NeedsService = false;
        }
    }

    private void move() {
        moving = true;

        arrivalTime = currentBuildingClockTime + ELEVATOR_TRAVEL_TIME;

        System.out.println("elevator begins moving " + (direction == DOWN ? "down" : "up") + " to floor"
                + (direction == DOWN ? '1' : '2') + " (arrives at time " + arrivalTime + ")");
    }
}
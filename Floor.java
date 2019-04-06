public class Floor {
    static final int FLOOR1 = 1;
    static final int FLOOR2 = 2;

    FloorButton floorButton;

    private final int floorNumber;
    private Elevator elevator;
    private Person occupant;
    private Light light;

    public Floor(int number, Elevator elevator) {
        floorButton = new FloorButton(number, elevator);
        floorNumber = number;
        this.elevator = elevator;
        occupant = null;
        light = new Light(0);
    }

    public boolean isOccupied() {
        return occupant == null ? false : true;
    }

    public int getNumber() {
        return floorNumber;
    }

    public void personArrives(Person person) {
        occupant = person;
    }

    public Person elevatorArrived() {
        System.out.println("floor " + floorNumber + " resets its button");

        floorButton.resetButton();
        light.turnOn();

        return occupant;
    }

    public void elevatorLeaving() {
        light.turnOff();
    }

    public void personBoardingElevator() {
        occupant = null;
    }

}
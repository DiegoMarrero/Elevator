public class Floor {
    static final int FLOOR1 = 1;
    static final int FLOOR2 = 2;

    FloorButton floorButton;

    private final int floorNumber;
    private Person occupant;
    private Light light;

    public Floor(int number) {
        floorNumber = number;
        occupant = null;
        light = new Light(number);
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

    public void setFloorButton(Elevator elevator) {
        floorButton = new FloorButton(floorNumber, elevator);
    }
}
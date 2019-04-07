public class Floor {
    static final int FLOOR1 = 1, FLOOR2 = 2;

    FloorButton floorButton;

    private final int floorNumber;
    private Person occupant;
    private Light light;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        light = new Light(floorNumber);

        System.out.println("floor " + floorNumber + " constructed");
    }

    public boolean isOccupied() {
        return occupant == null ? false : true;
    }

    public int getNumber() {
        return floorNumber;
    }

    public void personArrives(Person person) {
        occupant = person;
        System.out.println("Person " + occupant.getID() + " steps onto the floor " + floorNumber);
    }

    public Person elevatorArrived() {
        light.on();
        floorButton.reset();

        return occupant;
    }

    public void elevatorLeaving() {
        light.off();
    }

    public void personBoardingElevator() {
        occupant = null;
    }

    public void setFloorButton(Elevator elevator) {
        floorButton = new FloorButton(floorNumber, elevator);
    }
}
import Floor;
import Elevator;

public class Person {

    // Variables
    private int ID;                // person's unique ID #
    private int destinationFloor;  // destination floor #
    static int personCount = 0;        // total number of people

    //Constructor
    Person(int destFloor) {
        ID++;
        personCount++;

        System.out.println("Person " + ID + " constructed");
    }

    // return ID
    public int getID() {

        return ID;
    }

    // Person walks onto a floor
    public void stepOntoFloor(Floor floor) {

        // Notify floor person is coming
        System.out.println("Person " + ID + " steps onto the floor " + floor.getNumber());
        floor.personArrive(this); 

        // Press button floor
        System.out.println("Person " + ID + " presses floor button on floor" + floor.getNumber());
        floor.floorButton.pressButton();
    }

    // Person enters elevator
    public void enterElevator(Floor floor, Elevator elevator) {

        floor.personBoardingElevator();  // Person leaves floor
        
        elevator.passengerEnters(this); // Person enters elevator

        System.out.println("Person " + " presses elevator buttton");
        elevator.elevatorButton.pressButton();
    }   

    // Person exits elevator
    public void exitElevator(Floor floor, Elevator elevator) {

        System.out.println("Person " + ID + " exits elevator on floor" + floor.getNumber());
        elevator.passengerExits();
    }
}
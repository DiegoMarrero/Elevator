import java.util.Random;

public class Scheduler {
    private int _currentClockTime;
    private Floor _floor1;
    private Floor _floor2;

    private int _floor1ArrivalTime;
    private int _floor2ArrivalTime;

    public Scheduler(Floor floor1, Floor floor2) {
        _currentClockTime = 0;

        _floor1 = floor1;
        _floor2 = floor2;

        System.out.println("scheduler constructed");

        scheduleTime(_floor1);
        scheduleTime(_floor2);
    }

    public void processTime(int time) {

        _currentClockTime = time;

        handleArrivals(_floor1);
        handleArrivals(_floor2);
    }

    private void scheduleTime(Floor floor) {
        int floorNumber = floor.getNumber();
        Random rand = new Random();

        int arrivalTime = _currentClockTime + (5 + rand.nextInt() % 16);

        if (floorNumber == Floor.FLOOR1) {
            _floor1ArrivalTime = arrivalTime;
        } else {
            _floor2ArrivalTime = arrivalTime;
        }

        System.out.println("(scheduler schedules next person for floor " + floorNumber + " at time " + arrivalTime + ')');
    }

    private void delayTime(Floor floor) {
        int floorNumber = floor.getNumber();

        int arrivalTime;

        if (floorNumber == Floor.FLOOR1) {
            arrivalTime = ++_floor1ArrivalTime;
        } else {
            arrivalTime = ++_floor2ArrivalTime;
        }

        System.out.println("(scheduler delays next person for floor " + floorNumber + " until time " + arrivalTime + ')');
    }

    private void createNewPerson(Floor floor) {
        int destinationFloor;

        if (floor.getNumber() == Floor.FLOOR1) {
            destinationFloor = Floor.FLOOR2;
        } else {
            destinationFloor = Floor.FLOOR1;
        }

        Person person = new Person(destinationFloor);
        person.stepOntoFloor(floor);

        scheduleTime(floor);
    }

    private void handleArrivals(Floor floor) {
        int floorNumber = floor.getNumber();

        int arrivalTime;

        if (floorNumber == Floor.FLOOR1) {
            arrivalTime = _floor1ArrivalTime;
        } else {
            arrivalTime = _floor2ArrivalTime;
        }

        if (arrivalTime == _currentClockTime) {
            if (floor.isOccupied()) {
                delayTime(floor);
            } else {
                createNewPerson(floor);
            }
        }
    }
}
import java.util.Random;

public class Scheduler {
    private int currentClockTime;
    private Floor floor1, floor2;

    private int floor1ArrivalTime, floor2ArrivalTime;

    public Scheduler(Floor floor1, Floor floor2) {
        this.floor1 = floor1;
        this.floor2 = floor2;

        System.out.println("scheduler constructed");

        scheduleTime(floor1);
        scheduleTime(floor2);
    }

    public void processTime(int time) {

        currentClockTime = time;

        handleArrivals(floor1);
        handleArrivals(floor2);
    }

    private void scheduleTime(Floor floor) {
        int randomNumber = getRandomNumber();

        int arrivalTime = currentClockTime + (5 + randomNumber % 16);
        int floorNumber = floor.getNumber();

        if (floorNumber == Floor.FLOOR1)
            floor1ArrivalTime = arrivalTime;
        else
            floor2ArrivalTime = arrivalTime;

        System.out.println("(scheduler schedules next person for floor " + floorNumber + " at time " + arrivalTime + ')');
    }

    private int getRandomNumber(){
        var rand = new Random();
        int num = rand.nextInt();
        return num > 0 ? num : num * -1;
    }

    private void delayTime(Floor floor) {
        int floorNumber = floor.getNumber();

        int arrivalTime;

        if (floorNumber == Floor.FLOOR1) {
            arrivalTime = ++floor1ArrivalTime;
        } else {
            arrivalTime = ++floor2ArrivalTime;
        }

        System.out.println("(scheduler delays next person for floor " + floorNumber + " until time " + arrivalTime + ')');
    }

    private void createNewPerson(Floor floor) {
        Person person = new Person();
        person.stepOntoFloor(floor);

        scheduleTime(floor);
    }

    private void handleArrivals(Floor floor) {

        int arrivalTime = floor.getNumber() == Floor.FLOOR1 ? floor1ArrivalTime : floor2ArrivalTime;

        if (arrivalTime == currentClockTime) {
            if (floor.isOccupied())
                delayTime(floor);
            else
                createNewPerson(floor);
        }
    }
}
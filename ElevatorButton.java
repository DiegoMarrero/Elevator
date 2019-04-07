public class ElevatorButton {
    private Elevator elevator;

    public ElevatorButton(Elevator elevator) {
        this.elevator = elevator;
        System.out.println("elevator button costructed");
    }

    public void press() {
        System.out.println("elevator button tells elevator to prepare to leave");
        elevator.prepareToLeave(true);
    }

    public void reset() {
        System.out.println("elevator resets button");
    }
}
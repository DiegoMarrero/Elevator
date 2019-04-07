public class ElevatorButton {
    private Elevator _elevator;

    public ElevatorButton(Elevator elevator) {
        _elevator = elevator;
        System.out.println("elevator button costructed");
    }

    public void pressButton() {
        System.out.println("elevator button tells elevator to prepare to leave");
        _elevator.prepareToLeave(true);
    }

    public void resetButton() {
        System.out.println("elevator resets button");
    }
}
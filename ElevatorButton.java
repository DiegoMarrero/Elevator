public class ElevatorButton {
    private boolean _pressed;
    private Elevator _elevator;

    public ElevatorButton(Elevator elevator) {
        _pressed = false;
        _elevator = elevator;
    }

    public void pressButton() {
        _pressed = true;
        System.out.println("elevator button tells elevator to prepare to leave");

        _elevator.prepareToLeave(true);
    }

    public void resetButton() {
        _pressed = false;
    }
}
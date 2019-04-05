/**
 * ElevatorButton
 */
public class ElevatorButton {
    private boolean pressed;
    private Elevator elevator;

    
    public ElevatorButton(Elevator elevator) {
        this.pressed = false;
        this.elevator = elevator;
    }

    public void pressButton() {
        this.pressed = true;
        System.out.println("elevator button tells elevator to prepare to leave");

        this.elevator.prepareToLeave(true);
    }

    public void resetButton() {
        this.pressed = false;
    }
}
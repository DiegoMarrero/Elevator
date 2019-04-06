public class FloorButton {

	private final int _floorNumber;
	private boolean _pressed;
	private Elevator _elevator;

	// constructor
	public FloorButton(int floor, Elevator elevator) {
		_floorNumber = floor;
		_pressed = false;
		_elevator = elevator;

		System.out.println("floor " + _floorNumber + " button constructed");
	}// end FloorButton constructor

	public void pressButton() {
		_pressed = true;
		System.out.println("floor " + _floorNumber + " button summons elevator");

		// call elevator to this floor

		_elevator.summonElevator(_floorNumber);
	}// end function pressButton

	// reset button

	public void resetButton() {
		_pressed = false;
	}// end function resetButton
}

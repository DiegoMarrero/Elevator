public class FloorButton {

	private final int _floorNumber;
	private Elevator _elevator;

	// constructor
	public FloorButton(int floorNumber, Elevator elevator) {
		_floorNumber = floorNumber;
		_elevator = elevator;

		System.out.println("floor " + _floorNumber + " button constructed");
	}// end FloorButton constructor

	public void pressButton() {
		System.out.println("floor " + _floorNumber + " button summons elevator");

		// call elevator to this floor
		_elevator.summonElevator(_floorNumber);
	}// end function pressButton

	// reset button

	public void resetButton() {
		System.out.println("floor " + _floorNumber + " resets its button");
	}// end function resetButton
}

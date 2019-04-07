public class FloorButton {

	private final int floorNumber;
	private Elevator elevator;

	public FloorButton(int floorNumber, Elevator elevator) {
		this.floorNumber = floorNumber;
		this.elevator = elevator;

		System.out.println("floor " + floorNumber + " button constructed");
	}

	public void press() {
		System.out.println("floor " + floorNumber + " button summons elevator");

		// call elevator to this floor
		elevator.summon(floorNumber);
	}

	public void reset() {
		System.out.println("floor " + floorNumber + " resets its button");
	}
}

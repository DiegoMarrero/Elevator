public class Door {

	private boolean open;

	public Door() {
		System.out.println("door constructed");
	}

	public void open(Person passenger, Person nextPassenger, Floor currentFloor, Elevator elevator) {
		if (!open) {
			open = true;

			System.out.println("elevator opens its door on floor " + currentFloor.getNumber());

			// if passenger is in elevator, tell person to leave
			if (passenger != null) {
				passenger.exitElevator(currentFloor, elevator);
				passenger = null;
			}

			// if passenger waiting to enter elevator, tell passenger to enter
			if (nextPassenger != null) {
				nextPassenger.enterElevator(currentFloor, elevator);
			}
		}
	}

	public void close(Floor currentFloor) {
		if (open) {
			open = false;
			System.out.println("elevator closes its door on floor " + currentFloor.getNumber());
		}
	}

}

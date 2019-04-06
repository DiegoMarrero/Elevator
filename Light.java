public class Light {

	private boolean on;
	private final int floorNumber;

	// constructor
	public Light(int number) { // Light class definition

		floorNumber = number;
		on = false;

		System.out.println("floor " + floorNumber + " light constructed");
	}

	// turn light on
	public void turnOn() { // if light not on, turn it on
		if (!on) {
			on = true;
			System.out.println("floor " + floorNumber + " light turns on");
		} // end if
	}// end function turnOn

	public void turnOff() {
		if (on) {
			on = false;
			System.out.println("floor " + floorNumber + " light turns off");
		} // end if
	}// end function turnOff
}
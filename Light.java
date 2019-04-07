public class Light {

	private boolean on;
	private final int floorNumber;

	// constructor
	public Light(int floorNumber) {
		this.floorNumber = floorNumber;

		System.out.println("floor " + this.floorNumber + " light constructed");
	}

	// turn light on
	public void turnOn() {
		// if light not on, turn it on
		if (!this.on) {
			this.on = true;
			System.out.println("floor " + this.floorNumber + " light turns on");
		} // end if
	}// end function turnOn

	public void turnOff() {
		if (this.on) {
			this.on = false;
			System.out.println("floor " + this.floorNumber + " light turns off");
		} // end if
	}// end function turnOff
}
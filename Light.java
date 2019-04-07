public class Light {

	private boolean on;
	private final int floorNumber;

	public Light(int floorNumber) {
		this.floorNumber = floorNumber;

		System.out.println("floor " + floorNumber + " light constructed");
	}

	public void on() {
		if (!on) {
			on = true;
			System.out.println("floor " + floorNumber + " light turns on");
		}
	}

	public void off() {
		if (on) {
			on = false;
			System.out.println("floor " + floorNumber + " light turns off");
		}
	}
}
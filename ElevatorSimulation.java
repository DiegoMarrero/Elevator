import java.util.Scanner;

public class ElevatorSimulation {

	public static void main(String[] args) {
		
		// Scanner instance
		var input = new Scanner(System.in);
		
		System.out.print("Enter run time: ");
		int duration = input.nextInt(); // length of simulation in seconds
		input.close();
		
		System.out.println("*** ELEVATOR SIMULATION BEGINS ***\n\n");
		
		var building = new Building();
		building.runSimulation(duration);
		
		System.out.println("\n\n*** ELEVATOR SIMULATION ENDS ***");
	}

}

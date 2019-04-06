import java.util.Scanner;

public class ElevatorSimulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Scanner instance
		Scanner input = new Scanner(System.in);
		
		Building building = new Building();
		
		int duration; // length of simulation in seconds
		
		System.out.println("Enter run time: ");
		duration = input.nextInt();
		
		System.out.println("*** ELEVATOR SIMULATION BEGINS ***");
		
		building.runSimulation(duration);
		
		System.out.println("*** ELEVATOR SIMULATION ENDS ***");
	}

}

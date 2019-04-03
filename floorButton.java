package test;

public class floorButton {
	
	int floor, floorNumber, elevatorRef;
	boolean pressed;
	
	//constructor
	public floorButton(floor, Elevator elevatorHandle)
	floorNumber=floor;
	pressed=false;
	elevatorRef=elevatorHandle;
	{
		System.out.println(dlooeNumber+"button constructed");
	}//end FloorButton constructor
	
	public void pressButton()
	{
		pressed=true;
		System.out.println("floor"+floorNumber+"button summons elevator");
		
		//call elevator to this floor
		
		elevatorRef.summonElevator(floorNumber);
	}//end function pressButton
	
	//reset button
	
	public void resetButton()
	{
		pressed=false;
	}//end function resetButton
}

package control;

import java.util.Scanner;
import robot.Robot;

// Robot Assignment for Programming 1 s2 2016
// Adapted by Caspar from original Robot code in RobotImpl.jar written by Dr Charles Thevathayan
public class RobotControl implements Control
{
	private Robot robot;

	private static final int MAX_HEIGHT = 13;

	private int height = 2;
	private int width = 1;
	private int depth = 0;
	
	private Scanner keyboard = new Scanner(System.in); //scanner
	
	// called by RobotImpl
	// the unused arrays are based on cmd line params to RobotImpl not used in this assignment
	@Override
	public void control(Robot robot, int barHeightsUnused[],
			int blockHeightsUnused[])
	{
		// save robot so we can access it from other methods
		this.robot = robot;
		
		
		// ASSIGNMENT PART A
		// replace this code with a console based menu to populate the arrays
		System.out.print("Enter number of bars (min 1/max 6):");
		
		int numBars;
		if (keyboard.hasNextInt())	{
			numBars = keyboard.nextInt(); //if input isn't an integer it equals 0
		}	else {
			keyboard.next();
			numBars = 0;
		}
		while((numBars<1  || numBars>6) ){ //if input isn't between 1-6 it will error and start again
			
			System.out.println("error");
			System.out.println("Enter number of bars (min 1/max 6):");
			numBars = keyboard.nextInt();
		}
			
		
		
		
		int barHeights[] = new int[numBars];
		for(int i=0;i<numBars;i++){ // i = previous input | i being the number of times the loop will repeat
			System.out.println("Enter height of bar "+ (i+1) +" of "+numBars+" (min 1/max 7):");
			barHeights[i]=keyboard.nextInt();
			
			while((barHeights[i]<1  || barHeights[i]>7) ){
			
			System.out.println("error");
			System.out.println("Enter height of bar "+ (i+1) +" of "+numBars+" (min 1/max 7):");
			barHeights[i] = keyboard.nextInt();
		
		}
		}
		
		
		System.out.println("Enter number of blocks (min 1/max 6):");
		int numBlocks = keyboard.nextInt();
		while((numBlocks<1  || numBlocks>6) ){
			
			System.out.println("error");
			System.out.println("Enter number of blocks (min 1/max 6):");
			numBlocks = keyboard.nextInt();
		}
		
		int blockHeights[] = new int[numBlocks];
		for(int i=0;i<numBlocks;i++){
			System.out.println("Enter height of block " + (i+1) + " of " + numBlocks + " (min 1 max 3):");
			blockHeights[i]=keyboard.nextInt();
		
			while((blockHeights[i]<1  || blockHeights[i]>3) ){
				
			System.out.println("error");
			System.out.println("Enter height of block " + (i+1) + " of " + numBlocks + " (min 1 max 3):");
			blockHeights[i] = keyboard.nextInt();
		
		}
		
		}
		
		System.out.println("Input Successfully Completed");
	

		// initialise the robot
		robot.init(barHeights, blockHeights, height, width, depth);

		// a simple private method to demonstrate how to control (assignment PART B)
		moveToHeight(MAX_HEIGHT);
		
		// assignment part B implemented here
	}

	private void moveToHeight(int height)
	{
		while (this.height < height)
		{
			robot.up();
			this.height++;
		}
	}
	
	// assignment part B methods implemented here
}

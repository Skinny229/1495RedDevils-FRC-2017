package org.usfirst.frc.team1495.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class TestVision extends Command {

    public TestVision() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    NetworkTable visionTableTest;
    double midX;
    boolean hasFinished;
    // Called just before this Command runs the first time
    protected void initialize() {
    	visionTableTest = NetworkTable.getTable("GRIP/gearContourReport");
    	hasFinished = false;
    }

    // Called repeatedly when this Command is scheduled to run

	protected void execute() {
		double c[] = {1.0,2.0},thisarray[];
		//visionTableTest = NetworkTable.getTable("GRIP/gearContourReport");
		thisarray = visionTableTest.getNumberArray("centerX", c);
		
		if(thisarray.length == 2){
    	System.out.println("1st: "+ thisarray[0] + " 2nd: " + thisarray[1]);
    	Timer.delay(.05);
		}else{
			System.out.println("Targets not found!!!");
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

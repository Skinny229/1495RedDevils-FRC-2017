package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class RecordAllSensorData extends Command {

    public RecordAllSensorData() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		requires(Robot.gyro);
		requires(Robot.hopperUltra);
    }

    NetworkTable visionTable;
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	visionTable = NetworkTable.getTable("GRIP/gearContourReport");
    	
    	
    	System.out.println("Gyro angle at: " + Robot.gyro);
    	System.out.println("Hopper Ultrasonic at(MMINT): " + Robot.hopperUltra.getDistanceMMINT());
    	//System.out.println("");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

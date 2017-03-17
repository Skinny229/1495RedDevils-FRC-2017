package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;
import org.usfirst.frc.team1495.robot.Robot.RobotDriveState;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ChangeRobotOrientation extends Command {

	
	
	int update;
	/*
	 *Gets what direction to switch drive to based on int's 0-2; 0 = Front, 1 = GearSide, 2 = Climb/Shooter Side 
	 * */
    public ChangeRobotOrientation(int lupdate) {
        update = lupdate;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	switch(update){
    	case 0: Robot.currentDriveState = RobotDriveState.HOPPERLEAD;
    		break;
    	case 1: Robot.currentDriveState = RobotDriveState.GEARLEAD;
    		break;
    	case 2: Robot.currentDriveState = RobotDriveState.CLIMBSHOOTERLEAD;
    		break;
    	default: System.out.println("NO DRIVE STATE NOT SWITCHED, WRONG INPUT CALLED");
    		break;
    	
    	}
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}

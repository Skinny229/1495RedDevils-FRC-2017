package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;
import org.usfirst.frc.team1495.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoBackNShoot extends Command {

    public GoBackNShoot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooterSub);
    }
    
    Boolean finished = false;
    
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.isRoboDriveCMDOn = true;
    	Robot.roboDrive.setSafetyEnabled(false);
    	finished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.roboDrive.mecanumDrive_Cartesian(0, -.4, 0, 0);
    	Timer.delay(2);
    	Robot.roboDrive.mecanumDrive_Cartesian(0, 0, -.25, 0);
    	Timer.delay(1);
    	finished = true;
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.roboDrive.mecanumDrive_Cartesian(0, 0, 0, 0);
    	RobotMap.isRoboDriveCMDOn = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

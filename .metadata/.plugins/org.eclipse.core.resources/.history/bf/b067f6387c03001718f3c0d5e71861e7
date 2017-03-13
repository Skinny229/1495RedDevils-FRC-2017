package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LoadServoV2 extends Command {

    public LoadServoV2() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
      	requires(Robot.loaderServoSub);
    	requires(Robot.loaderSub);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.loaderServoSub.setPosition(.5);
    	Robot.loaderSub.spin(-.55);
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
    	Robot.loaderServoSub.setPositionAngle(0);
    	Robot.loaderSub.spin(0);
    	Timer.delay(.1);
    	Robot.loaderServoSub.setPosition(0);
    }
}

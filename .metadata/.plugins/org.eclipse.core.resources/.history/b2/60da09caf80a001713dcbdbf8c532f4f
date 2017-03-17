package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;
import org.usfirst.frc.team1495.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AgitatedShooting extends Command {

    public AgitatedShooting() {
    	requires(Robot.shooterSub);
    	requires(Robot.loaderSub);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooterSub.updateSafety(false);
    	Robot.loaderSub.updateSafety(false);
    	
    	Robot.shooterSub.spin(RobotMap.shootingSpeed);
    	Timer.delay(2.5);
    	Robot.loaderSub.spin(.55);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooterSub.spin(RobotMap.shootingSpeed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooterSub.stop();
    	Robot.loaderSub.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooterSub.stop();
    	Robot.loaderSub.stop();
    }
}

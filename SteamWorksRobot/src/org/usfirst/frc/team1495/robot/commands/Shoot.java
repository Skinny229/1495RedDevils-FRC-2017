package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shoot extends Command {

	double speed;
	
    public Shoot(double s) {
    	requires(Robot.shooterSub);
    	speed = s;
    }
    
    protected void initialize() {
    	Robot.shooterSub.setSaftey(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooterSub.shoot(speed);
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
    	Robot.shooterSub.stopShooting();
    }
}

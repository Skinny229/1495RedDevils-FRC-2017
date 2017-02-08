package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterTurnOnce extends Command {

	double startAngle;
	boolean hasFinished;

	public ShooterTurnOnce() {
		System.out.println("Starting ShooterTurnOnce ....");
		requires(Robot.shooterSub);
		requires(Robot.potSub);
		requires(Robot.loadSub);
		Robot.shooterSub.setSaftey(true);
		hasFinished = false;
		startAngle = Robot.potSub.getAngle();
		System.out.println("Starting out at angle: "+ startAngle);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double getHere = startAngle - 1;
		
		while(startAngle != getHere){
			
		}
		hasFinished = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return hasFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.shooterSub.stopShooting();
		Robot.shooterSub.setSaftey(false);
		System.out.println("ShooterTurnOnce ended Sucessfully");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.shooterSub.stopShooting();
		Robot.shooterSub.setSaftey(false);
		System.out.println("WARNING: ShooterTurnOnce interrupted! Stopping Shoot Motor and setting safety to false");
	}
}


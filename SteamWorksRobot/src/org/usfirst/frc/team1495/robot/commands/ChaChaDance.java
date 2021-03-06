package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * The one and ONlY Cha Cha Dance
 */
public class ChaChaDance extends Command {

	public ChaChaDance() {
	}

	
	protected void initialize() {

		Robot.roboDrive.mecanumDrive_Cartesian(0, .2, 0, 0);
		Timer.delay(2);
		Robot.roboDrive.stopMotor();
	}

	// Called repeatedly when this Command is scheduled to run

	protected void execute() {
		Robot.roboDrive.drive(-.2, -.2);
		Timer.delay(.5);
		Robot.roboDrive.stopMotor();
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

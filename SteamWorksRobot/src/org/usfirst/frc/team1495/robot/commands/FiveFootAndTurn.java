package org.usfirst.frc.team1495.robot.commands;

import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team1495.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FiveFootAndTurn extends Command {

	public int phase = 0;
	public double startTime;

	public FiveFootAndTurn() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.gyro);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.gyro.reset();
		Robot.roboDrive.setSafetyEnabled(false);
		startTime = Timer.getFPGATimestamp();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		switch (phase) {
		case 0:
			Robot.roboDrive.mecanumDrive_Cartesian(0, .2, 0, 0);
			if (Timer.getFPGATimestamp() - startTime > 2) {
				phase = 1;
			}
			break;
		case 1:
			Robot.roboDrive.mecanumDrive_Cartesian(0, 0, .25, 0);
			if (Robot.gyro.getRawAngleDegrees() > 180f || Robot.gyro.getRawAngleDegrees() < -180f) {
				phase = 2;
			}
			break;
		}
		System.out.println(Robot.gyro.getAngleDegrees());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (phase >= 2)
			return true;
		else
			return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.roboDrive.stopMotor();
		// Robot.roboDrive.setSafetyEnabled(true);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.roboDrive.stopMotor();
		// Robot.roboDrive.setSafetyEnabled(true);
	}
}

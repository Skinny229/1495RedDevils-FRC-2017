package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;
import org.usfirst.frc.team1495.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BoilerOnLeft extends Command {

    public BoilerOnLeft() {
		requires(Robot.gyro);
		requires(Robot.loaderSub);
		requires(Robot.shooterSub);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.gyro.reset();
		Robot.roboDrive.mecanumDrive_Cartesian(0, -.2, 0, 0);
		Timer.delay(2);
		Robot.shooterSub.spin(RobotMap.shootingSpeed);
		while(Robot.gyro.getAngleDegrees() > 135) {
		Robot.roboDrive.mecanumDrive_Cartesian(0, 0, .2, 0);
		}
		Robot.roboDrive.stopMotor();
		Robot.loaderSub.spin(RobotMap.LOAD_SPEED);
		Timer.delay(7);
		Robot.shooterSub.stop();
		Robot.loaderSub.stop();
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

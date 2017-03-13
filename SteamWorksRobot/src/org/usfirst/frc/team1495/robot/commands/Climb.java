package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Climb extends Command {
	double speed;

	public Climb(double s) {

		requires(Robot.climberSub);
		speed = s;
	}

	protected void initialize() {
		//Robot.climberSub.updateSafety(true);
	}

	protected void execute() {
		Robot.climberSub.spin(speed);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
		Robot.climberSub.stop();
	}
}

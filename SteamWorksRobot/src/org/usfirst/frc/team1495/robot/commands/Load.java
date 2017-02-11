package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Load extends Command {

	double speed;

	public Load(double s) {
		requires(Robot.loaderSub);
		speed = s;
	}

	protected void initialize() {
		Robot.loaderSub.updateSafety(true);
	}

	protected void execute() {
		Robot.loaderSub.spin(speed);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
		Robot.loaderSub.stop();
	}
}

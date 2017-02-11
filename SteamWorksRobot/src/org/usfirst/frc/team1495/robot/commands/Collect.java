package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Collect extends Command {

	double speed;

	public Collect(double s) {
		requires(Robot.collectorSub);
		speed = s;
	}

	protected void initialize() {
		Robot.collectorSub.updateSafety(true);
	}

	protected void execute() {
		Robot.collectorSub.spin(speed);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
		Robot.collectorSub.stop();
	}
}

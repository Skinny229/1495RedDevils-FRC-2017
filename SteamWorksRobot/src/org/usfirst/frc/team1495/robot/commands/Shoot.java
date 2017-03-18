package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shoot extends Command {

	double speed;

	public Shoot(double s) {
		requires(Robot.shooterSub);
		speed = s;
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.shooterSub.spin(speed);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
		Robot.shooterSub.stop();
	}
}

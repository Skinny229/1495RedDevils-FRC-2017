package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MovePistonGear extends Command {

	boolean hasFinished;
	DoubleSolenoid.Value updateGear;

	public MovePistonGear(DoubleSolenoid.Value update) {
		requires(Robot.gameGearSolenoid);
		updateGear = update;
	}

	protected void initialize() {
		hasFinished = false;
	}

	protected void execute() {
		Robot.gameGearSolenoid.set(updateGear);
		hasFinished = true;
	}

	protected boolean isFinished() {
		return hasFinished;
	}

	protected void end() {
	}
	
	protected void interrupted() {
	}
}

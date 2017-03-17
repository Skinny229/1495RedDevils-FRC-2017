package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class adjustShooter extends Command {
	

	boolean speed;
	public adjustShooter(boolean s) {
		speed = s;	
	}

	protected void initialize() {
		if(speed)
			RobotMap.shootingSpeed +=  .01;
		else
			RobotMap.shootingSpeed +=-.01;
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {;
	}

	protected void interrupted() {
		
	}
	
}

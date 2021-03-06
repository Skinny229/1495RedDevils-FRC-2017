package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RightTurnGearAuto extends Command {

    public RightTurnGearAuto() {
    	requires(Robot.gyro);
    	}

    	// Called just before this Command runs the first time
    	protected void initialize() {
    		Robot.gyro.reset();
    		Robot.roboDrive.mecanumDrive_Cartesian(0, .2, 0, 0);
    		Timer.delay(4.5);
    		Robot.roboDrive.mecanumDrive_Cartesian(0, 0, .2, 0);
    		Timer.delay(1.5);
    		Robot.roboDrive.mecanumDrive_Cartesian(0, .2, 0, 0);
    		Timer.delay(2);
        	Robot.roboDrive.stopMotor();
        	Timer.delay(2.5);
        	Robot.roboDrive.mecanumDrive_Cartesian(0, -.2, 0, 0);
        	Timer.delay(2.5);
        	Robot.roboDrive.stopMotor();
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
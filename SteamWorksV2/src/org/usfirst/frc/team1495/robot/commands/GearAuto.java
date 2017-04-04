package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearAuto extends Command {

    public GearAuto() {
		requires(Robot.gyro);
		requires(Robot.gearUltra);
		requires(Robot.hopperUltra);
		requires(Robot.loaderSub);
		requires(Robot.shooterSub);
    }


    
    
    
    int onPhase;
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	onPhase = 0;
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

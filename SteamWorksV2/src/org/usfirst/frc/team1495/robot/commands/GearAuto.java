package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearAuto extends Command {

    public GearAuto() {
		requires(Robot.gyro);
		requires(Robot.hopperUltra);
		requires(Robot.loaderSub);
		requires(Robot.shooterSub);
    }


    
    
    
    int onPhase;
    boolean hasFinished;
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.roboDrive.mecanumDrive_Cartesian(0, .25, 0, 0);
    	Timer.delay(6.2);
    	Robot.roboDrive.mecanumDrive_Cartesian(0, -.2, 0, 0);
    	Timer.delay(1.5);
    	Robot.roboDrive.stopMotor();
    }

    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns trueq
    protected void end() {
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
}

package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SideGearLoaderSide extends Command {

    public SideGearLoaderSide() {
    	requires(Robot.gyro);
    	requires(Robot.hopperUltra);
    }

    
    protected void initialize() {
    }

    
    protected void execute() {
    }

    
    protected boolean isFinished() {
        return false;
    }

    
    protected void end() {
    }

    
    protected void interrupted() {
    }
}

package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SideGearLoaderSide extends Command {

    public SideGearLoaderSide() {
    	requires(Robot.gyro);
    	requires(Robot.hopperUltra);
    	requires(Robot.gearUltra);
    	requires(Robot.gearSwitch);
    }

    
    int onPhase;
    double turnSpeedPhase1 = .25;
	DriverStation.Alliance onAlliance;
	DriverStation.Alliance blue = DriverStation.Alliance.Blue;
	DriverStation.Alliance red = DriverStation.Alliance.Red;
	boolean hasFinished = false;
    
    protected void initialize() {
    	onPhase = 0;
		Robot.gyro.reset();
		onPhase = 0;
		onAlliance = DriverStation.getInstance().getAlliance();
		hasFinished = false;
		/*
		 * If on the blue alliance, all values are switched for blue alliance If
		 * the DriverStation does not send the alliance, it will auto run on RED
		 * SIDE
		 */
		if (onAlliance == blue) 
			turnSpeedPhase1 *= -1;
    }

    
    protected void execute() {
		switch (onPhase) {
		case 0:
			while (Robot.hopperUltra.getDistanceMMINT() < 2000 ) {
				Robot.roboDrive.mecanumDrive_Cartesian(0, .3, 0, Robot.gyro.getAngleDegrees());
			}
			onPhase++;
			break;
		case 1:
			while (Math.abs(Robot.gyro.getRawAngleDegrees()) < 60) {
				Robot.roboDrive.mecanumDrive_Cartesian(0, 0, turnSpeedPhase1, 0);
			}
			onPhase++;
			break;
		case 2:
			Robot.roboDrive.mecanumDrive_Cartesian(0, .2, 0, 0);
			Timer.delay(5);
			Robot.gyro.reset();
			onPhase++;
			break;
		case 3:
			Robot.roboDrive.mecanumDrive_Cartesian(0, -.3, 0, 0);
			Timer.delay(1);
			if(Robot.gearSwitch.isSwitchPressed())
				hasFinished = true;
			else
				onPhase++;
		case 4:
			while(Math.abs(Robot.gyro.getRawAngleDegrees()) > 0){
				Robot.roboDrive.mecanumDrive_Cartesian(0, 0, -turnSpeedPhase1, 0);
			}
			onPhase++;
			break;
		case 5:
			while(Robot.gearUltra.getDistanceMMINT() > 4600){
			Robot.roboDrive.mecanumDrive_Cartesian(0, .3, 0, 0);
			}
			break;
		}
    }

    
    protected boolean isFinished() {
        return hasFinished;
    }

    
    protected void end() {
    }

    
    protected void interrupted() {
    }
}

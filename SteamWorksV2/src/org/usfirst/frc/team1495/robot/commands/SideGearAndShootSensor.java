package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;
import org.usfirst.frc.team1495.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Side Autonomous for the boiler side ||| Please be advised: This will not work
 * if we're not on the boiler side.
 */
public class SideGearAndShootSensor extends Command {

	public SideGearAndShootSensor() {
		requires(Robot.gyro);
		requires(Robot.hopperUltra);
		requires(Robot.loaderSub);
		requires(Robot.shooterSub);
	}

	int onPhase;
	double turnSpeedPhase1 = .25, turnSpeedPhase3 = .3;
	boolean hasFinished;

	DriverStation.Alliance onAlliance;
	DriverStation.Alliance blue = DriverStation.Alliance.Blue;
	DriverStation.Alliance red = DriverStation.Alliance.Red;

	protected void initialize() {
		Robot.gyro.reset();
		onPhase = 0;
		onAlliance = DriverStation.getInstance().getAlliance();
		hasFinished = false;
		/*
		 * If on the blue alliance, all values are switched for blue alliance If
		 * the DriverStation does not send the alliance, it will auto run on RED
		 * SIDE
		 */
		if (onAlliance == blue) {
			turnSpeedPhase1 *= -1;
			turnSpeedPhase3 *= -1;
		}
	}

	/*
	 * Phase 0: Drive Foward Until Distance is met Phase 1: Turn 45 Degrees
	 * Phase 2: Drive into the peg and wait Phase 3: Drive out and aline the
	 * shooter Phase 4: Shoot for the remainder of the Auto period
	 */
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
			Timer.delay(4);
			Robot.gyro.reset();
			onPhase++;
			break;
		case 3:
			Robot.roboDrive.mecanumDrive_Cartesian(0, -.3, 0, 0);
			
			Timer.delay(.5);
			while (Math.abs(Robot.gyro.getRawAngleDegrees()) < 75) {
				Robot.roboDrive.mecanumDrive_Cartesian(0, 0, turnSpeedPhase3, 0);
			}
			Robot.roboDrive.stopMotor();
			onPhase++;
			break;
		case 4:
			Robot.shooterSub.spin(RobotMap.shootingSpeed);
			Timer.delay(.4);
			Robot.loaderSub.spin(RobotMap.LOAD_SPEED);
			double sleepTillHere = 15.0 - DriverStation.getInstance().getMatchTime();
			Timer.delay(sleepTillHere);
			hasFinished = true;
			onPhase++;
			break;
		default:
			System.out.println("WARNING: PHASE SELECTION FOR SIDE GEAR AND SHOOT FAILED! Stopping Autonomous...");
			hasFinished = true;
			break;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return hasFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.roboDrive.stopMotor();
		Robot.shooterSub.stop();
		Robot.loaderSub.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.roboDrive.stopMotor();
		Robot.shooterSub.stop();
		Robot.loaderSub.stop();
	}
}

package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;
import org.usfirst.frc.team1495.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class VeryExperimentalVisionAuto extends Command {

	public VeryExperimentalVisionAuto() {
		requires(Robot.gyro);
		requires(Robot.hopperUltra);
		requires(Robot.loaderSub);
		requires(Robot.shooterSub);
	}

	int onPhase;
	double turnSpeedPhase1 = .25, turnSpeedPhase3 = .3;
	boolean hasFinished;

	// Vision into peg variables
	NetworkTable visionTable;
	double midxPointWanted, midXPointArray[], midXPointDataLostDef[] = { 0.0, 0.0, 0.0 }, midXPointActual, angleToTurn,
			angleToTurnSpeed = .25;
	int targetDataLostCounter;
	boolean targetWasLost;
	double distToTarget;

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
		targetDataLostCounter = 0;
		// Get Vision Tables
		visionTable = NetworkTable.getTable("GRIP/gearContourReport");
		targetWasLost = false;
	}

	/*
	 * Phase 0: Drive Foward Until Distance is met Phase 1: Turn 45 Degrees
	 * Phase 2: Drive into the peg and wait Phase 3: Drive out and aline the
	 * shooter Phase 4: Shoot for the remainder of the Auto period
	 */
	protected void execute() {
		switch (onPhase) {
		case 0:
			
				Robot.roboDrive.mecanumDrive_Cartesian(0, .25, 0, Robot.gyro.getAngleDegrees());
				Timer.delay(3.65);
			onPhase++;
			break;
		case 1:
			while (Math.abs(Robot.gyro.getRawAngleDegrees()) < 45) {
				Robot.roboDrive.mecanumDrive_Cartesian(0, 0, turnSpeedPhase1, 0);
			}
			onPhase++;
			Robot.roboDrive.stopMotor();
			break;
		case 2:
			
			midXPointArray = visionTable.getNumberArray("centerX", midXPointDataLostDef);

			//If we have 2 Targets lets cotinue
			if (midXPointArray.length == 2) {
				System.out.println("TARGETS FOUND");
				for(int i = 0; i < 1; i ++){
					
					System.out.println("Cycle:" + (i+1));
					Robot.gyro.reset();
				//Calculate MidPoint of the targets (Where we want to go)
				try{
					midXPointActual = (midXPointArray[0] + midXPointArray[1]) / 2;
				}
				catch(Exception e){
					System.out.println("Targets lost during execution Moving on...");
					onPhase++;
					break;
				}
				//Asuming the camera is in the middle with resolution 640x480 and 60 horizontal focal view of the camera...
				//We can obtain the number of degrees using simple trig tan functions
				System.out.println("MidXPoint: " + midXPointActual);
				angleToTurn = Math.toDegrees(Math.atan((340 - midXPointActual) / Math.toDegrees((340 / Math.tan(32)))));
				System.out.println("Turning by: " + angleToTurn + " degrees!");
				
				if(midXPointActual > 320)
					angleToTurnSpeed *= -1;
				
				System.out.println("Got here");
				
				//Keeps turning until angle offset is reached according to our calculations...
				if(angleToTurn > 0){
					while (Robot.gyro.getRawAngleDegrees() > angleToTurn){
						Robot.roboDrive.mecanumDrive_Cartesian(0, 0, angleToTurnSpeed, 0);
					 }
					Robot.roboDrive.stopMotor();
				}else{
					while (Robot.gyro.getRawAngleDegrees() < angleToTurn){
						Robot.roboDrive.mecanumDrive_Cartesian(0, 0, angleToTurnSpeed, 0);
					}
					Robot.roboDrive.stopMotor();
				}
				
				
				
				}
				System.out.println("Finished. At: " + Robot.gyro.getRawAngleDegrees());
				//onPhase++;
				
				} else {
				//Runs if we have the wanted amount of targets
				System.out.println("Target data not found(either too little or too much targets)! Driving Slow for now");
				Robot.roboDrive.mecanumDrive_Cartesian(0, .2, 0, 0);
				Timer.delay(.2);
				targetDataLostCounter++;
				if (targetDataLostCounter == 20 && !DriverStation.getInstance().isOperatorControl())
					onPhase++;
					targetWasLost = true;
			}
			onPhase++;
			break;
			
		case 3:
			System.out.println("GOT HERE ???");
			Robot.gyro.reset();
			onPhase++;
			Robot.roboDrive.mecanumDrive_Cartesian(0, .3, 0, 0);
			Timer.delay(3.0);
			Robot.roboDrive.stopMotor();
			Timer.delay(1.5);
			break;
		case 4:
			Robot.roboDrive.mecanumDrive_Cartesian(0, -.3, 0, 0);
			Timer.delay(1);
			/*
			while (Math.abs(Robot.gyro.getRawAngleDegrees()) < 75) {
				Robot.roboDrive.mecanumDrive_Cartesian(0, 0, turnSpeedPhase3, 0);
			}*/
			Robot.roboDrive.stopMotor();
			onPhase+=2;
			hasFinished = true;
			break;
		case 5:
			Robot.shooterSub.spin(RobotMap.shootingSpeed);
			Timer.delay(.4);
			Robot.loaderSub.spin(RobotMap.LOAD_SPEED);
			double sleepTillHere;
			if(DriverStation.getInstance().getMatchTime() < 5 || DriverStation.getInstance().isOperatorControl()){
			hasFinished = true;
			break;
			}
			sleepTillHere = 15.0 - DriverStation.getInstance().getMatchTime();
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

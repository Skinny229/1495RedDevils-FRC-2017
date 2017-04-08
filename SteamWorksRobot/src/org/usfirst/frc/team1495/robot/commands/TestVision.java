package org.usfirst.frc.team1495.robot.commands;

import org.usfirst.frc.team1495.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class TestVision extends Command {

    public TestVision() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

	NetworkTable visionTable;
	double midxPointWanted, midXPointArray[], midXPointDataLostDef[] = { 0.0, 0.0, 0.0 }, midXPointActual, angleToTurn,
			angleToTurnSpeed = .2;
	int targetDataLostCounter;
	double distToTarget;
	boolean hasFinished;
    // Called just before this Command runs the first time
    protected void initialize() {
    	visionTable = NetworkTable.getTable("GRIP/gearContourReport");
    	hasFinished = false;
    	angleToTurnSpeed = .2;
    }

    // Called repeatedly when this Command is scheduled to run

	protected void execute() {
		Robot.roboDrive.mecanumDrive_Cartesian(0, .2, 0, 0);
		Timer.delay(1);
		
		Robot.roboDrive.stopMotor();
		//Get contourTarget info from the networktables
		midXPointArray = visionTable.getNumberArray("centerX", midXPointDataLostDef);
		//Reset Gyro for accurate turn
		Robot.gyro.reset();
		
		
		Timer.delay(.125);
		//If we have 2 Targets lets cotinue
		if (midXPointArray.length == 2) {
			
			for(int i = 0; i < 1; i ++){
				Robot.gyro.reset();
			//Calculate MidPoint of the targets (Where we want to go)
			midXPointActual = (midXPointArray[0] + midXPointArray[1]) / 2;
			
			//Asuming the camera is in the middle with resolution 640x480 and 60 horizontal focal view of the camera...
			//We can obtain the number of degrees using simple trig tan functions
			System.out.println("MidXPoint: " + midXPointActual);
			angleToTurn = Math.toDegrees(Math.atan((340 - midXPointActual) / Math.toDegrees((340 / Math.tan(32)))));
			System.out.println("Turning by: " + angleToTurn + " degrees!");
			
			if(midXPointActual > 320)
				angleToTurnSpeed *= -1;
			else
				angleToTurnSpeed *= 1;
			
			System.out.println("Got here");
			//Keeps turning until angle offset is reached according to our calculations...
			while (Robot.gyro.getRawAngleDegrees() < angleToTurn){
				Robot.roboDrive.mecanumDrive_Cartesian(0, 0, angleToTurnSpeed, 0);
			}
			
			}
			System.out.println("Finished. At: " + Robot.gyro.getRawAngleDegrees());
			hasFinished = true;
			}else{
				System.out.println("Targets not found!");
				hasFinished = true;
				}
			}
		

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return hasFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.roboDrive.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

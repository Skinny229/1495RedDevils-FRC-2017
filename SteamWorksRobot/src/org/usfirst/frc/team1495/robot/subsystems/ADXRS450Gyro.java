package org.usfirst.frc.team1495.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ADXRS450Gyro extends Subsystem {

    ADXRS450_Gyro adxrs450 = new ADXRS450_Gyro();

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void calibrate() {
    	adxrs450.calibrate();
    }
    
    public void reset() {
    	adxrs450.reset();
    }
    
    public double getAngleDegrees() {
    	return adxrs450.getAngle();
    }
}


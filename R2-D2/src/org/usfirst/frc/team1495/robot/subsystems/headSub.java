package org.usfirst.frc.team1495.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class headSub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Spark headMotor;
	public headSub(){
		headMotor = new Spark(2);
		headMotor.setSafetyEnabled(false);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void spin(double speed){
    	headMotor.set(speed);
    }
    public void stop(){
    	headMotor.stopMotor();
    }
}


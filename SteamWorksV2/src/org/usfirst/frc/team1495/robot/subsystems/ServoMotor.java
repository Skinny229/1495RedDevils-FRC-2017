package org.usfirst.frc.team1495.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Servo;

/**
 *
 */
public class ServoMotor extends Subsystem {

	Servo servo;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public ServoMotor(int pwmPort) {
		servo = new Servo(pwmPort);
	}

	public void setPosition(double pos) {
		servo.setPosition(pos);
	}
	
	public void setPositionAngle(double angle){
	    servo.setAngle(angle);	
	}
	

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}

package org.usfirst.frc.team1495.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class OSolenoid extends Subsystem {

    DoubleSolenoid sole = new DoubleSolenoid(0,0,1);
    String state;

    public OSolenoid()
    {
    	sole.set(DoubleSolenoid.Value.kOff);
    	state = "Off";
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void Off() {
    	sole.set(DoubleSolenoid.Value.kOff);
    	state = "Off";
    }
    
    public void Forward() {
    	sole.set(DoubleSolenoid.Value.kForward);
    	state = "Forward";
    }
    
    public void Reverse() {
    	sole.set(DoubleSolenoid.Value.kReverse);
    	state = "Reverse";
    }
    
    public String getState() {
    	return state;
    }
}


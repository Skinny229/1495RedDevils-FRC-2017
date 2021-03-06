package org.usfirst.frc.team1495.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LimitSwitchSub extends Subsystem {


    public void initDefaultCommand() {
      
    }
    
    
    DigitalInput limitSwitch;
    public LimitSwitchSub(int dioPort){
     limitSwitch = new DigitalInput(dioPort);	
    }
    
    public boolean isSwitchPressed(){
    	return limitSwitch.get();
    }
    
    public boolean isGearLifted(){
    	return !limitSwitch.get();
    }
}


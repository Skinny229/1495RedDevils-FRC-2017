package org.usfirst.frc.team1495.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class _AnalogInput extends Subsystem {
	
	AnalogInput ai;
	
    public void initDefaultCommand() {
    }
    
    public _AnalogInput(int port)
    {
    	ai = new AnalogInput(port);
    }
    
    public double getVoltage() {
    	return ai.getVoltage();
    }
}


package org.usfirst.frc.team1495.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class _Ultrasonic extends Subsystem {

	protected AnalogInput ai;

	public _Ultrasonic(int port) {
		ai = new AnalogInput(port);
	}

	protected void initDefaultCommand() {
	}

	public double getDistanceMMRAW() {
		// Distances less than 300mm will read as 300mm
		return  ai.getVoltage() * 997;

	}
	public int getDistanceMMINT(){
		return (int) ai.getVoltage()* 997;
	}

}

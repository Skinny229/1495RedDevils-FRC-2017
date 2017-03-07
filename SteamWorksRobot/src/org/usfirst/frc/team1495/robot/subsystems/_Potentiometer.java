package org.usfirst.frc.team1495.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

public class _Potentiometer extends Subsystem {
	Potentiometer pot;
	AnalogInput aInput;

	public void initDefaultCommand() {
	}

	public _Potentiometer(int port) {
		aInput = new AnalogInput(port);
		pot = new AnalogPotentiometer(aInput, 3600, 0);
	}

	public double getAngle() {
		return (int) pot.get();
	}

}
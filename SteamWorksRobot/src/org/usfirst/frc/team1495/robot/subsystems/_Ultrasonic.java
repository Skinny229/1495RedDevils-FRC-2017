package org.usfirst.frc.team1495.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Ultrasonic Sensor Ping channel is the output channel to the sensor Echo
 * channel is the input channel from the sensor
 */
public class _Ultrasonic extends Subsystem {

	final float tomm = 5120;
	final float zero = .28f;
	protected AnalogInput ai;

	public _Ultrasonic(int port) {
		ai = new AnalogInput(port);
		ai.setOversampleBits(4);
		ai.setAverageBits(2);
	}

	protected void initDefaultCommand() {
	}

	public double getDistanceInches() {
		return ((int) ((ai.getAverageVoltage() - zero) * 1000)) / 1000;
	}

}

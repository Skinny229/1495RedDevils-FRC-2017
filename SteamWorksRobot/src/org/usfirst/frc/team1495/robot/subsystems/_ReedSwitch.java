package org.usfirst.frc.team1495.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.command.Subsystem;

public class _ReedSwitch extends Subsystem {

	// DigitalSource dSource;
	DigitalInput ai;

	public _ReedSwitch(int digitalPort) {
		// Setting Input from 0 to 5V
		// reedSwitch.setLimitsRaw(0, 4096);
		// ai.
		// ai.readFallingTimestamp();
		// ai.setUpSourceEdge(true, false);
	}

	protected void initDefaultCommand() {
	}

	public boolean getState() {

		return ai.get();
	}

}

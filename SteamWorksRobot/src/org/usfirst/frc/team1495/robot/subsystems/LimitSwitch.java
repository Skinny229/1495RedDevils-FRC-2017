package org.usfirst.frc.team1495.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LimitSwitch extends Subsystem {

	DigitalInput limitSwitch;
	Counter counter;

	public LimitSwitch(int dioPort) {
		limitSwitch = new DigitalInput(dioPort);
		counter = new Counter(limitSwitch);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Returns true if limit swtich is pressed on
	 * */
	public boolean isSwitchOn() {
		boolean bool;
		if (counter.get() != 0)
			bool = true;
		else
			bool = false;

		return bool;
	}

	public int getValue() {
		return counter.get();
	}

	public void resetCounter() {
		counter.reset();
	}

}

package org.usfirst.frc.team1495.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class _DoubleSolenoid extends Subsystem {

	DoubleSolenoid solenoid;
	String state;

	public void initDefaultCommand() {
	}

	public _DoubleSolenoid(int PCM, int forwardChannel, int reverseChannel) {
		solenoid = new DoubleSolenoid(PCM, forwardChannel, reverseChannel);
	}

	public String getState() {
		return state;
	}

	public void set(DoubleSolenoid.Value direction) {
		solenoid.set(direction);
		switch (direction) {
		case kOff:
			state = "Off";
			break;
		case kForward:
			state = "Forward";
			break;
		case kReverse:
			state = "Reverse";
			break;
		}
	}

}

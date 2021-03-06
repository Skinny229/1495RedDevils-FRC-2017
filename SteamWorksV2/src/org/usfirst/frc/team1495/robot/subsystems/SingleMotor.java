package org.usfirst.frc.team1495.robot.subsystems;

import org.usfirst.frc.team1495.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SingleMotor extends Subsystem {

	VictorSP speedController;

	public SingleMotor(int pwmPort) {
		speedController = new VictorSP(pwmPort);
		this.updateSafety(RobotMap.STARTING_MOTOR_SAFETY);
	}

	public void initDefaultCommand() {
	}

	public void updateSafety(boolean update) {
		speedController.setSafetyEnabled(update);
	}

	public void spin(double speed) {
		speedController.set(speed);
	}

	public void stop() {
		speedController.stopMotor();
	}
}

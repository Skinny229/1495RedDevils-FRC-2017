package org.usfirst.frc.team1495.robot.subsystems;

import org.usfirst.frc.team1495.robot.RobotMap;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TalonSingleMotor extends Subsystem {

	 TalonSRX speedController;

	public TalonSingleMotor(int pwmPort) {
		speedController = new TalonSRX(pwmPort);
		speedController.setExpiration(RobotMap.MOTOR_EXPIRATION);
		updateSafety(RobotMap.STARTING_MOTOR_SAFETY);
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

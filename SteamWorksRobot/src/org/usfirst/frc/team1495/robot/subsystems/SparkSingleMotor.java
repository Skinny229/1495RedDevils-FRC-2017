package org.usfirst.frc.team1495.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SparkSingleMotor extends Subsystem {

	Spark speedController;

	public SparkSingleMotor(int pwmPort) {
		speedController = new Spark(pwmPort);
	//speedController.setExpiration(RobotMap.MOTOR_EXPIRATION);
	//updateSafety(RobotMap.STARTING_MOTOR_SAFETY);
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

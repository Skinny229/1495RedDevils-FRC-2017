package org.usfirst.frc.team1495.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static final int LEFT_FRONT = 0;
	public static final int LEFT_BACK = 1;
	public static final int RIGHT_FRONT = 2;
	public static final int RIGHT_BACK = 3;
	
	public static final int JOYSTICK_PORT = 1;
	
	// Ultrasonic sensor ports
	public static final int ULTRASONIC_CHANNEL = 0;
}

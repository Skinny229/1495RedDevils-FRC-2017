package org.usfirst.frc.team1495.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// RobotDrive
	public static final int LEFT_FRONT = 0;
	public static final int LEFT_BACK = 1;
	public static final int RIGHT_FRONT = 2;
	public static final int RIGHT_BACK = 3;
	// Inverts Motors if true
	public static final boolean isRightSideInverted = false;
	public static final boolean isLeftSideInverted = true;
	// PWM Port
	public static final int SHOOTER_SC_PORT = 4;
	public static final int LOADER_SC_PORT = 5;
	public static final int COLLECTOR_SC_PORT = 6;
	public static final int CLIMBER_SC_PORT = 7;
	// Analog Inputs
	public static final int ULTRASONIC_PORT = 0;
	public static final int POTENTIOMETER_PORT = 1;
	// Joystick Port
	public static final int JOYSTICK_PORT_DRIVER = 1;
	public static final int JOYSTICK_PORT_OPERATOR = 2;

	/* FROM HERE ON OUT... DO NOT EDIT THIS VARIABLES OR STUFF WILL GO WRONG */
	/* FROM HERE ON OUT... DO NOT EDIT THIS VARIABLES OR STUFF WILL GO WRONG */
	/* FROM HERE ON OUT... DO NOT EDIT THIS VARIABLES OR STUFF WILL GO WRONG */
	/* FROM HERE ON OUT... DO NOT EDIT THIS VARIABLES OR STUFF WILL GO WRONG */
	/* FROM HERE ON OUT... DO NOT EDIT THIS VARIABLES OR STUFF WILL GO WRONG */

	// Is true when Drive Train is being used by a command
	public static final boolean isCMDRoboDrive = false;

}

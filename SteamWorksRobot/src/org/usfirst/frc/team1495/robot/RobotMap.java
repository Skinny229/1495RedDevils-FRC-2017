package org.usfirst.frc.team1495.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// Initiating PWM ports
	// RobotDrive
	public static final int LEFT_FRONT = 0;
	public static final int LEFT_BACK = 1;
	public static final int RIGHT_FRONT = 2;
	public static final int RIGHT_BACK = 3;
	// Shooters
	public static final int SHOOTER_SC_PORT = 5;
	//Loader
	public static final int LOADER_SC_PORT = 6;
	//Collection
	public static final int COLLECTION_WHEEL = 7;
	// Inverts Motors if true
	public static final boolean isRightSideInverted = false;
	public static final boolean isLeftSideInverted = true;
	// Joystick Port
	public static final int JOYSTICK_PORT = 1;

	// Analog inputs
	public static final int ULTRASONIC_CHANNEL = 0;
	public static final int POTENTIOMETER_PORT = 1;


	/* FROM HERE ON OUT... DO NOT EDIT THIS VARIABLES OR STUFF WILL GO WRONG */
	/* FROM HERE ON OUT... DO NOT EDIT THIS VARIABLES OR STUFF WILL GO WRONG */
	/* FROM HERE ON OUT... DO NOT EDIT THIS VARIABLES OR STUFF WILL GO WRONG */
	/* FROM HERE ON OUT... DO NOT EDIT THIS VARIABLES OR STUFF WILL GO WRONG */
	/* FROM HERE ON OUT... DO NOT EDIT THIS VARIABLES OR STUFF WILL GO WRONG */

	// Is true when Drive Train is being used by a command
	public static final boolean isCMDRoboDrive = false;

}

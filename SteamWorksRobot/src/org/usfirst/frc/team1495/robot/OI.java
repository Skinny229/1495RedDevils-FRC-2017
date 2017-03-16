package org.usfirst.frc.team1495.robot;

import org.usfirst.frc.team1495.robot.commands.ChangeDriver;
import org.usfirst.frc.team1495.robot.commands.ChangeRobotOrientation;
import org.usfirst.frc.team1495.robot.commands.Climb;
import org.usfirst.frc.team1495.robot.commands.LoadServoV2;
import org.usfirst.frc.team1495.robot.commands.Shoot;
import org.usfirst.frc.team1495.robot.commands.adjustShooter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
    //

	Joystick stick = new Joystick(RobotMap.JOYSTICK_PORT_DRIVER);
	Joystick operatorStick = new Joystick(RobotMap.CONTROLLER_PORT_OPERATOR);
	//Operator
	


	//Driver
	Button shoot = new JoystickButton(stick,1);
	Button agitator = new JoystickButton(stick,2);
	Button posAdjust = new JoystickButton(stick, 5);
	Button negAdjust = new JoystickButton(stick, 3);
	Button resetSpeed = new JoystickButton(stick, 6);
	
	Button switchDriver = new JoystickButton(stick,12);
	Button orientationSwitch = new JoystickButton(stick, 11);
	Button orientationSwitchOther = new JoystickButton(stick, 10);
	Button orientationReset = new JoystickButton(stick, 9);
	
	
	
	
	Button slowClimb = new JoystickButton(operatorStick, 7);
	Button climb = new JoystickButton(operatorStick,8);
	Button switchDriver1 = new JoystickButton(operatorStick,12);
	Button orientationSwitch1 = new JoystickButton(operatorStick,11);
	Button orientationSwitchOther1 = new JoystickButton(operatorStick,10);
	Button orientationReset1 = new JoystickButton(operatorStick,9);
	public OI() {
		//Driver Buttons
         shoot.whileHeld(new Shoot(-.81));
         slowClimb.whileHeld(new Climb(RobotMap.SLOW_CLIMB_SPEED));
         posAdjust.whenPressed(new adjustShooter(true));
         negAdjust.whenPressed(new adjustShooter(false));
         agitator.whileHeld(new LoadServoV2());
         climb.whileHeld(new Climb(RobotMap.CLIMB_SPEED));
         
         
         orientationSwitchOther1.whenPressed(new ChangeRobotOrientation(2));
         orientationSwitchOther.whenPressed(new ChangeRobotOrientation(2));
         orientationSwitch.whenPressed(new ChangeRobotOrientation(1));
         orientationSwitch1.whenPressed(new ChangeRobotOrientation(1));
         orientationReset.whenPressed(new ChangeRobotOrientation(0));
         orientationReset1.whenPressed(new ChangeRobotOrientation(0));
         switchDriver.whenPressed(new ChangeDriver());
         switchDriver1.whenPressed(new ChangeDriver());
	}
}

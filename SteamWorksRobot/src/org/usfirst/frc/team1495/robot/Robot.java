
package org.usfirst.frc.team1495.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1495.robot.commands.DoNothing;
import org.usfirst.frc.team1495.robot.commands.GearAuto;
import org.usfirst.frc.team1495.robot.commands.TestVision;
import org.usfirst.frc.team1495.robot.commands.VeryExperimentalVisionAuto;
import org.usfirst.frc.team1495.robot.commands.VisionPegBlueBoiler;
import org.usfirst.frc.team1495.robot.subsystems.ADXRS450Gyro;
import org.usfirst.frc.team1495.robot.subsystems.LimitSwitchSub;
import org.usfirst.frc.team1495.robot.subsystems.TalonSingleMotor;
import org.usfirst.frc.team1495.robot.subsystems._Ultrasonic;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public enum RobotDriveState {
		GEARLEAD/* Back */, HOPPERLEAD/* Front */, CLIMBSHOOTERLEAD/* Side */
	}

	// Initiating Subsystems
	public static final _Ultrasonic hopperUltra = new _Ultrasonic(RobotMap.ULTRASONIC_HOPPER_PORT);
	public static final LimitSwitchSub gearSwitch = new LimitSwitchSub(RobotMap.LIMITSWITCH_GEAR_PORT);
	public static final ADXRS450Gyro gyro = new ADXRS450Gyro();
	public static final TalonSingleMotor shooterSub = new TalonSingleMotor(RobotMap.SHOOTER_SC_PORT);
	public static final TalonSingleMotor climberSub = new TalonSingleMotor(RobotMap.CLIMBER_SC_PORT);
	public static final TalonSingleMotor loaderSub = new TalonSingleMotor(RobotMap.AGITATOR_SC_PORT);

	// Declaring OI containing buttons with command conditions

	public OI oi;
	
	//
	
	public DashboardPref switchValues;

	// Initiating RobotDrive with VictorSp's as the speed controllers
	public static RobotDrive roboDrive = new RobotDrive(
			new VictorSP(RobotMap.LEFT_FRONT),  // 0
			new VictorSP(RobotMap.LEFT_BACK),   // 1
			new VictorSP(RobotMap.RIGHT_FRONT), // 2
			new VictorSP(RobotMap.RIGHT_BACK)); // 3

	// Initating the JoySticks
	public Joystick stick = new Joystick(RobotMap.JOYSTICK_PORT_DRIVER);
	public Joystick operatorStick = new Joystick(RobotMap.CONTROLLER_PORT_OPERATOR);
	public static boolean onMainDriver = true;

	// Creating Auto Chooser
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	// Enum for Robot Drive Orientation (Value to start on)
	public static RobotDriveState currentDriveState = RobotDriveState.HOPPERLEAD;
	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		// init Button Stuff
		oi = new OI();
		//switchValues = new DashboardPref();
		// Setting inverted Motors
		roboDrive.setInvertedMotor(MotorType.kFrontLeft, RobotMap.isLeftSideInverted);
		roboDrive.setInvertedMotor(MotorType.kRearLeft, RobotMap.isLeftSideInverted);
		roboDrive.setInvertedMotor(MotorType.kFrontRight, RobotMap.isRightSideInverted);
		roboDrive.setInvertedMotor(MotorType.kRearRight, RobotMap.isRightSideInverted);
		// Disabling Safety **Prevents output not updated enough error, FTA confirmed this is OK to disable**
		roboDrive.setSafetyEnabled(RobotMap.STARTING_MOTOR_SAFETY);

		// Adding Autonomous to Chooser
		chooser.addDefault("MiddleGear (Default) OFFSET 5in LEFT", new GearAuto());
		chooser.addObject("Do Nothing", new DoNothing());
		chooser.addObject("Turn Left Auto", new VeryExperimentalVisionAuto());
		chooser.addObject("Turn Right Auto", new VisionPegBlueBoiler());
		
		// Adding  Auto Options to SmartDashboard
		SmartDashboard.putData("Autonomous mode", chooser);
		// Ensure all data boxes are sent and created before starting match(just
		// in case)
		SmartDashboard.putNumber("GyroAngle", gyro.getAngleDegrees());
		SmartDashboard.putData(" ", gyro.getSendable());
		SmartDashboard.putNumber("Hopper Ultrasonic", hopperUltra.getDistanceMMRAW());
		SmartDashboard.putString("On Driver", "Main Driver");
		SmartDashboard.putData("Vision Get", new TestVision());
		
		//Calibrating Gyro
		gyro.calibrate();

	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		/*
		Command testVision;
		testVision = new TestVision();
		testVision.start();
		*/

	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		if (isEnabled() && isOperatorControl() && onMainDriver) {
			driveOnStick(stick);
		} else if (isEnabled() && isOperatorControl() && !onMainDriver) {
		  driveOnStick(operatorStick);
		}

		SmartDashboard.putNumber("GyroAngle: ", gyro.getAngleDegrees());
		SmartDashboard.putData(" ", gyro.getSendable());
		SmartDashboard.putNumber("Hopper Ultrasonic", hopperUltra.getDistanceMMRAW());
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	public void driveOnStick(Joystick onStick){
		/*
		 * Switchcase Determines which orientation to implement
		 * */
		switch (currentDriveState) {
		case HOPPERLEAD:
			roboDrive.mecanumDrive_Cartesian(onStick.getX(), onStick.getY() * RobotMap.YMULTIPLIER,
					RobotMap.TWISTMULTIPLIER * onStick.getTwist(), 0);
			break;
		case GEARLEAD:
			roboDrive.mecanumDrive_Cartesian(-onStick.getX(), -onStick.getY() * RobotMap.YMULTIPLIER,
					onStick.getTwist() * RobotMap.TWISTMULTIPLIER, 0);
			break;
		case CLIMBSHOOTERLEAD:
			roboDrive.mecanumDrive_Cartesian(-onStick.getY(), onStick.getX() * RobotMap.YMULTIPLIER,
					onStick.getTwist() * RobotMap.TWISTMULTIPLIER, 0);
			break;
		default:
			/*Usual Front*/
			roboDrive.mecanumDrive_Cartesian(onStick.getX(), onStick.getY() * RobotMap.YMULTIPLIER,
					onStick.getTwist() * RobotMap.TWISTMULTIPLIER, 0);
			break;

		}
	}
}

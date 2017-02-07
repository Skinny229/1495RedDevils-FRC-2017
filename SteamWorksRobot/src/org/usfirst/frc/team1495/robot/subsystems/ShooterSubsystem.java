package org.usfirst.frc.team1495.robot.subsystems;

import org.usfirst.frc.team1495.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {

	VictorSP shooter = new VictorSP(RobotMap.SHOOTER_SC_PORT);
	Potentiometer pot = new AnalogPotentiometer(RobotMap.POTENTIOMETER_PORT,360,30);

	public ShooterSubsystem(){
		shooter.setSafetyEnabled(false);
	}

	public void setSaftey(boolean update){
		shooter.setSafetyEnabled(update);
	}

	public void shoot(double speed){
		shooter.set(speed);
	}
	
	public void stopShooting(){
		shooter.stopMotor();
	}
	
	public void getDi(){
		
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}

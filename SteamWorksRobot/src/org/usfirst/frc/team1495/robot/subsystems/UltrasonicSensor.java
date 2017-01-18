package org.usfirst.frc.team1495.robot.subsystems;

import org.usfirst.frc.team1495.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**Ultrasonic Sensor
 *Ping channel is the output channel to the sensor
 *Echo channel is the input channel from the sensor
 */
public class UltrasonicSensor extends Subsystem {

	protected AnalogInput ai;
	double sensitivity;
	
	public UltrasonicSensor (double s) {
		ai = new AnalogInput(RobotMap.ULTRASONIC_CHANNEL);
		sensitivity = s;
	}
	
	public double getDistanceInches()
	{
		return ai.getVoltage() * sensitivity;
	}
	
	public double getSensitivity() {
		return sensitivity;
	}
	
	public void setSensitivity(double s) {
		sensitivity = s;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}


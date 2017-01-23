package org.usfirst.frc.team1495.robot.subsystems;

import org.usfirst.frc.team1495.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**Ultrasonic Sensor
 *Ping channel is the output channel to the sensor
 *Echo channel is the input channel from the sensor
 */
public class UltrasonicSensor extends Subsystem {

	final float baseToInches = 0;
	final float toInches = 1;
	protected AnalogInput ai;
	
	public UltrasonicSensor () {
		ai = new AnalogInput(RobotMap.ULTRASONIC_CHANNEL);
	}
	
	public double getDistance()
	{
		return (ai.getVoltage() - baseToInches) * toInches;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}


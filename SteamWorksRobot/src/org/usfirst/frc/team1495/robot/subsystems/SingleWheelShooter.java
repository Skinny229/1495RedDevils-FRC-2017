package org.usfirst.frc.team1495.robot.subsystems;

import org.usfirst.frc.team1495.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SingleWheelShooter extends Subsystem {

	VictorSP wheel = new VictorSP(RobotMap.SHOOTER_WHEEL);

	public SingleWheelShooter()
	{
		wheel.setSafetyEnabled(true);
	}

	@Override
    protected void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
   public void spinPositive() {
    	wheel.set(.7);
    }
    
    public void spinNegative() {
    	wheel.set(-.7);
    }
    
    public void stopSpin() {
    	wheel.set(0);
    }
}


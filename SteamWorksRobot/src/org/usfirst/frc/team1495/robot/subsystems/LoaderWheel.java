package org.usfirst.frc.team1495.robot.subsystems;

import org.usfirst.frc.team1495.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LoaderWheel extends Subsystem {

    VictorSP loaderWheel = new VictorSP(RobotMap.LOADER_SC_PORT);

    public void initDefaultCommand() {
    	
    }
    
    public void updateSafety(boolean update){
    	loaderWheel.setSafetyEnabled(update);
    }
    public void moveWheel(double speed){
    	loaderWheel.set(speed);
    }
    public void stopWheel(){
    	loaderWheel.stopMotor();
    }
}


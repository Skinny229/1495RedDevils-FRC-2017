package org.usfirst.frc.team1495.robot;

import edu.wpi.first.wpilibj.Preferences;

public class DashboardPref {

	Preferences pref;
	
	public DashboardPref(){
		pref.putInt("SideGearDist", 2896);
		pref.putDouble("AutoShootSpeed", .75);
		
	}
	
	
	public void updateAllValues(){
		RobotMap.autoShootingSpeed = pref.getDouble("AutoShootSpeed", .75);
		RobotMap.sideGearPegDist = pref.getInt("SideGearDist", 2896);
	}
}

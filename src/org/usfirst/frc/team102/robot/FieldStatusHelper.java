package org.usfirst.frc.team102.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class FieldStatusHelper {
	
	public static String getFieldOrientationString() {
		return DriverStation.getInstance().getGameSpecificMessage();
	}
	
	public static char getSwitchSide() {
		return getFieldOrientationString().charAt(0);
	}
	
	public static char getScaleSide() {
		return getFieldOrientationString().charAt(1);
	}
	
	public static boolean getSwitchIsRightSide() {
		return getSwitchSide() == 'R';
	}
	
	public static boolean getScaleIsRightSide() {
		return getScaleSide() == 'R';
	}
	
	public static boolean doesSwitchMatch(boolean isRight) {
		return getSwitchIsRightSide() == isRight;
	}
	
	public static boolean doesScaleMatch(boolean isRight) {
		return getScaleIsRightSide() == isRight;
	}
}
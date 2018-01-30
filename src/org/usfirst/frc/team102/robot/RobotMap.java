package org.usfirst.frc.team102.robot;

public class RobotMap {
	public static final boolean IS_TEST_BED = false;
	
	public static final int JOYSTICK_ID_DRIVER = 0;
	public static final int JOYSTICK_ID_OPERATOR = 1;
	
	public static final int CAN_ID_DRIVE_TRAIN_FRONT_LEFT;
	public static final int CAN_ID_DRIVE_TRAIN_FRONT_RIGHT;
	public static final int CAN_ID_DRIVE_TRAIN_BACK_LEFT;
	public static final int CAN_ID_DRIVE_TRAIN_BACK_RIGHT;
	public static final int CAN_ID_LIFT;
	
	public static final int SOLENOID_ID_GRAB_ARMS = 0;
	public static final int SOLENOID_ID_PLATFORM = 1;
	
	public static final double JOYSTICK_DEADBAND = .2;
	
	public static final double LIFT_SPEED = 1;
	
	// 6 ft., in inches, the maximum extension of our lift
	public static final double LIFT_MAX_HEIGHT = 6 * 12;
	// 10ft, in inches, away from the wall, being the distance of the auto line from the alliance station wall,
	// plus one foot so as to not be ambiguous
	public static final double AUTO_MODE_CROSS_BASELINE_DISTANCE = (10 + 1) * 12;
	// 8ft., in inches, away from the end of the auto-baseline-crossing, being the distance from that two the far end of the switch,
	// plus one foot of extra "wiggle room"
	public static final double AUTO_MODE_SWITCH_SIDES_FOREWARD_DISTANCE = (3 + 4 + 1) * 12;
	// Do a right angle turn so that the robot may move on the other axis
	public static final double AUTO_MODE_SWITCH_SIDES_TURN_ANGLE = 90;
	// 14 ft, in inches, the width of the switch, plus one foot on each side
	public static final double AUTO_MODE_SWITCH_SIDES_DISTANCE = 14 * 12;
	// Do a 180 to reverse direction
	public static final double AUTO_MODE_REVERSE_ANGLE = 180;
	
	static {
		if(IS_TEST_BED) {
			CAN_ID_DRIVE_TRAIN_FRONT_LEFT = 2;
			CAN_ID_DRIVE_TRAIN_FRONT_RIGHT = 3;
			CAN_ID_DRIVE_TRAIN_BACK_LEFT = 0;
			CAN_ID_DRIVE_TRAIN_BACK_RIGHT = 5;
			
			CAN_ID_LIFT = 1;
		} else {
			CAN_ID_DRIVE_TRAIN_FRONT_LEFT = 1;
			CAN_ID_DRIVE_TRAIN_FRONT_RIGHT = 3;
			CAN_ID_DRIVE_TRAIN_BACK_LEFT = 2;
			CAN_ID_DRIVE_TRAIN_BACK_RIGHT = 4;
			
			CAN_ID_LIFT = 5;
		}
	}
}
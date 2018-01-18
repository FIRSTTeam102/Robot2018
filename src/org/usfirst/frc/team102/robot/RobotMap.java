package org.usfirst.frc.team102.robot;

public class RobotMap {
	public static final boolean IS_TEST_BED = false;
	
	public static final int JOYSTICK_ID_DRIVER = 0;
	public static final int JOYSTICK_ID_OPERATOR = 1;
	
	public static final int CAN_ID_DRIVE_TRAIN_FRONT_LEFT;
	public static final int CAN_ID_DRIVE_TRAIN_FRONT_RIGHT;
	public static final int CAN_ID_DRIVE_TRAIN_BACK_LEFT;
	public static final int CAN_ID_DRIVE_TRAIN_BACK_RIGHT;
	
	public static final int SOLENOID_ID_GRAB_ARMS = 0;
	
	public static final double JOYSTICK_DEADBAND = .2;
	
	static {
		if(IS_TEST_BED) {
			CAN_ID_DRIVE_TRAIN_FRONT_LEFT = 2;
			CAN_ID_DRIVE_TRAIN_FRONT_RIGHT = 3;
			CAN_ID_DRIVE_TRAIN_BACK_LEFT = 0;
			CAN_ID_DRIVE_TRAIN_BACK_RIGHT = 5;
		} else {
			CAN_ID_DRIVE_TRAIN_FRONT_LEFT = 1;
			CAN_ID_DRIVE_TRAIN_FRONT_RIGHT = 3;
			CAN_ID_DRIVE_TRAIN_BACK_LEFT = 2;
			CAN_ID_DRIVE_TRAIN_BACK_RIGHT = 4;
		}
	}
}
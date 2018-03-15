/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team102.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//Joystick Indexes
	public static int driverJoystickIndex = 0;
	public static int operatorJoystickIndex = 1;
	
	//Joystick Axis Indexes
	public static final int xBoxLeftXAxis = 0;
	public static final int xBoxLeftYAxis = 1;
	public static final int xBoxRightXAxis = 4;
	public static final int xBoxRightYAxis = 5;
	
	
	//Motor Indexes
	public static final int m1 = 1;
	public static final int m2 = 2;
	public static final int m3 = 3;
	public static final int m4 = 4;
	public static final int m5 = 5;
	
	//Joystick Button Indexes
	public static final int xBoxAIndex = 1;
	public static final int xBoxBIndex = 2;
	public static final int xBoxXIndex = 3;
	public static final int xBoxYIndex = 4;
	public static final int xBoxLeftBumperIndex = 5;
	public static final int xBoxRightBumperIndex = 6;
	public static final int xBoxBackButtonIndex = 7;
	public static final int xBoxStartButtonIndex = 8;
	public static final int xBoxLeftJoystickPress = 9;
	public static final int xBoxRightJoystickPress = 10;
	
	//Joystick Trigger Axis Indexes
	public static final int xBoxLeftTriggerAxis = 2;
	public static final int xBoxRightTriggerAxis = 3;
	
	//Solenoids
	public static final int solenoid1Index = 0;
	public static final int solenoid2Index = 1;
	
	//Compressor
	public static final int compressorIndex = 0;
	
	//switchesforelevator
	public static final int topSwitch = 3; 
	public static final int bottomSwitch = 0;
	public static final int topSlowSwitch = 2; 
	public static final int bottomSlowSwitch = 1; 
	
	//elevatorDown
	
	public static boolean isTestBed = false;
	public static boolean hasLights = !isTestBed;
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}

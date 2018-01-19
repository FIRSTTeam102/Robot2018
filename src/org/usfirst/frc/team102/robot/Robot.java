package org.usfirst.frc.team102.robot;

import org.usfirst.frc.team102.robot.subsystems.*;

import micobyte.frc.lib.robot.SelectableAutoRobot;

public class Robot extends SelectableAutoRobot {
	public static SubsystemDriveTrain driveTrain;
	public static SubsystemClimber climber;
	public static SubsystemCubeControl cubeControl;
	public static SubsystemLift lift;
	public static SubsystemCameras cams;
	
	public static OI oi;
	
	public Robot() { super("Robot 2018 (no name decided yet)"); }
	
	protected void createOIAndSubsystems() {
		oi = new OI();
		
		driveTrain = new SubsystemDriveTrain();
		climber = new SubsystemClimber();
		cubeControl = new SubsystemCubeControl();
		lift = new SubsystemLift();
		cams = new SubsystemCameras();
		
		oi.assignCommands();
	}

	protected void addAutoModes() {
		// Only attempt to cross the auto line
		addAutoMode("Just cross", null);
		
		// Cross auto line and score in the switch, if it's on the same side as us
		addAutoMode("L - cross and score", null);
		addAutoMode("R - cross and score", null);
		
		// Cross auto line and attempt to score in the switch, regardless of which side it is on, relative to us
		addAutoMode("L - cross, score always", null);
		addAutoMode("R - cross, score always", null);
	}
}
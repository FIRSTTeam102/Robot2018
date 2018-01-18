package org.usfirst.frc.team102.robot;

import org.usfirst.frc.team102.robot.subsystems.*;

import micobyte.frc.lib.robot.CommandBasedRobot;

public class Robot extends CommandBasedRobot {
	public static SubsystemDriveTrain driveTrain;
	public static SubsystemClimber climber;
	public static SubsystemCubeControl cubeControl;
	public static SubsystemLift lift;
	public static SubsystemCameras cams;
	
	public static OI oi;
	
	protected void createOIAndSubsystems() {
		oi = new OI();
		
		driveTrain = new SubsystemDriveTrain();
		climber = new SubsystemClimber();
		cubeControl = new SubsystemCubeControl();
		lift = new SubsystemLift();
		cams = new SubsystemCameras();
		
		oi.assignCommands();
	}
}
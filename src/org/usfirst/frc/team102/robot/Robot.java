/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team102.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team102.robot.commands.Autonomous;
import org.usfirst.frc.team102.robot.commands.CrossAutoLine;
import org.usfirst.frc.team102.robot.commands.DriveStraight;
import org.usfirst.frc.team102.robot.commands.ScoreNoScale;
import org.usfirst.frc.team102.robot.commands.score;
import org.usfirst.frc.team102.robot.subsystems.Arm;
import org.usfirst.frc.team102.robot.subsystems.DriveTrain;
import org.usfirst.frc.team102.robot.subsystems.Elevator;
import org.usfirst.frc.team102.robot.subsystems.Lights;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */

public class Robot extends TimedRobot {

	public static DriveTrain robotDriveTrain;
	public static Elevator robotElevator;
	public static Arm robotArm;
	public static Lights robotLights;
	public static OI oi;
	DriverStation driverStation;
	
	Command autonomous;
	int botPos = 0;
	char switchPos;
	
	SendableChooser<Command> chooser = new SendableChooser<>();
	SendableChooser<Integer> robotPosition = new SendableChooser<Integer>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		try {
			robotDriveTrain = new DriveTrain();
			robotElevator = new Elevator();
			robotArm = new Arm();
			if(RobotMap.hasLights) robotLights = new Lights();

			autonomous = new CrossAutoLine(1,false);
			autonomous = new DriveStraight(1, 10);
			
			oi = new OI();
		} catch (Exception ex1) {
			ex1.printStackTrace();
			DriverStation.reportError(ex1.getMessage(), true);
			
		}
		
		//gets info to pass into autonomous
		
		String driverStationMessage = DriverStation.getInstance().getGameSpecificMessage();
    	char switchPos = driverStationMessage.charAt(0);
    	
		
		//controls elevator lights
		if(robotLights != null) robotLights.onDisabled();
		
		//to choose auto mode
		chooser.addDefault("Score No Scale", new ScoreNoScale(botPos,switchPos));
		chooser.addObject("Score", new score(botPos, switchPos));
		chooser.addObject("Cross Line", new CrossAutoLine(botPos, false));
		SmartDashboard.putData("Auto Selector", chooser);
		
		//to choose botpos
		robotPosition.addDefault("Left", 1 );
		robotPosition.addObject("Center", 2);
		robotPosition.addObject("Right", 3);
		SmartDashboard.putData(robotPosition);
	
		
		SmartDashboard.updateValues();
		
		
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		if(robotLights != null) robotLights.onDisabled();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		
		if(robotLights != null) robotLights.onAutoStarted();
		robotArm.reset();
		botPos = robotPosition.getSelected();
		//autonomous = chooser.getSelected();
		autonomous = new Autonomous();
		//schedule the autonomous command (example)
		if (autonomous != null){
			autonomous.start();
		}
		
		}

		
	/* String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 

	/*
	 * This function is called periodically during autonomous.
	 */

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if(robotLights != null) robotLights.onTeleopStarted();
		robotArm.reset();
		autonomous.cancel();
		
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomous != null) {
			autonomous.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}

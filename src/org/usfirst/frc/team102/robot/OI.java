/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team102.robot;

import org.usfirst.frc.team102.robot.commands.UpDownArm;
import org.usfirst.frc.team102.robot.commands.ArmSqueeze;
import org.usfirst.frc.team102.robot.commands.ElevatorDown;
import org.usfirst.frc.team102.robot.commands.MoveElevatorWithBumper;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
@SuppressWarnings("unused")
public class OI {
	
	//Joysticks
	private Joystick xBoxDriver;
	private Joystick xBoxOperator;
	
	//Joystick Buttons
	private JoystickButton xBoxA; 
	private JoystickButton xBoxY; 
	private JoystickButton xBoxB; 
	private JoystickButton xBoxX; 
	
	private JoystickButton xBoxLeftBumper;
	private JoystickButton xBoxRightBumper;
	
	private JoystickButton xboxStartButton;
	
	
	public OI(){
		
		//Initialize Joysticks
		xBoxDriver = new Joystick(RobotMap.driverJoystickIndex);
		xBoxOperator = new Joystick(RobotMap.operatorJoystickIndex);
		
		//Initialize Joystick Buttons
		xBoxA = new JoystickButton(xBoxDriver, RobotMap.xBoxAIndex);
		
		
		xBoxB = new JoystickButton(xBoxDriver, RobotMap.xBoxBIndex);
		xBoxB.whenPressed(new ArmSqueeze());
		
		xBoxY = new JoystickButton(xBoxDriver, RobotMap.xBoxYIndex);
		xBoxY.whenPressed(new UpDownArm());
		
		xBoxX = new JoystickButton(xBoxDriver, RobotMap.xBoxXIndex);
		
		
		
		//elevator
		xBoxRightBumper = new JoystickButton(xBoxDriver, RobotMap.xBoxLeftBumperIndex);
//		xBoxRightBumper.whenPressed(new MoveElevatorWithBumper(0.5));
//		xBoxRightBumper.whenReleased(new MoveElevatorWithBumper(0.0));
		
		xBoxLeftBumper = new JoystickButton(xBoxDriver, RobotMap.xBoxRightBumperIndex);
//		xBoxLeftBumper.whenPressed(new MoveElevatorWithBumper(-0.5));
//		xBoxLeftBumper.whenReleased(new MoveElevatorWithBumper(0.0));
		
		//elevator with axis
	xboxStartButton = new JoystickButton(xBoxDriver, RobotMap.xBoxStartButtonIndex);
		
	xboxStartButton.whenPressed(new ElevatorDown());
		
	}
	
	//Method to get Driver Joystick
	public Joystick getDriverJoystick() {
		
		//returns driver Joystick
		return xBoxDriver;
		
	}
	
	//Mehtod to get Operator Joystick
	public Joystick getOperatorJoystick(){
		
		//return operator Joystick
		return xBoxOperator;
		
	}

	
	public boolean getLeftBumper() {
		return xBoxLeftBumper.get();
	}
	
	public boolean getRightBumper() {
		return xBoxRightBumper.get();
	}
}

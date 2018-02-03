/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team102.robot;

import org.usfirst.frc.team102.robot.commands.UpDownArm;
import org.usfirst.frc.team102.robot.commands.ArmSqueeze;
import org.usfirst.frc.team102.robot.commands.MoveArm;
import org.usfirst.frc.team102.robot.commands.MoveElevator;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
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
		
		
		xBoxLeftBumper = new JoystickButton(xBoxDriver, RobotMap.xBoxLeftBumperIndex);
		xBoxLeftBumper.whenPressed(new MoveElevator(0.5));
		xBoxLeftBumper.whenReleased(new MoveElevator(0.0));
		
		xBoxRightBumper = new JoystickButton(xBoxDriver, RobotMap.xBoxRightBumperIndex);
		xBoxRightBumper.whenPressed(new MoveElevator(-0.5));
		xBoxRightBumper.whenReleased(new MoveElevator(0.0)); 
		
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
	
}

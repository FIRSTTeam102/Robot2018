package org.usfirst.frc.team102.robot;

import org.usfirst.frc.team102.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import micobyte.frc.lib.CommonIDs;
import micobyte.frc.lib.io.RumbleSeries;

public class OI {
	public Joystick driverJoystick;
	public Joystick opJoystick;
	
	public RumbleSeries liftBottomedRumble;
	public RumbleSeries liftToppedRumble;
	
	public OI() {
		driverJoystick = new Joystick(RobotMap.JOYSTICK_ID_DRIVER);
		opJoystick = new Joystick(RobotMap.JOYSTICK_ID_OPERATOR);
		
		liftBottomedRumble = new RumbleSeries().addRough(.5F);
		liftToppedRumble = new RumbleSeries().addSoft(.5F);
	}
	
	public void assignCommands() {
		JoystickButton opA = new JoystickButton(opJoystick, CommonIDs.Gamepad.BTN_A);
		opA.whenPressed(new CommandGroupGetCube());
		
		JoystickButton opStart = new JoystickButton(opJoystick, CommonIDs.Gamepad.BTN_START);
		opStart.whenPressed(new CommandGroupResetCCAndLift());
	}
}
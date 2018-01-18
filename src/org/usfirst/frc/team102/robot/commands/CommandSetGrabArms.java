package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class CommandSetGrabArms extends InstantCommand {
	protected boolean out;
	
	public CommandSetGrabArms(boolean out) {
		super("Set grab arms: " + out);
		requires(Robot.cubeControl);
		
		this.out = out;
	}
	
	public void initialize() {
		Robot.cubeControl.setGrabArms(out);
	}
}
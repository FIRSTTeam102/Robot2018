package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class CommandSetPlatform extends InstantCommand {
	protected boolean out;
	
	public CommandSetPlatform(boolean out) {
		super("Set platform: " + out);
		requires(Robot.cubeControl);
		
		this.out = out;
	}
	
	public void initialize() {
		Robot.cubeControl.flipTo(out);
	}
}
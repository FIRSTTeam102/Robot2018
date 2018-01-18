package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class CommandSetCamera extends InstantCommand {
	protected int cam;
	
	public CommandSetCamera(int cam) {
		super("Set camera: " + cam);
		requires(Robot.cams);
		
		this.cam = cam;
	}
	
	public void initialize() {
		Robot.cams.switchTo(cam);
	}
}
package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class CommandResetCubeController extends InstantCommand {
	
	public CommandResetCubeController() {
		super("Reset Cube Controller");
		requires(Robot.cubeControl);
	}
	
	public void initialize() {
		Robot.cubeControl.reset();
	}
}
package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class CommandResetLift extends InstantCommand {
	
	public CommandResetLift() {
		super("Reset Lift");
		requires(Robot.lift);
	}
	
	public void initialize() {
		Robot.lift.reset();
	}
}
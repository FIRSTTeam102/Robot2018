package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class CommandSetClimber extends InstantCommand {
	protected boolean extended;
	
	public CommandSetClimber(boolean extended) {
		super("Set climber: " + extended);
		requires(Robot.climber);
		
		this.extended = extended;
	}
	
	public void initialize() {
		Robot.climber.setClimber(extended);
	}
}
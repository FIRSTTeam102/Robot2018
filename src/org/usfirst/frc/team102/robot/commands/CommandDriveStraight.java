package org.usfirst.frc.team102.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

//TODO implement
public class CommandDriveStraight extends Command {
	protected double distance;
	
	public CommandDriveStraight(double distance) {
		this.distance = distance;
	}
	
	protected boolean isFinished() {
		return true;
	}
}
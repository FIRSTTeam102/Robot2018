package org.usfirst.frc.team102.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

//TODO implement
public class CommandTurn extends Command {
	protected double angle;
	
	public CommandTurn(double angle) {
		this.angle = angle;
	}
	
	protected boolean isFinished() {
		return true;
	}
}
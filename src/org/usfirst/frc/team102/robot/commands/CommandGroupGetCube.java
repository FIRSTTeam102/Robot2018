package org.usfirst.frc.team102.robot.commands;

import micobyte.frc.lib.command.SimpleCommandGroup;

public class CommandGroupGetCube extends SimpleCommandGroup {
	
	public CommandGroupGetCube() {
		super("Get a cube");
		
		addSequential(new CommandSetPlatform(true));
		addSequential(new CommandSetGrabArms(false));
		addWait(1);
		addSequential(new CommandSetGrabArms(true));
		addSequential(new CommandSetPlatform(false));
	}
}
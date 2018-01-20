package org.usfirst.frc.team102.robot.commands.automode;

import micobyte.frc.lib.command.SimpleCommandGroup;

public class CommandGroupAutoSwitchSides extends SimpleCommandGroup {
	
	public CommandGroupAutoSwitchSides(boolean isRight) {
		super("Auto: Switch sides");
		
		addPrint(() -> "This does nothing... yet");
	}
}

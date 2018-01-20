package org.usfirst.frc.team102.robot.commands.automode;

import micobyte.frc.lib.command.SimpleCommandGroup;

public class CommandGroupAutoCrossBaseline extends SimpleCommandGroup {
	
	public CommandGroupAutoCrossBaseline() {
		super("Auto: Cross baseline");
		
		addPrint(() -> "This does nothing... yet");
	}
}
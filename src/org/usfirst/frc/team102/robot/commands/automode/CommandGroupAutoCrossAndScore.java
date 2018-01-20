package org.usfirst.frc.team102.robot.commands.automode;

import org.usfirst.frc.team102.robot.FieldStatusHelper;

import micobyte.frc.lib.command.SimpleCommandGroup;

public class CommandGroupAutoCrossAndScore extends SimpleCommandGroup {

	public CommandGroupAutoCrossAndScore(boolean isRight) {
		super("Auto: Cross and score");
		
		addSequential(new CommandGroupAutoCrossBaseline());
		addConditional(new CommandGroupAutoScore(isRight), () -> FieldStatusHelper.doesSwitchMatch(isRight));
	}
}

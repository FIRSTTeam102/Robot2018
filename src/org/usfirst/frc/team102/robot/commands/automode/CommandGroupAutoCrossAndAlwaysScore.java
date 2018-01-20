package org.usfirst.frc.team102.robot.commands.automode;

import org.usfirst.frc.team102.robot.FieldStatusHelper;

import micobyte.frc.lib.command.SimpleCommandGroup;

public class CommandGroupAutoCrossAndAlwaysScore extends SimpleCommandGroup {

	public CommandGroupAutoCrossAndAlwaysScore(boolean isRight) {
		super("Auto: Cross and always attempt to score in switch");
		
		addSequential(new CommandGroupAutoCrossBaseline());
		
		boolean[] matches = new boolean[1];
		addConditional(new CommandGroupAutoSwitchSides(isRight), () -> !(matches[0] = FieldStatusHelper.doesSwitchMatch(isRight)));
		addConditional(new CommandGroupAutoScore(isRight), new CommandGroupAutoScore(!isRight), () -> matches[0]);
	}
}

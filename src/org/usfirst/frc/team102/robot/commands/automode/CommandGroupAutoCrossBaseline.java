package org.usfirst.frc.team102.robot.commands.automode;

import org.usfirst.frc.team102.robot.RobotMap;
import org.usfirst.frc.team102.robot.commands.CommandDriveStraight;

import micobyte.frc.lib.command.SimpleCommandGroup;

public class CommandGroupAutoCrossBaseline extends SimpleCommandGroup {
	
	public CommandGroupAutoCrossBaseline() {
		super("Auto: Cross baseline");
		
		addSequential(new CommandDriveStraight(RobotMap.AUTO_MODE_CROSS_BASELINE_DISTANCE));
	}
}
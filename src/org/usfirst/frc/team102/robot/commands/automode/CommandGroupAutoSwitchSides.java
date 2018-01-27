package org.usfirst.frc.team102.robot.commands.automode;

import org.usfirst.frc.team102.robot.RobotMap;
import org.usfirst.frc.team102.robot.commands.CommandDriveStraight;
import org.usfirst.frc.team102.robot.commands.CommandTurn;

import micobyte.frc.lib.command.SimpleCommandGroup;

public class CommandGroupAutoSwitchSides extends SimpleCommandGroup {
	
	public CommandGroupAutoSwitchSides(boolean isRight) {
		super("Auto: Switch sides");
		
		double angle = RobotMap.AUTO_MODE_SWITCH_SIDES_TURN_ANGLE;
		if(!isRight) angle = -angle;
		
		addSequential(new CommandDriveStraight(RobotMap.AUTO_MODE_SWITCH_SIDES_FOREWARD_DISTANCE));
		addSequential(new CommandTurn(angle));
		addSequential(new CommandDriveStraight(RobotMap.AUTO_MODE_SWITCH_SIDES_DISTANCE));
		addSequential(new CommandTurn(-angle));
		addSequential(new CommandDriveStraight(RobotMap.AUTO_MODE_SWITCH_SIDES_FOREWARD_DISTANCE));
		addSequential(new CommandTurn(RobotMap.AUTO_MODE_REVERSE_ANGLE));
	}
}
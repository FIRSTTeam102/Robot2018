package org.usfirst.frc.team102.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CommandGroupResetCCAndLift extends CommandGroup {
	
	public CommandGroupResetCCAndLift() {
		super("Reset CC and Lift");
		
		addSequential(new CommandResetCubeController());
		addSequential(new CommandResetLift());
	}
}
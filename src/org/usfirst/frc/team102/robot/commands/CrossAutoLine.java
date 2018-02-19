package org.usfirst.frc.team102.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossAutoLine extends CommandGroup {
	private int position;

    public CrossAutoLine(int position) {
    	this.position = position;
    	
    	if(position == 1 || position == 3){
    		addSequential(new DriveStraight(0.75, 20));
    	}
    	else {
    		addSequential(new DriveSideways(0.5, false, 9.6));
    		addSequential(new DriveStraight(0.75, 20));
    	}
    	
    	
    	
    	
    	
    	
    	
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	
    	
    }
}

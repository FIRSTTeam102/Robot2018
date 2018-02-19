package org.usfirst.frc.team102.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScoreFromCenter extends CommandGroup {
	private char switchPos;

    public ScoreFromCenter(char switchPos) {
    	this.switchPos = switchPos;
    	
    	if(switchPos == 'L'){
    		addSequential(new DriveStraight(0.75, 1.5));
    		addSequential(new DriveSideways(0.75, true, 6.5));
    		addSequential(new MoveElevator(0.75, 2));
    		addSequential(new DriveStraight(0.75, 3));
    	}
    	else{
    		addSequential(new DriveSideways(0.75, false, 4.3));
    		addSequential(new MoveElevator(0.75, 2));
    		addSequential(new DriveStraight())
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

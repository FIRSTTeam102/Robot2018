package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScoreSwitchSS extends CommandGroup {

    public ScoreSwitchSS(int robotPos) {
    	
    	requires(Robot.robotDriveTrain);
    	//if not using vision, still need to test numbers
    	addSequential(new DriveStraight(0.75, 14));
    	addSequential(new MoveElevator(0.75, 1));
    	if (robotPos==1){
    		addSequential(new Turn(0.75, 1.0));
    	}
    	else {
    		addSequential(new Turn(-0.75, 1.0));
    	}
    	
    	addSequential(new DriveStraight(0.5, 2));
    	addSequential(new ArmSqueeze());
    	
    	
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

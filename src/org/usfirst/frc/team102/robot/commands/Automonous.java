package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;


import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Automonous extends CommandGroup {

    public Automonous() {
    	
    	requires(Robot.robotDriveTrain);
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	//arguments: DriveStraight(speed, distanceToGo)
    	addSequential(new DriveStraight(5, 1.0));
    	
    	
    	
    	
    	
    	
    	
 
  
    		
    	}
    	//v(m/s)=1/2a(m/s2)t^2(s)
    	

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

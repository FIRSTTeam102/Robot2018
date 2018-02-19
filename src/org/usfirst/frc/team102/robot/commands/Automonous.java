package org.usfirst.frc.team102.robot.commands;
import java.util.*;
import java.util.ArrayList;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 *
 */
public class Automonous extends CommandGroup {
	
	
	
    public Automonous() {
    	SendableChooser <Command> dropDown = new SendableChooser <Command>();
    	//dropDown.addObject("Left Score Switch", new );
    	//dropdownoptions
    	//String option1 = ;
    	String option2 = "Left Score Scale"; 
    	String option3 = "Left Cross Line";	
    	String option4 = "Right score Switch";
    	String option5 = "Right score Scale";
    	String option6 = "Right Cross Line";
    	String option7 = "Center cross Line";
    	String option8 = "Center score Switch";
    	int robPos;
    
    	requires(Robot.robotDriveTrain);
    	String driverStationMessage = Robot.robotDriveTrain.getDriverStation().getGameSpecificMessage();
    	char switchPos = driverStationMessage.charAt(0);
    	char scalePos = driverStationMessage.charAt(1);
    	int driverLoacation = Robot.robotDriveTrain.getDriverStation().getLocation();
    	//boolean isStraightAheadLeft = driverStationMessage.charAt(1) == 'L' && driverLocation == 1 ;
    	//boolean isStrightAheadRight = driverStationMessage.charAt(1)=='R' && driverLocation == 3;
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	//arguments: DriveStraight(speed, distanceToGo)
    	
    	
    	
    	
    	dropDown.addObject(name, object);
    	
    	if(driverStationMessage.charAt(1) == 'L' && robotPos == 1 || driverStationMessage.charAt(1)=='R' && robotPos == 3){
    		addSequential(new DriveStraight(0.5, 15));
    		if(driverStationMessage.charAt(1) == 'L'){
    			addSequential(new DriveSideways(0.5, false, 2));
    		}
    		else{addSequential(new DriveSideways(0.5, true, 2));}
    	}
    	else if(driverStationMessage.charAt(1) == 'L' && driverLocation == 3 || driverStationMessage.charAt(1)=='R' && driverLocation == 1){
    		addSequential(new DriveStraight(0.5, 10));
    		if(driverLocation == 1){
    			addSequential(new DriveSideways(0.5, false, 10));
    			addSequential(new DriveStraight(0.5,5));
    			addSequential(new DriveSideways(0.5, true, 2));
    		}
    		else if(driverLocation == 3){
    			addSequential(new DriveSideways(0.5, true, 10));
    			addSequential(new DriveStraight(0.5,5));
    			addSequential(new DriveSideways(0.5, false, 2));
    		}
    	}
    	
    	//If we are to the left, the following should be implemented in autonomous:
    	//Cross auto line, strafe all the way right and score
    	//If we are in the middle, the following should be implemented in autonomous:
    	//Cross auto line, 
    	
    	
    	
    	
    	
    	
    	
 
  
    		
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

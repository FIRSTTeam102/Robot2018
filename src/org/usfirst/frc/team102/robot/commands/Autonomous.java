package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilderImpl;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 /*Note that an error occurred when botPos wasn't initialized to 0. If errors happen in the future, print botPos to see if it is getting 
    	correct value - DWHITE*/
 
public class Autonomous extends Command {
	int botPos = 0;
	int driverPos = 0;
	char switchPos;
    public Autonomous() {
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
   
    	requires(Robot.robotDriveTrain);
    	
    	String driverStationMessage = Robot.robotDriveTrain.getDriverStation().getGameSpecificMessage();
    	char switchPos = driverStationMessage.charAt(0);
    	int driverPos = Robot.robotDriveTrain.getDriverStation().getLocation();
    	
    	System.out.println("constructor");
    	
    	SendableChooser <Command> dropDown = new SendableChooser <Command>();
    	dropDown.addObject("Score or get out of the way", new score(botPos,switchPos));
    	//don't score only crosses the line from any position
    	//if you're in the center, you'll go to the right of the game cubes
    	dropDown.addObject("Don't Score", new CrossAutoLine(botPos, true));
    	//score but don't go to the scale scores, otherwise only crosses the line and sits by the switch
    	dropDown.addObject("Score but don't go to the scale", new ScoreNoScale(botPos, switchPos));
    	
    	SmartDashboard.putData("Auto mode", dropDown);
    	
    	SmartDashboard.putString("DB/String 0","Put bot position using the buttons below:");
    	SmartDashboard.putString("DB/String 1", "Click button 1 if the robot is to the left");
    	SmartDashboard.putString("DB/String 2", "Click button 2 if the robot is in the middle");
    	SmartDashboard.putString("DB/String 3", "Click the third button if the robot is to the right");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(SmartDashboard.getBoolean("DB/Button 1", false)){
    		botPos = 1;
    	}
    	else if(SmartDashboard.getBoolean("DB/Button 2", false)){
    		botPos = 2;
    	}
    	else if(SmartDashboard.getBoolean("DB/Button 3", false)){
    		botPos = 3;
    	}
    	else{
    		if(driverPos == 1){
    			botPos = 1;
    		}
    		else if(driverPos == 2){
    			botPos = 2;
    		}
    		else if(driverPos == 3){
    			botPos = 3;
    		}
    	}
    	
    	System.out.println("pos: " + botPos);
    	
    	//char scalePos = driverStationMessage.charAt(1);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

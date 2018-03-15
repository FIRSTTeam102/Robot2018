package org.usfirst.frc.team102.robot.commands;



import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {
	
	private double percentSpeed;
	private double distanceToGo;
	Timer timer = new Timer();
	double seconds;

	double fullSpeed = 2;
	
	//just changed argument from "double speed and double time"
    public DriveStraight( double percentSpeed, double distanceToGo) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.robotDriveTrain);
    	//setTimeout(timeout);
    	this.percentSpeed = percentSpeed;
    	this.distanceToGo = distanceToGo;
    	
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	try{
    		
    		Robot.robotDriveTrain.driveStraight(percentSpeed, distanceToGo, timer.get());
    		seconds = (percentSpeed * fullSpeed)/distanceToGo;
    		setTimeout(seconds);
   
    		
    		
    		//left to do: when distance (in the distance counter method) is equal to the distanceToGo (put in in the command) stop the motors
    	}catch(Exception ex1){
    		
    		ex1.printStackTrace();
			DriverStation.reportError(ex1.getMessage(), true);
    		
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

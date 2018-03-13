package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 This program for the most part looks good. My only concern would be as to whether or not a while loop needs to be implemented since this runs 
 repeatedly anyway.
 */
public class DriveSideways extends Command {
	
	private boolean isLeft;
	private double distanceToGo;
	private double percentSpeed;
	
	
	public DriveSideways(double percentSpeed ,boolean isLeft, double distanceToGo) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.robotDriveTrain);
		this.isLeft = isLeft;
		this.distanceToGo = distanceToGo;
		this.percentSpeed = percentSpeed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
    	Robot.robotDriveTrain.driveSideways(percentSpeed, isLeft, distanceToGo);
    	
    	
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

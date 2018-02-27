package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn extends Command {

	double seconds;
	double speed;
	
    public Turn(double speed, double seconds) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.robotDriveTrain);
    	this.speed = speed;
    	this.seconds = seconds;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.robotDriveTrain.turn(speed);;
    	setTimeout(seconds);
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

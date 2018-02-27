package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveElevator extends Command {
	private double speed;
	private double time;
	
    public MoveElevator(double speed, double time) {
    	this.speed = speed;
    	this.time = time;
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.robotElevator);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.robotElevator.moveElevator(speed);
    	setTimeout(time);
    	
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

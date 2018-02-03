package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithXBox extends Command {

    public DriveWithXBox() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//Sets that it needs the drivetrain
    	requires(Robot.robotDriveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Executes method in drivetrain that moves robot pulling joystick from OI
    	//Try catch so robot doesn't quit
    	try {
    		
			Robot.robotDriveTrain.driveWithXBox(Robot.oi.getDriverJoystick());
		
    	} catch (Exception ex1) {
			ex1.printStackTrace();
			DriverStation.reportError(ex1.getMessage(), true);
		}
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

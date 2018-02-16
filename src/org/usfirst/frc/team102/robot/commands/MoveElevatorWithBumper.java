package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveElevatorWithBumper extends Command {

	private double speed;

	public MoveElevatorWithBumper(double speed) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.robotElevator);
		this.speed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		try {
			if (speed != 0) {

				Robot.robotElevator.isBumper = true;

				Robot.robotElevator.moveElevatorWithBumpers(speed);

			} else if (speed == 0) {

				Robot.robotElevator.isBumper = false;
				
				Robot.robotElevator.moveElevatorWithBumpers(speed);

			}

		} catch (Exception ex1) {
			 ex1.printStackTrace();
			 DriverStation.reportError(ex1.getMessage(), true);
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}

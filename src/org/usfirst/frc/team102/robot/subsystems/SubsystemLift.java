package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.Robot;
import org.usfirst.frc.team102.robot.RobotMap;

import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import micobyte.frc.lib.io.POVPosition;
import micobyte.frc.lib.subsystem.UpdateableSubsystem;
import micobyte.frc.lib.triggers.POVButton;

public class SubsystemLift extends UpdateableSubsystem {
	protected Trigger moveUpTrigger;
	protected Trigger moveDownTrigger;
	
	protected boolean isResetting = false;
	protected boolean bottomedAlertPlayed = false, toppedAlertPlayed = false;
	
	public SubsystemLift() {
		super("Cube Lift");
		
		moveUpTrigger = new POVButton(Robot.oi.opJoystick, POVPosition.ALL_UPS);
		moveDownTrigger = new POVButton(Robot.oi.opJoystick, POVPosition.ALL_DOWNS);
	}
	
	public void update() {
		if(isResetting) {
			if(isLiftBottomed()) {
				stopMoving();
				isResetting = false;
			} else moveDown();
		} else {
			if(moveUpTrigger.get()) {
				if(!isLiftTopped()) {
					bottomedAlertPlayed = false;
					moveUp();
				} else if(!toppedAlertPlayed) {
					toppedAlertPlayed = true;
					Robot.oi.liftToppedRumble.play(Robot.oi.opJoystick);
				}
			} else if(moveDownTrigger.get()) {
				if(!isLiftBottomed()) {
					toppedAlertPlayed = false;
					moveDown();
				} else if(!bottomedAlertPlayed) {
					bottomedAlertPlayed = true;
					Robot.oi.liftBottomedRumble.play(Robot.oi.opJoystick);
				}
			} else stopMoving();
		}
		
		SmartDashboard.putString("DB/String 0", "Lift Height: " + getHeightFeetAndInches());
		SmartDashboard.putString("DB/String 1", getLiftStatusString());
	}
	
	public String getLiftStatusString() {
		String str = "Lift ";
		if(isLiftTopped()) str += "TOPPED";
		else if(isLiftBottomed()) str += "BOTTOMED";
		else str += "ready";
		
		return str;
	}
	
	public boolean isLiftTopped() { return getHeightInches() >= RobotMap.LIFT_MAX_HEIGHT; }
	public boolean isLiftBottomed() { return getHeightInches() <= 0; }
	
	public String getHeightFeetAndInches() {
		int totalInches = (int)Math.round(getHeightInches());
		
		int feet = totalInches / 12;
		int inches = totalInches % 12;
		
		return (feet + "'" + inches + "\"");
	}
	
	public double getHeightInches() {
		return 0;
		
		// Dummy method
		// TODO implement
	}
	
	public void moveUp() {
		// Dummy method
		// TODO implement
	}
	
	public void moveDown() {
		// Dummy method
		// TODO implement
	}
	
	public void stopMoving() {
		// Dummy method
		// TODO implement
	}
	
	public void reset() {
		isResetting = true;
	}
}
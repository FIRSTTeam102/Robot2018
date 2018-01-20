package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import micobyte.frc.lib.io.POVPosition;
import micobyte.frc.lib.subsystem.UpdateableSubsystem;
import micobyte.frc.lib.triggers.POVButton;

public class SubsystemLift extends UpdateableSubsystem {
	protected Trigger moveUpTrigger;
	protected Trigger moveDownTrigger;
	protected boolean isResetting = false;
	
	public SubsystemLift() {
		super("Cube Lift");
		
		moveUpTrigger = new POVButton(Robot.oi.opJoystick, POVPosition.ALL_UPS);
		moveDownTrigger = new POVButton(Robot.oi.opJoystick, POVPosition.ALL_DOWNS);
	}
	
	public void update() {
		if(isResetting) {
			double height = getHeightInches();
			
			if(height < 1) {
				stopMoving();
				isResetting = false;
			} else moveDown();
		} else {
			if(moveUpTrigger.get()) moveUp();
			else if(moveDownTrigger.get()) moveDown();
			else stopMoving();
		}
		
		SmartDashboard.putString("DB/String 0", "Lift Height: " + getHeightFeetAndInches());
	}
	
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
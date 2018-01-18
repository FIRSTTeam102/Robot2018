package org.usfirst.frc.team102.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class SubsystemClimber extends Subsystem {
	
	public SubsystemClimber() {
		super("Climber");
	}
	
	protected void initDefaultCommand() {}
	
	public void extendClimber() {
		// Dummy method
		// TODO implement
	}
	
	public void retractClimber() {
		// Dummy method
		// TODO implement
	}
	
	public boolean getIsClimberExtended() {
		return false;
		
		// Dummy method
		// TODO implement
	}
	
	public void setClimber(boolean extended) {
		boolean isExtended = getIsClimberExtended();
		
		if(isExtended && !extended) retractClimber();
		if(!isExtended && extended) extendClimber();
	}
}
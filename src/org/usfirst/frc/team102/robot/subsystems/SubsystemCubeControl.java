package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SubsystemCubeControl extends Subsystem {
	protected Solenoid grabberCylController;
	protected Solenoid platformCylController;
	
	public SubsystemCubeControl() {
		super("Cube Controller");
		
		grabberCylController = new Solenoid(RobotMap.SOLENOID_ID_GRAB_ARMS);
		platformCylController = new Solenoid(RobotMap.SOLENOID_ID_PLATFORM);
	}
	
	protected void initDefaultCommand() {}
	
	public void extendGrabArms() {
		grabberCylController.set(true);
	}
	
	public void retractGrabArms() {
		grabberCylController.set(false);
	}
	
	public boolean getAreGrabArmsExtended() {
		return grabberCylController.get();
	}
	
	public void setGrabArms(boolean out) {
		boolean areOut = getAreGrabArmsExtended();
		
		if(areOut && !out) retractGrabArms();
		if(!areOut && out) extendGrabArms();
	}
	
	public void flipPlatform() {
		platformCylController.set(!platformCylController.get());
	}
	
	public boolean getIsPlatformOut() {
		return platformCylController.get();
	}
	
	public void flipTo(boolean out) {
		boolean isOut = getIsPlatformOut();
		
		if(out != isOut) flipPlatform();
	}
	
	public void reset() {
		setGrabArms(false);
		flipTo(false);
	}
}
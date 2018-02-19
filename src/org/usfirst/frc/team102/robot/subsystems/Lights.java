package org.usfirst.frc.team102.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import micobyte.frc.lib.subsystem.SubsystemSerial;

public class Lights extends SubsystemSerial {
	
	public Lights() {
		super("Lights", 9600, 0);
		
		scrollMode();
		setColorToOrange();
	}
	
	public void onLineRecieved(String line) { /*System.out.println("Light Arduino output: " + line);*/ }
	
	public void setParameter(String name, Object val) { send("PARAM " + name + " " + val); }
	public void switchModes(String newMode) { send("SWITCH " + newMode); }
	
	public void scrollMode() { switchModes("SCROLLER"); }
	public void twinkleMode() { switchModes("TWINKLE"); }
	public void offMode() { switchModes("NONE"); }
	
	public void setColor(String name) { setParameter("COLOR", name); }
	public void setColorToOrange() { setColor("ORANGE"); }
	
	public void setColorToAlliance() {
		Alliance alliance = DriverStation.getInstance().getAlliance();
		setColor(alliance.name().toUpperCase());
	}
	
	public void setMovingMode(String moving) { setParameter("MODE", moving); }
	public void setScrollingUp() { setMovingMode("UP"); }
	public void setScrollingDown() { setMovingMode("DOWN"); }
	public void setScrollingIdle() { setMovingMode("IDLE"); }
	public void setScrollingDemo() { setMovingMode("DEMO"); }
	
	public void setScrollingFromSpeed(double speed) {
		if(speed < 0) setScrollingDown();
		else if(speed > 0) setScrollingUp();
		else setScrollingIdle();
	}
	
	public void onAutoStarted() {
		twinkleMode();
		setColorToAlliance();
	}
	
	public void onTeleopStarted() {
		scrollMode();
		setScrollingIdle();
		setColorToAlliance();
	}
	
	public void onDisabled() {
		scrollMode();
		setScrollingDemo();
		setColorToOrange();
	}
}
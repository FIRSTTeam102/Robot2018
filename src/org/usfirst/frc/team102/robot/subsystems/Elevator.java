package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.Robot;
import org.usfirst.frc.team102.robot.RobotMap;
import org.usfirst.frc.team102.robot.commands.MoveElevator;
import org.usfirst.frc.team102.robot.commands.MoveElevatorWithTrigger;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import micobyte.frc.lib.subsystem.UpdateableSubsystem;

/**
 *
 */
public class Elevator extends Subsystem {

	//Create motor object
	
	//private boolean prevBottomSlow = false;
	//private boolean prevTopSlow = false;
	//private boolean downSlow = false;
	//private boolean upSlow = false;
	
	private WPI_TalonSRX elevatorMotor;
	private DigitalInput topSwitch;
	private DigitalInput bottomSwitch;
	//private DigitalInput topSlowSwitch;
	//private DigitalInput bottomSlowSwitch;
	
	private double rightTrigger;
	
	
	public Elevator(){
		
		elevatorMotor = new WPI_TalonSRX(RobotMap.m5);
		
		topSwitch = new DigitalInput(RobotMap.topSwitch);
		bottomSwitch = new DigitalInput(RobotMap.bottomSwitch);
		//topSlowSwitch = new DigitalInput(RobotMap.topSlowSwitch);
		//bottomSlowSwitch = new DigitalInput(RobotMap.bottomSlowSwitch);
		
//		elevatorMotor.setInverted(true);
		
	}
	
    
	
	//with trigger
	public void moveElevator(Joystick gamepad){
		
		rightTrigger = gamepad.getRawAxis(RobotMap.xBoxRightTriggerAxis);
		
		if (rightTrigger>0 && topSwitch.get()){
			elevatorMotor.set(0);
		}
		else{
		elevatorMotor.set(rightTrigger);
		}
		}
	
	
    //withbumpers
    public void moveElevator(double speed){
    	
//    	if(elevatorMotor.)
    	
    	
    	if (speed>0 && topSwitch.get()){
    		elevatorMotor.set(0);
    	}
    	else if(speed<0 && bottomSwitch.get()){
    		elevatorMotor.set(0);
    	}
    	else{ 
    		elevatorMotor.set(speed);
    		
    	}
    	
    }
    //autonomous use
    public void moveElevator(){
    	
    	elevatorMotor.set(.5);
    	
    }

    //
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MoveElevatorWithTrigger());
		
	//
		
	}
} 
/*
	@Override
	public void update() {
		double elevatorSpeed = 0;
		if(Robot.oi.getElevatorUp()) elevatorSpeed = RobotMap.elevatorSpeed;
		else if(Robot.oi.getElevatorDown()) elevatorSpeed = -RobotMap.elevatorSpeed;
		
		boolean topStop = !topSwitch.get();
		boolean bottomStop = !bottomSwitch.get();
		boolean topSlow = !topSlowSwitch.get();
		boolean bottomSlow = !bottomSlowSwitch.get();
		
		boolean canToggleTopSlow = (upSlow || elevatorSpeed > 0);
		boolean canToggleBottomSlow = (downSlow || elevatorSpeed < 0);
		
		if(topSlow != prevTopSlow && canToggleTopSlow) {
			if(topSlow) upSlow = !upSlow;
			prevTopSlow = topSlow;
		}
		
		if(bottomSlow != prevBottomSlow && canToggleBottomSlow) {
			if(bottomSlow) downSlow = !downSlow;
			prevBottomSlow = bottomSlow;
		}
		
		if((upSlow && elevatorSpeed > 0) || (downSlow && elevatorSpeed < 0)) elevatorSpeed /= 2;
		if((topStop && elevatorSpeed > 0) || (bottomStop && elevatorSpeed < 0)) elevatorSpeed = 0;
		
		System.out.println("Stops: " + bottomStop + " : " + topStop);
		System.out.println("Slows: " + bottomSlow + " : " + topSlow);
		System.out.println("Slow actals: " + downSlow + " : " + upSlow);
		
		moveElevator(elevatorSpeed);
	}
    
}*/

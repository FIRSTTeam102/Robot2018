package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.RobotMap;
import org.usfirst.frc.team102.robot.commands.MoveElevator;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.RemoteLimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

	//Create motor object
	private WPI_TalonSRX m5;

	public Elevator(){
		
		m5 = new WPI_TalonSRX(RobotMap.m5);
		
		m5.setInverted(true);
		
		m5.configForwardLimitSwitchSource(LimitSwitchSource.RemoteTalonSRX, LimitSwitchNormal.NormallyOpen, 0);
		
		m5.enableCurrentLimit(true);
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	
    }
    
    public void moveElevator(double speed){
    	
//    	if(m5.)
    	
    	m5.set(speed);
    	
    }
    
    public void moveElevator(){
    	
    	m5.set(.5);
    	
    }
    
}


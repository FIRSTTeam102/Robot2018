package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Compressor compressor;
	Solenoid upDown;
	Solenoid squeeze;
	
	public Arm(){
		if(RobotMap.hasPneumatics) {
			upDown = new Solenoid(RobotMap.solenoid1Index);
			squeeze = new Solenoid(RobotMap.solenoid2Index);
			compressor = new Compressor();
			
			compressor.setClosedLoopControl(true);
		}
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void moveArm(boolean isExtended){
    
    	if(RobotMap.hasPneumatics) upDown.set(isExtended);
    	
    }
    
  
    
    public void moveArm(){
    	
    	if(RobotMap.hasPneumatics) {
    		if(upDown.get()){
        		
        		upDown.set(false);
        		
        	}else{
        		
        		upDown.set(true);
        		
        	}
    	}
    }

	public void squeezeArm() {
		
		if(RobotMap.hasPneumatics) {
			squeeze.set(true);
			
			
			if(squeeze.get()){
				
				squeeze.set(false);
				System.out.println("how we doin");
				
			}else{
				
				squeeze.set(true);
				System.out.println("how");
			}
		}
		
	}
    
}


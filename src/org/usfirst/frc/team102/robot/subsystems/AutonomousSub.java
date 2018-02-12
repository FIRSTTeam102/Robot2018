package org.usfirst.frc.team102.robot.subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AutonomousSub extends Subsystem {

	BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();
	
	
	//method to calculate distance based on acceleration
	public double Distance(double seconds){
		double distance;
		double acceleration = accelerometer.getZ();
		
		distance = acceleration/2/seconds;
		return distance;
		
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


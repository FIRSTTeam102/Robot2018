package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.Robot;
import org.usfirst.frc.team102.robot.RobotMap;
import org.usfirst.frc.team102.robot.commands.MoveElevatorWithJoystick;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

	// Create motor object

	public boolean isBumper;

	private boolean isSlow;
	private WPI_TalonSRX elevatorMotor;
	private DigitalInput topSwitch;
	private DigitalInput bottomSwitch;
	private DigitalInput topSlowSwitch;
	private DigitalInput bottomSlowSwitch;

	private double leftJoystickY;

	public Elevator() {

		elevatorMotor = new WPI_TalonSRX(RobotMap.m5);

		topSwitch = new DigitalInput(RobotMap.topSwitch);
		bottomSwitch = new DigitalInput(RobotMap.bottomSwitch);
		topSlowSwitch = new DigitalInput(RobotMap.topSlowSwitch);
		bottomSlowSwitch = new DigitalInput(RobotMap.bottomSlowSwitch);

		isBumper = false;

		

	}

	public void moveElevatorWithBumpers(double speed) {

		set(speed);

	}

	public void moveElevatorWithJoystick(Joystick xBoxDriver) {

		leftJoystickY = xBoxDriver.getRawAxis(RobotMap.xBoxLeftYAxis);

		/*
		 * System.out.println("Right Trigger Axis: " +
		 * RobotMap.xBoxRightTriggerAxis); System.out.println(
		 * "Left Trigger Axis: " + RobotMap.xBoxLeftTriggerAxis);
		 * System.out.println("Right Trigger: " + rightTrigger);
		 * System.out.println("Left Trigger: " + leftTrigger);
		 */

		if (Math.abs(leftJoystickY) <= 0.1) {

			leftJoystickY = 0;

		}

		set(leftJoystickY);

		/*
		 * else if (leftTrigger <= 0.1) {
		 * 
		 * leftTrigger = 0;
		 * 
		 * }
		 */

		// if (rightTrigger < 0) {

		/*
		 * } else if (leftTrigger > 0) { set(leftTrigger); } else { set(0); }
		 */

		/*
		 * System.out.println(!bottomSwitch.get());
		 * System.out.println(elevatorMotor.get());
		 */

	}

	public void set(double speed) {

		if (speed > 0) {

			if (!bottomSwitch.get()) {

				isSlow = false;

			}
			
			if(!bottomSlowSwitch.get()){
				
				isSlow = false;
				
			}

			if (!topSlowSwitch.get()) {

				isSlow = true;

			}

			if (speed > 0 && !topSwitch.get()) {

				speed = 0;

			}

		} else {

			if (!topSwitch.get()) {

				isSlow = false;

			}

			if (!topSlowSwitch.get()) {

				isSlow = false;

			}
			
			if (!bottomSlowSwitch.get()) {

				isSlow = true;

			}

			if (speed < 0 && !bottomSwitch.get()) {

				speed = 0;

			}

		}

		if(isSlow){
			
			speed/=2;
			
		}
		
		// lights
		if(Robot.robotLights != null) {
			Robot.robotLights.setScrollingFromSpeed(-speed);
		}
		
		// gravitational compensation
		if(speed == 0) {
			speed = -.1;
		}
		
		elevatorMotor.set(speed);

		// took out or's to prevent recognizing top switch when going up and
		// bottom when going down
		/*
		 * if(!topSlowSwitch.get() || !bottomSlowSwitch.get()) { isSlow = true;
		 * }
		 * 
		 * // slow toggle off if(isSlow && (!topSwitch.get() ||
		 * !bottomSwitch.get())) { isSlow = false; }
		 */
		// slow toggle on
		// speed = -speed;
		// if(speed > 0){
		//
		// isSlowDown = false;
		//
		// if(!topSlowSwitch.get()){
		// isSlowUp = true;
		// }
		//
		// }
		//
		// if(speed < 0){
		// isSlowUp = false;
		//
		// if(!bottomSlowSwitch.get()){
		// isSlowDown = true;
		// }
		//
		// }
		//
		// if(isSlowUp == true){
		// speed /= 2;
		// }

		/*
		 * if (speed > 0 && !bottomSlowSwitch.get()){ isSlow = true; } if (speed
		 * < 0 && !topSlowSwitch.get()){ isSlow = true; }
		 * 
		 * 
		 * // bottom limit switch if(speed > 0 && !bottomSwitch.get()){ speed =
		 * 0; isSlow = false; }
		 * 
		 * // top limit switch if(speed < 0 && !topSwitch.get()){ speed = 0;
		 * isSlow = false; }
		 * 
		 * // slow mode if(isSlow) { speed /= 2; }
		 * 
		 * Robot.robotLights.setScrollingFromSpeed(-speed);
		 * 
		 * // gravitational compensation if(speed == 0) { speed = -.1; }
		 */

	}

	// withbumpers

	// with trigger
	/*
	 * public void moveElevator(Joystick gamepad){
	 * 
	 * rightTrigger = gamepad.getRawAxis(RobotMap.xBoxRightTriggerAxis);
	 * leftTrigger = gamepad.getRawAxis(RobotMap.xBoxLeftTriggerAxis); double
	 * elevatorSpeed = 0; if (isElevatorDown){
	 * 
	 * rightTrigger = rightTrigger*-1; leftTrigger = leftTrigger * -1; } //Limit
	 * switches have a not before them because they are "Active Low" //Which
	 * means that they will return true until they are pushed if (rightTrigger>0
	 * ){ if(!topSwitch.get()){ elevatorSpeed = 0; } else{ elevatorSpeed =
	 * -rightTrigger; } }
	 * 
	 * else if(leftTrigger>0){ if(!bottomSwitch.get()){ elevatorSpeed = 0; }
	 * else{ elevatorSpeed = leftTrigger; } }
	 * 
	 * if(Robot.oi.getLeftBumper()){ elevatorSpeed = -RobotMap.elevatorSpeed; }
	 * 
	 * else if(Robot.oi.getRightBumper()){ elevatorSpeed =
	 * RobotMap.elevatorSpeed; }
	 * 
	 * moveElevator(elevatorSpeed); }
	 */

	// autonomous use
	public void moveElevator(double speed) {

		elevatorMotor.set(-speed);

	}

	public void gravHelp(){
		
		elevatorMotor.set(-.1);
		
	}
	
	protected void initDefaultCommand() {

		setDefaultCommand(new MoveElevatorWithJoystick());

	}
}

package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.Robot;
import org.usfirst.frc.team102.robot.RobotMap;
import org.usfirst.frc.team102.robot.commands.MoveElevatorWithTrigger;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import micobyte.frc.lib.subsystem.UpdateableSubsystem;

/**
 *
 */
public class Elevator extends Subsystem {

	// Create motor object

	// private boolean prevBottomSlow = false;
	// private boolean prevTopSlow = false;
	// private boolean downSlow = false;
	// private boolean upSlow = false;
	public boolean isBumper;
	private WPI_TalonSRX elevatorMotor;
	private DigitalInput topSwitch;
	private DigitalInput bottomSwitch;
	// private DigitalInput topSlowSwitch;
	// private DigitalInput bottomSlowSwitch;

	private double rightTrigger;
	private double leftTrigger;

	public Elevator() {

		elevatorMotor = new WPI_TalonSRX(RobotMap.m5);

		topSwitch = new DigitalInput(RobotMap.topSwitch);
		bottomSwitch = new DigitalInput(RobotMap.bottomSwitch);

		isBumper = false;
		// topSlowSwitch = new DigitalInput(RobotMap.topSlowSwitch);
		// bottomSlowSwitch = new DigitalInput(RobotMap.bottomSlowSwitch);

		// elevatorMotor.setInverted(true);

	}

	public void moveElevatorWithBumpers(double speed) {

		if (speed > 0 && !topSwitch.get()) {

			elevatorMotor.set(0);
			// isBumper = false;

		} else if (speed < 0 && !bottomSwitch.get()) {

			elevatorMotor.set(0);
			// isBumper = false;

		} else {

			elevatorMotor.set(speed);

		}

	}

	public void moveElevatorWithTriggers(Joystick xBoxDriver) {

		rightTrigger = xBoxDriver.getRawAxis(RobotMap.xBoxRightTriggerAxis);
		leftTrigger = xBoxDriver.getRawAxis(RobotMap.xBoxLeftTriggerAxis);

		System.out.println("Right Trigger Axis: " + RobotMap.xBoxRightTriggerAxis);
		System.out.println("Left Trigger Axis: " + RobotMap.xBoxLeftTriggerAxis);
		System.out.println("Right Trigger: " + rightTrigger);
		System.out.println("Left Trigger: " + leftTrigger);
		
		rightTrigger = -rightTrigger;

		if (rightTrigger >= -0.1) {

			rightTrigger = 0;

		} else if (leftTrigger <= 0.1) {

			leftTrigger = 0;

		}

		

		if (rightTrigger < 0) {

			if (!topSwitch.get()) {

				elevatorMotor.set(0);

			} else {

				elevatorMotor.set(rightTrigger);

			}

		} else if (leftTrigger > 0) {

			if (!bottomSwitch.get()) {

				elevatorMotor.set(0);

			} else {

				elevatorMotor.set(leftTrigger);

			}

		} else {

			elevatorMotor.set(0);

		}

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
	public void moveElevator() {

		elevatorMotor.set(.5);

	}

	protected void initDefaultCommand() {

		setDefaultCommand(new MoveElevatorWithTrigger());

	}
}

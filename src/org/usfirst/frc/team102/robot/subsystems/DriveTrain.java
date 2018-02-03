package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.RobotMap;
import org.usfirst.frc.team102.robot.commands.DriveWithXBox;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {

	// Creating MecanumDrive Object
	private MecanumDrive drive;

	// Creating Motor Objects
	WPI_TalonSRX m1;
	WPI_TalonSRX m2;
	WPI_TalonSRX m3;
	WPI_TalonSRX m4;

	// Creating Joystick Axis Variables
	private double leftJoyX;
	private double leftJoyY;
	private double rightJoyX;
	private double rightJoyY;

	// DriveTrain constructor
	public DriveTrain() {

		// Initializing motors Motors
		m1 = new WPI_TalonSRX(RobotMap.m1);
		m2 = new WPI_TalonSRX(RobotMap.m2);
		m3 = new WPI_TalonSRX(RobotMap.m3);
		m4 = new WPI_TalonSRX(RobotMap.m4);

		// drive = new MecanumDrive(m1 = new WPI_TalonSRX(RobotMap.m1), m2 = new
		// WPI_TalonSRX(RobotMap.m2),
		// m3 = new WPI_TalonSRX(RobotMap.m3), m4 = new
		// WPI_TalonSRX(RobotMap.m4));

		m1.setInverted(true);
		m2.setInverted(true);

		// creating an instance of MecanumDrive
		drive = new MecanumDrive(m1, m2, m3, m4);

		// turning Safety ON
		drive.setSafetyEnabled(true);

	}

	// Setting the default command of drivetrain to driveWithXBox
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DriveWithXBox());

	}

	// driveWithXBox method that takes joystick axises and puts it into
	// driveCartesian
	// to move the motors for mecanum drive
	public void driveWithXBox(Joystick xBox) {

		// Pulling joystick values
		leftJoyX = xBox.getRawAxis(RobotMap.xBoxLeftXAxis);
		leftJoyY = xBox.getRawAxis(RobotMap.xBoxLeftYAxis);
		rightJoyY = xBox.getRawAxis(RobotMap.xBoxRightYAxis);
		rightJoyX = xBox.getRawAxis(RobotMap.xBoxRightXAxis);

		if (leftJoyX <= 0.1 && leftJoyX >= -0.1) {

			leftJoyX = 0.0;

		}

		if (leftJoyY <= 0.1 && leftJoyY >= -0.1) {

			leftJoyY = 0.0;

		}

		if (rightJoyX <= 0.1 && rightJoyX >= -0.1) {

			rightJoyX = 0.0;

		}

		// putting it into method to move motors
		drive.driveCartesian(-leftJoyY, leftJoyX, rightJoyX);

	}

	// Method to drive robot straight
	public void driveStraight(double speed) {

		// moves motors forward
		drive.driveCartesian(speed, 0.0, 0.0);

	}

}

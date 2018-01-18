package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.Robot;
import org.usfirst.frc.team102.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.GenericHID;
import micobyte.frc.lib.subsystem.UpdateableSubsystemDrive;

public class SubsystemDriveTrain extends UpdateableSubsystemDrive {
	
	public SubsystemDriveTrain() {
		super(
			new WPI_TalonSRX(RobotMap.CAN_ID_DRIVE_TRAIN_FRONT_LEFT),
			new WPI_TalonSRX(RobotMap.CAN_ID_DRIVE_TRAIN_BACK_LEFT),
			new WPI_TalonSRX(RobotMap.CAN_ID_DRIVE_TRAIN_FRONT_RIGHT),
			new WPI_TalonSRX(RobotMap.CAN_ID_DRIVE_TRAIN_BACK_RIGHT)
		);
	}
	
	public boolean[] getInverts() { return new boolean[] { false, true, false, false }; }
	public double getDriveDeadband() { return RobotMap.JOYSTICK_DEADBAND; }
	public GenericHID[] getDriveHIDDevices() { return new GenericHID[] { Robot.oi.driverJoystick }; }
}
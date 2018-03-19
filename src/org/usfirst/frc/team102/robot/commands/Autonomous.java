package org.usfirst.frc.team102.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {
	boolean isSameSide;

	public Autonomous(int autoType, int botPos, char switchPos) {
		if ((botPos == 1 && switchPos == 'L') || (botPos == 3 && switchPos == 'R')) {
			isSameSide = true;
		} else {
			isSameSide = false;
		}

		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.

		if (autoType == 1) {

			if ((botPos == 1 && switchPos == 'L') || (botPos == 3 && switchPos == 'R')) {

				addParallel(new MoveElevator(-0.75, 1));
				addParallel(new DriveForwardsAuto(1.7));
				addParallel(new UpDownArm());
				addSequential(new GravityHelp(1.0));
				addSequential(new Wait(1.0));
				addParallel(new ArmSqueeze());
				addSequential(new GravityHelp(0.01));

				if (botPos == 1) {

					addSequential(new DriveSideways(1, -.5));

				} else {

					addSequential(new DriveSideways(1.5, 0.5));

				}

			} else if ((botPos == 1 && switchPos == 'R') || (botPos == 3 && switchPos == 'L')) {
				addSequential(new DriveForwardsAuto(1.7));

				if (botPos == 1) {

					addSequential(new DriveSideways(1, -.5));

				} else {

					addSequential(new DriveSideways(1.5, 0.5));

				}

			} else if (botPos == 2) {
				if (switchPos == 'L') {
					addSequential(new DriveStraight(0.75, 1.5));
					addSequential(new DriveSideways(0.75, 2.0));
					addSequential(new MoveElevator(0.75, 2));
					addSequential(new DriveStraight(0.75, 3));
				} else {
					addSequential(new DriveSideways(0.75, 1.5));
					addSequential(new MoveElevator(0.75, 2));
					addSequential(new DriveStraight(0.75, 6));
				}

			}

		} else if (autoType == 2) {

			if ((botPos == 1 && switchPos == 'L') || (botPos == 3 && switchPos == 'R')) {
				addSequential(new DriveStraight(0.75, 14));
				addSequential(new MoveElevator(0.75, 1));

				if (botPos == 1) {
					addSequential(new Turn(0.75, 0.5));
				} else if (botPos == 3) {
					addSequential(new Turn(-0.75, 0.5));
				}

				addSequential(new DriveStraight(0.75, 4.5));
				addSequential(new ArmSqueeze());
			} else if ((botPos == 3 && switchPos == 'L') || (botPos == 1 && switchPos == 'R')) {
				if (botPos == 1 || botPos == 3) {
					addSequential(new DriveStraight(0.75, 10.25));

				}

				else {
					addSequential(new DriveStraight(0.75, 10.25));
				}
			} else if (botPos == 2) {
				if (switchPos == 'L') {
					addSequential(new DriveStraight(0.75, 1.5));
					addSequential(new DriveSideways(0.75, 2.0));
					addSequential(new MoveElevator(0.75, 2));
					addSequential(new DriveStraight(0.75, 3));
				} else {
					addSequential(new MoveElevator(0.75, 2));
					addSequential(new DriveStraight(0.75, 10.25));
				}

			}

		} else {

			addSequential(new DriveForwardsAuto(1.75));

			System.out.println("Are we on the same side? " + isSameSide);
		}

	}
}

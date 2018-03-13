package org.usfirst.frc.team102.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class score extends CommandGroup {
	
	public score(int botPos,char switchPos) {
    	
    	if ((botPos == 1 && switchPos == 'L') || (botPos == 3 && switchPos== 'R') ){
    		addSequential(new ScoreSwitchSS(botPos));
    	
    	}
		
		else if((botPos == 1 && switchPos== 'R') || (botPos == 3 && switchPos == 'L')){
			addSequential(new GetInScalePosition(botPos));
		}
		else if(botPos == 2){
			addSequential(new ScoreFromCenter(switchPos));
			
		}
		

		
     }
    	
    	// Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    
}

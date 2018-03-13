package org.usfirst.frc.team102.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScoreNoScale extends CommandGroup {
	
	public ScoreNoScale(int botPos, char switchPos) {
    	if ((botPos == 1 && switchPos == 'L') || (botPos == 3 && switchPos== 'R')){
    		addSequential(new ScoreSwitchSS(botPos));
    	}
		else if((botPos ==3  && switchPos== 'L') || (botPos == 1 && switchPos == 'R') ){
			addSequential(new CrossAutoLine(botPos, false));
		}
		else if(botPos == 2){
			addSequential(new ScoreFromCenter(switchPos));
			
		}
    	
 }
}
    
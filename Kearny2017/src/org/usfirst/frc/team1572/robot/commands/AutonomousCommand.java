package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.AutonomousMode;
import org.usfirst.frc.team1572.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {
	
    public AutonomousCommand(final AutonomousMode autonomousMode) {
    	
    	switch(autonomousMode){
    	case MID_GEAR:
	    	addSequential(new DriveDistance(93));
	    	addSequential(new AimForPegAutonomously());
	    	break;
    	case LEFT_GEAR:	
	    	addSequential(new DriveDistance(93.3));
	    	addSequential(new TurnUntilAngle(-58));    	
	    	addSequential(new DriveDistance(62.4039));
	    	addSequential(new AimForPegAutonomously());
	    	break;
    	
    	case RIGHT_GEAR:
	    	addSequential(new DriveDistance(93.3));
	    	addSequential(new TurnUntilAngle(-58));
	    	addSequential(new DriveDistance(62.4039));
	    	addSequential(new AimForPegAutonomously());  
	    	break;
    	case TEST_GEAR:
	    	addSequential(new DriveDistance(48));
	    	addSequential(new TurnUntilAngle(-90));
	    	addSequential(new DriveDistance(12));
	    	addSequential(new AimForPegAutonomously());
	    	break;
    	default:
    		//TODO: Should be command call
    		Robot.joydrive.arcadeDrive(0, 0);
    		break;
    	}
    }
  }
    
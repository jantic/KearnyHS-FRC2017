package org.usfirst.frc.team1572.robot.commands.autonomous;

import org.usfirst.frc.team1572.robot.commands.subtasks.Delay;
import org.usfirst.frc.team1572.robot.commands.subtasks.SpinUpShooter;
import org.usfirst.frc.team1572.robot.commands.main.DriveDistance;
import org.usfirst.frc.team1572.robot.commands.main.ShootFar;
import org.usfirst.frc.team1572.robot.commands.main.TurnUntilAngle;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftHopperShoot extends CommandGroup {
	//TODO:  Update to make it work for this scenario
    public LeftHopperShoot() {
    	
    	addSequential(new DriveDistance(72,0.75,4));
    	addSequential(new TurnUntilAngle(-90,0.65));
    	addSequential(new Delay(0.25));
    	addSequential(new DriveDistance(-25,0.7,1.5));
    	addSequential(new Delay(1.5));
    	addSequential(new DriveDistance(25,0.7,1.5));
    	addParallel(new SpinUpShooter(3700));
    	addSequential(new TurnUntilAngle(170,0.65));
    	addSequential(new ShootFar());
    }
  }
    
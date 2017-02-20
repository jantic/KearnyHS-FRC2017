package org.usfirst.frc.team1572.robot.commands.autonomous;

import org.usfirst.frc.team1572.robot.commands.Delay;
import org.usfirst.frc.team1572.robot.commands.main.AimForPegAutonomously;
import org.usfirst.frc.team1572.robot.commands.main.DriveDistance;
import org.usfirst.frc.team1572.robot.commands.main.GearRelease;
import org.usfirst.frc.team1572.robot.commands.main.TurnUntilAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class RightGearAutonomous extends CommandGroup {
	//TODO:  Update to make it work for this scenario
    public RightGearAutonomous() {
    	addSequential(new DriveDistance(53.3));
    	addSequential(new TurnUntilAngle(-58));
    	addParallel(new AimForPegAutonomously());
    	addParallel(new DriveDistance(32));
    	addSequential(new Delay(0.25));
    	addParallel(new GearRelease());
    	addParallel(new DriveDistance(-6));
    }
  }
    //93.3
	//62
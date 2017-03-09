package org.usfirst.frc.team1572.robot.commands.autonomous;

import org.usfirst.frc.team1572.robot.commands.main.AimForPegAutonomously;
import org.usfirst.frc.team1572.robot.commands.main.DriveDistance;
import org.usfirst.frc.team1572.robot.commands.main.GearRelease;
import org.usfirst.frc.team1572.robot.commands.main.TurnUntilAngle;
import org.usfirst.frc.team1572.robot.commands.subtasks.Delay;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class RightGearAutonomous extends CommandGroup {
	//TODO:  Update to make it work for this scenario
    public RightGearAutonomous() {
    	addSequential(new DriveDistance(53.3,0.75));
    	addSequential(new TurnUntilAngle(-45,0.7));
    	addSequential(new Delay(0.25));
    	addSequential(new DriveDistance(25,0.7));
    	addSequential(new AimForPegAutonomously());
    	addSequential(new DriveDistance(21,0.65));
    	//addSequential(new Delay(0.25));
    	addSequential(new GearRelease());
    	addSequential(new DriveDistance(-6,0.7));
    }
  }
    //93.3
	//62
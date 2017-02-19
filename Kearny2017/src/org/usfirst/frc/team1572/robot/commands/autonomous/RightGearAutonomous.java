package org.usfirst.frc.team1572.robot.commands.autonomous;

import org.usfirst.frc.team1572.robot.commands.main.AimForPegAutonomously;
import org.usfirst.frc.team1572.robot.commands.main.DriveDistance;
import org.usfirst.frc.team1572.robot.commands.main.TurnUntilAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class RightGearAutonomous extends CommandGroup {
	//TODO:  Update to make it work for this scenario
    public RightGearAutonomous() {
    	addSequential(new DriveDistance(70));
    	addSequential(new TurnUntilAngle(-90));
    	addParallel(new AimForPegAutonomously());
    	addParallel(new DriveDistance(48));
    }
  }
    
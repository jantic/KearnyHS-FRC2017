package org.usfirst.frc.team1572.robot.commands.autonomous;

import org.usfirst.frc.team1572.robot.commands.Delay;
import org.usfirst.frc.team1572.robot.commands.main.AimForPegAutonomously;
import org.usfirst.frc.team1572.robot.commands.main.DriveDistance;
import org.usfirst.frc.team1572.robot.commands.main.GearRelease;
import org.usfirst.frc.team1572.robot.commands.main.TurnUntilAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MidGearAutonomous extends CommandGroup {
	//TODO:  Update to make it work for this scenario
    public MidGearAutonomous() {
    	//addParallel(new AimForPegAutonomously());
    	addSequential(new DriveDistance(55));
    	addSequential(new Delay(0.25));
    	addParallel(new GearRelease());
    	addSequential(new DriveDistance(-2));
    }
  }
    
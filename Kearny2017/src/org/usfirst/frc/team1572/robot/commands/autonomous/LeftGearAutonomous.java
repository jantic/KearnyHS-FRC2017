package org.usfirst.frc.team1572.robot.commands.autonomous;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.commands.Delay;
import org.usfirst.frc.team1572.robot.commands.ResetAll;
import org.usfirst.frc.team1572.robot.commands.main.AimForPegAutonomously;
import org.usfirst.frc.team1572.robot.commands.main.DriveDistance;
import org.usfirst.frc.team1572.robot.commands.main.GearRelease;
import org.usfirst.frc.team1572.robot.commands.main.TurnUntilAngle;
import org.usfirst.frc.team1572.robot.subsystems.HeadingSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftGearAutonomous extends CommandGroup {
	//TODO:  Update to make it work for this scenario
    public LeftGearAutonomous() {
    	
    	addSequential(new DriveDistance(53.3));
    	addSequential(new TurnUntilAngle(30,0.7));
    	addSequential(new DriveDistance(30));
    	addParallel(new AimForPegAutonomously());
    	addSequential(new DriveDistance(16));
    	addSequential(new Delay(0.25));
    	addParallel(new GearRelease());
    	addSequential(new DriveDistance(-2));
    }
  }
    
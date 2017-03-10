package org.usfirst.frc.team1572.robot.commands.autonomous;

import org.usfirst.frc.team1572.robot.commands.subtasks.Delay;
import org.usfirst.frc.team1572.robot.commands.main.AimForPegAutonomously;
import org.usfirst.frc.team1572.robot.commands.main.DriveDistance;
import org.usfirst.frc.team1572.robot.commands.main.DriveDistanceCurved;
import org.usfirst.frc.team1572.robot.commands.main.DriveDistanceJiggly;
import org.usfirst.frc.team1572.robot.commands.main.GearRelease;
import org.usfirst.frc.team1572.robot.commands.main.RaiseClawPrepShooter;
import org.usfirst.frc.team1572.robot.commands.main.ShootFar;
import org.usfirst.frc.team1572.robot.commands.main.TurnUntilAngle;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftGearHopperShoot extends CommandGroup {
	//TODO:  Update to make it work for this scenario
    public LeftGearHopperShoot() {
    	
    	addSequential(new DriveDistance(53.3,0.75,3));
    	addSequential(new TurnUntilAngle(35,0.65));
    	addSequential(new Delay(0.25));
    	addSequential(new DriveDistance(25,0.7,2));
    	addParallel(new AimForPegAutonomously());
    	addSequential(new DriveDistanceJiggly(16,6, 0.75,0.65,1.5));
    	//addSequential(new Delay(0.25));
    	addSequential(new GearRelease());
    	addParallel(new RaiseClawPrepShooter());
    	addSequential(new DriveDistanceCurved(-100,0.75,3.5,-0.25));
    	addSequential(new ShootFar());
    }
  }
    
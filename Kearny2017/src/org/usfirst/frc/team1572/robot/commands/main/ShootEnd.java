package org.usfirst.frc.team1572.robot.commands.main;

import org.usfirst.frc.team1572.robot.commands.subtasks.StopBallHopper;
import org.usfirst.frc.team1572.robot.commands.subtasks.StopShooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShootEnd extends CommandGroup {
	
    public ShootEnd() {
    	addSequential(new StopBallHopper());
    	addSequential(new StopShooter());
    }
  }
    
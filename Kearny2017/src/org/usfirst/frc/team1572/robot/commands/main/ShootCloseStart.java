package org.usfirst.frc.team1572.robot.commands.main;

import org.usfirst.frc.team1572.robot.commands.subtasks.SpinUpBallHopper;
import org.usfirst.frc.team1572.robot.commands.subtasks.SpinUpShooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShootCloseStart extends CommandGroup {
	
    public ShootCloseStart() {
    	addSequential(new SpinUpBallHopper());
    	addSequential(new SpinUpShooter(500));
    }
  }
    
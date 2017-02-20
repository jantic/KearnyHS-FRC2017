package org.usfirst.frc.team1572.robot.commands.main;

import org.usfirst.frc.team1572.robot.commands.subtasks.StopShootingBalls;
import org.usfirst.frc.team1572.robot.commands.subtasks.WindDownShooter;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class StopShooting extends CommandGroup{
	public StopShooting(){
		this.addSequential(new StopShootingBalls());
		this.addSequential(new WindDownShooter());
	}
}

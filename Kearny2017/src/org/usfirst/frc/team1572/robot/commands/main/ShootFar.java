package org.usfirst.frc.team1572.robot.commands.main;

import org.usfirst.frc.team1572.robot.commands.subtasks.SpinUpShooter;
import org.usfirst.frc.team1572.robot.commands.subtasks.ShootBalls;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShootFar extends CommandGroup{
	public ShootFar(){
		this.addSequential(new SpinUpShooter(3700));
		this.addSequential(new ShootBalls());
	}
}

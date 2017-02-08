package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightGear extends CommandGroup {

	public RightGear() {
		requires(Robot.joydrive);
		addSequential(new DriveDistance(93.3));
		addSequential(new AutoTurn(58));
		addSequential(new DriveDistance(62.4039));
	}
}

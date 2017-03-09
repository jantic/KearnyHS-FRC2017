package org.usfirst.frc.team1572.robot.commands.main;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.LiftSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class RunLifterForwards extends Command {
	private final LiftSubsystem liftSubystem = Robot.liftSubystem;

	public RunLifterForwards() {
		requires(Robot.liftSubystem);
	}

	@Override
	protected void initialize() {
		this.liftSubystem.runLifterForwards();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
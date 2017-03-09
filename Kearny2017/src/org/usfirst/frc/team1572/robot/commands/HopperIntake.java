package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.BallHopperSubysystem;

import edu.wpi.first.wpilibj.command.Command;

public class HopperIntake extends Command {
	private final BallHopperSubysystem ballHopperSubsystem = Robot.ballHopperSubsystem;

	public void ClawintakeForwards() {
		requires(Robot.ballHopperSubsystem);
	}

	@Override
	protected void initialize() {
		this.ballHopperSubsystem.run();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
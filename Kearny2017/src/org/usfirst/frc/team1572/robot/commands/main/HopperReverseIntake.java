package org.usfirst.frc.team1572.robot.commands.main;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.BallHopperSubysystem;

import edu.wpi.first.wpilibj.command.Command;

public class HopperReverseIntake extends Command {
	private final BallHopperSubysystem ballHopperSubsystem = Robot.ballHopperSubsystem;

	public void ClawintakeForwards() {
		requires(Robot.ballHopperSubsystem);
	}

	@Override
	protected void initialize() {
		this.ballHopperSubsystem.reverse();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
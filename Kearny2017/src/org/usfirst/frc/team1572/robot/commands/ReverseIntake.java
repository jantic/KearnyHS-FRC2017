package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.ClawIntakeSubsystem;
import edu.wpi.first.wpilibj.command.Command;

public class ReverseIntake extends Command {
	private final ClawIntakeSubsystem clawIntakeSubystem = Robot.clawIntakeSubsystem;

	public void ClawintakeForwards() {
		requires(Robot.clawIntakeSubsystem);
	}

	@Override
	protected void initialize() {
		this.clawIntakeSubystem.reverseIntake();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
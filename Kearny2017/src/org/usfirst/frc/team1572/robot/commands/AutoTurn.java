package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class AutoTurn extends Command {

	private final double m_finalDistance;
	private double m_currentDistance;

	public AutoTurn(double dist) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.joydrive);
		this.m_finalDistance = dist;
	}

	private static double getSpeed(double rpm, double size) {

		double speed = (rpm * size * Math.PI) / 60.0;
		return speed;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		this.m_currentDistance = 0;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double leftRPM = RobotMap.leftDrivetrain.getSpeed();
		double rightRPM = RobotMap.rightDrivetrain.getSpeed();
		double time = 20.0 / 1000.0;
		// double totalRPM = leftRPM + rightRPM;
		// double RPM = totalRPM/2;
		double speedL = getSpeed(leftRPM, 8.0);
		double speedR = getSpeed(rightRPM, 8.0);
		double distanceTraveledL = time * speedL;
		double distanceTraveledR = time * speedR;
		// m_currentDistance = distanceTraveled + m_currentDistance;

		if (this.m_finalDistance > 0) {
			this.m_currentDistance = distanceTraveledR + this.m_currentDistance;
			RobotMap.leftDrivetrain.set(.5);
		} else {
			this.m_currentDistance = distanceTraveledL + this.m_currentDistance;
			RobotMap.rightDrivetrain.set(.5);
		}
		// RobotMap.robotDrive.arcadeDrive(0.25, 0);

	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return this.m_finalDistance <= this.m_currentDistance;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		// nothing to do here
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		// nothing to do here
	}
}
package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.NavigationSubsystem;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StreamNavigationOutput extends Command {
	private final NavigationSubsystem navigationSubsystem = Robot.navigationSubsystem;
	
	public StreamNavigationOutput() {
		requires(Robot.navigationSubsystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		// nothing to do here
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		SmartDashboard.putNumber("Displacement X", this.navigationSubsystem.getDisplacementX());
		SmartDashboard.putNumber("Displacement Y", this.navigationSubsystem.getDisplacementY());
		SmartDashboard.putNumber("Velocity X", this.navigationSubsystem.getVelocityX());
		SmartDashboard.putNumber("Velocity Y", this.navigationSubsystem.getVelocityY());
		SmartDashboard.putNumber("Angle", this.navigationSubsystem.getAngle());
		SmartDashboard.putNumber("Compass Heading", this.navigationSubsystem.getCompassHeading());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true;
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

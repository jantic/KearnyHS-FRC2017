package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.HeadingSubsystem;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StreamHeadingOutput extends Command {
	private HeadingSubsystem headingSubystem;
	
	public StreamHeadingOutput() {
		requires(Robot.headingSubsystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		this.headingSubystem = Robot.headingSubsystem;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		SmartDashboard.putNumber("Angle", this.headingSubystem.getAngle());
		SmartDashboard.putNumber("Compass Heading", this.headingSubystem.getCompassHeading());
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

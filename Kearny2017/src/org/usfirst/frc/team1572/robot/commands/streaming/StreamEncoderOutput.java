package org.usfirst.frc.team1572.robot.commands.streaming;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.EncoderSubsystem;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StreamEncoderOutput extends Command {
	private final EncoderSubsystem encoderSubystem = Robot.encoderSubsystem;
	
	public StreamEncoderOutput() {
		requires(Robot.encoderSubsystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		//Do nothing
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		SmartDashboard.putNumber("Encoder Distance Driven", this.encoderSubystem.getDistanceDriven());
		SmartDashboard.putNumber("Encoder Scale", this.encoderSubystem.getScale());
	}
	
	public void streamToDashboard(){
		this.execute();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
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

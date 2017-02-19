package org.usfirst.frc.team1572.robot.commands.streaming;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.BaseJoyDriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StreamJoyDriveOutput extends Command {
	private final BaseJoyDriveSubsystem joyDriveSubystem= Robot.joydriveSubystem;
	
	public StreamJoyDriveOutput() {
		requires(Robot.joydriveSubystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		//do nothing;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		SmartDashboard.putString("Left Talon Drive Control Mode", this.joyDriveSubystem.getLeftDriveTrainControlMode().name());
		SmartDashboard.putString("Right Talon Drive Control Mode", this.joyDriveSubystem.getRightDriveTrainControlMode().name());
		SmartDashboard.putNumber("Left Drive Train Speed", this.joyDriveSubystem.getLeftDriveTrainSpeed());
		SmartDashboard.putNumber("Right Drive Train Speed", this.joyDriveSubystem.getRightDriveTrainSpeed());
		SmartDashboard.putNumber("Left Drive Encoder Position", this.joyDriveSubystem.getLeftDriveEncoderPosition());
		SmartDashboard.putNumber("Right Drive Encoder Position", this.joyDriveSubystem.getRightDriveEncoderPosition());
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

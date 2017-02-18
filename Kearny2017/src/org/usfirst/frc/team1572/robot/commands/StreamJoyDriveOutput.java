package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.BaseJoyDriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StreamJoyDriveOutput extends Command {
	private BaseJoyDriveSubsystem joyDrive;
	
	public StreamJoyDriveOutput() {
		requires(Robot.joydriveSubystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		this.joyDrive = Robot.joydriveSubystem;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		updateDisplay();
	}
	
	public void updateDisplay(){
		SmartDashboard.putString("Left Talon Drive Control Mode", this.joyDrive.getLeftDriveTrainControlMode().name());
		SmartDashboard.putString("Right Talon Drive Control Mode", this.joyDrive.getRightDriveTrainControlMode().name());
		SmartDashboard.putNumber("Left Drive Train Speed", this.joyDrive.getLeftDriveTrainSpeed());
		SmartDashboard.putNumber("Right Drive Train Speed", this.joyDrive.getRightDriveTrainSpeed());
		SmartDashboard.putNumber("Left Drive Encoder Position", this.joyDrive.getLeftDriveEncoderPosition());
		SmartDashboard.putNumber("Right Drive Encoder Position", this.joyDrive.getRightDriveEncoderPosition());
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

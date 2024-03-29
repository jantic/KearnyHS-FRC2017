package org.usfirst.frc.team1572.robot.commands.streaming;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.CameraSubsystem;
import org.usfirst.frc.team1572.robot.vision.CameraType;

import edu.wpi.first.wpilibj.command.Command;

public class StreamPegCamera extends Command {
	private final CameraSubsystem cameraSubsystem = Robot.cameraSubsystem;
	
	public StreamPegCamera() {
		requires(Robot.cameraSubsystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		//Do nothing
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		try {
			this.cameraSubsystem.streamToDashboard(CameraType.PEG_CAMERA);
		} catch (Exception e){
			System.out.println("Error while attempting to stream peg camera to dashboard:" + e.getMessage());
		}
	}
	
	public void streamToDashboard(){
		this.execute();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		//I think because execute will complete once before this is called, that I can always set this to true.  Maybe.
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

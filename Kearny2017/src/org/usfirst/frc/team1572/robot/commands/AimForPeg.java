package org.usfirst.frc.team1572.robot.commands;

import org.opencv.core.Mat;
import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.vision.CameraType;
import org.usfirst.frc.team1572.robot.vision.IAutoAim;
import org.usfirst.frc.team1572.robot.vision.ImageGrabFailedException;
import org.usfirst.frc.team1572.robot.vision.PegTargetAutoAim;
import org.usfirst.frc.team1572.robot.vision.VisionCenteringCommand;

import edu.wpi.first.wpilibj.command.Command;


public class AimForPeg extends Command {
	private final IAutoAim autoAim = new PegTargetAutoAim();
	private VisionCenteringCommand lastCenteringCommand = VisionCenteringCommand.NULL;

	public AimForPeg() {
		requires(Robot.joydrive);
		requires(Robot.cameraSubsystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		// nothing to do here
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		try{
			Robot.cameraSubsystem.activateCamera(CameraType.PEG_CAMERA);
			final Mat latestImage = Robot.cameraSubsystem.getLatestImage();
			final VisionCenteringCommand centeringCommand = this.autoAim.generateCenteringCommand(latestImage);
			// TODO: Put turning code here- this is where we ask Rich (the adult).
			// Because of the dynamic nature of the turning I don't think we can
			// make this a command group.
			// i.e. we might have to duplicate some turning code.
			this.lastCenteringCommand = centeringCommand;
		} catch (ImageGrabFailedException e) {
			System.out.println("Error while grabbing image auto aiming for peg:" + e.getMessage());
		} catch (Exception e){
			System.out.println("Error while auto aiming for peg:" + e.getMessage());
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return this.lastCenteringCommand.equals(VisionCenteringCommand.CENTER);
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

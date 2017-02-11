package org.usfirst.frc.team1572.robot.commands;



import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.opencv.core.Mat;
import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.vision.CameraType;
import org.usfirst.frc.team1572.robot.vision.IAutoAim;
import org.usfirst.frc.team1572.robot.vision.ImageGrabFailedException;
import org.usfirst.frc.team1572.robot.vision.VisionCenteringCommand;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public abstract class AimBase extends Command {
	private VisionCenteringCommand lastCenteringCommand = VisionCenteringCommand.NULL;
	private LocalDateTime startTime;
	private static long TIMEOUT = 5;

	public AimBase() {
		requires(Robot.joydrive);
		requires(Robot.cameraSubsystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		this.startTime = LocalDateTime.now();
	}

	protected final void alignRobotToTarget(final IAutoAim autoAim, final CameraType cameraType) {
		try{
			final Mat latestImage = Robot.cameraSubsystem.getLatestImage(cameraType);
			final VisionCenteringCommand centeringCommand = autoAim.generateCenteringCommand(latestImage);
			// TODO: Put turning code here- this is where we ask Rich (the adult).
			// Because of the dynamic nature of the turning I don't think we can
			// make this a command group.
			// i.e. we might have to duplicate some turning code.
			SmartDashboard.putString("Centering Command", centeringCommand.name());
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
		final LocalDateTime currentTime = LocalDateTime.now();
		
		final long elapsedSeconds = ChronoUnit.SECONDS.between(this.startTime, currentTime);
		
		if(elapsedSeconds > TIMEOUT){
			return true;
		}
		
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

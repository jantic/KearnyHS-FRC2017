package org.usfirst.frc.team1572.robot.commands.subtasks;


import org.opencv.core.Mat;
import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.BaseJoyDriveSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.CameraSubsystem;
import org.usfirst.frc.team1572.robot.vision.CameraType;
import org.usfirst.frc.team1572.robot.vision.IAutoAim;
import org.usfirst.frc.team1572.robot.vision.ImageGrabFailedException;
import org.usfirst.frc.team1572.robot.vision.VisionCenteringCommand;

import edu.wpi.first.wpilibj.command.TimedCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public abstract class AimBase extends TimedCommand {
	private final BaseJoyDriveSubsystem joyDriveSubsystem = Robot.joydriveSubystem;
	private final CameraSubsystem cameraSubsystem = Robot.cameraSubsystem;
	private double errorOffset;

	public AimBase() {
		super(1);
		requires(Robot.joydriveSubystem);
		requires(Robot.cameraSubsystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		//Do nothing
	}

	protected final void alignRobotToTarget(final IAutoAim autoAim, final CameraType cameraType) {
		try{
			final Mat latestImage = this.cameraSubsystem.getLatestImage(cameraType);
			final VisionCenteringCommand centeringCommand = autoAim.generateCenteringCommand(latestImage);
			executeTurn(centeringCommand);
			SmartDashboard.putString("Centering Command", centeringCommand.name());
		} 
		catch (ImageGrabFailedException e) {
			System.out.println("Error while grabbing image auto aiming for peg:" + e.getMessage());
		} 
		catch (Throwable e){
			System.out.println("Error while auto aiming for peg:" + e.getMessage());
		}
	}
	@SuppressWarnings("deprecation")
	protected final void alignRobotToTargetNotJason(final IAutoAim autoAim, final CameraType cameraType) {
		try{
			final Mat latestImage = this.cameraSubsystem.getLatestImage(cameraType);
			double error = autoAim.centerError(latestImage);
			executeTurnNotJason(error);
			SmartDashboard.putDouble("Centering Error", error);
		} 
		catch (ImageGrabFailedException e) {
			System.out.println("Error while grabbing image auto aiming for peg:" + e.getMessage());
		} 
		catch (Throwable e){
			System.out.println("Error while auto aiming for peg:" + e.getMessage());
		}
	}
	private void executeTurn(final VisionCenteringCommand centeringCommand){
		final double joystickX = generateJoystickX(centeringCommand);
		final double joystickY = 0.0;
		this.joyDriveSubsystem.arcadeDrive(joystickX, joystickY);
	}
	@SuppressWarnings("deprecation")
	private void executeTurnNotJason(final double error){
		final double p = 1/200d;
		final double maxTurnSpeed = 0.8;
		double joystickX;
		this.errorOffset = error + 10;//offset to right
		if(error > 10)
		{
			joystickX = p * this.errorOffset * maxTurnSpeed + 0.55;
		}
		else if(error < 10){
			joystickX = p * this.errorOffset * maxTurnSpeed - 0.55;
		}
		else{
			joystickX = 0;
		}
		final double joystickY = 0.2;
		if(error == -10000){//null
			joystickX = 0;
		}
		SmartDashboard.putDouble("vision turn speed", joystickX);
		this.joyDriveSubsystem.arcadeDrive(joystickX, joystickY);
	}
	private double generateJoystickX(final VisionCenteringCommand centeringCommand){
		switch(centeringCommand){
			case RIGHT:
				return -Robot.TURNING_SPEED;
			case LEFT:
				return Robot.TURNING_SPEED;
			default:
				return 0;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		//if(this.lastCenteringCommand.equals(VisionCenteringCommand.CENTER)){
			//return true;
		//}
		if(this.errorOffset <= 10 && this.errorOffset >= -10){
			return true;
		}
		return super.isFinished();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		this.joyDriveSubsystem.arcadeDrive(0, 0);
	}
}

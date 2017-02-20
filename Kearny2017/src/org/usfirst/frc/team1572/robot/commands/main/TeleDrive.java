package org.usfirst.frc.team1572.robot.commands.main;

import org.usfirst.frc.team1572.robot.JoystickController;
import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.BaseJoyDriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleDrive extends Command {
	private static final double ACTIVATION_THRESHOLD = 0.1;
	private final JoystickController mainJoystick = JoystickController.MAIN_JOYSTICK;
	private final JoystickController coPilotJoystick = JoystickController.COPILOT_JOYSTICK;
	private final BaseJoyDriveSubsystem joyDriveSubsystem = Robot.joydriveSubystem;

	public TeleDrive() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.joydriveSubystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		// Do nothing
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {

		if (isCoPilotJoystickEngaged()) {
			driveWithCoPilot();
		} else if (isOverdriveActivated()) {
			driveWithOverridrive();
		} else {
			defaultDrive();
		}
	}

	private void defaultDrive() {
		this.joyDriveSubsystem.getRobotDrive().arcadeDrive(-this.mainJoystick.getLeftStickY(),
				-this.mainJoystick.getLeftStickX() * 0.75);
	}

	private void driveWithOverridrive() {
		this.joyDriveSubsystem.getRobotDrive().arcadeDrive(-this.mainJoystick.getLeftStickY(),
				-this.mainJoystick.getLeftStickX());
	}

	private void driveWithCoPilot() {
		this.joyDriveSubsystem.getRobotDrive().arcadeDrive(-this.coPilotJoystick.getLeftStickY() * 0.75,
				-this.coPilotJoystick.getLeftStickX() * 0.5);
	}

	private boolean isCoPilotJoystickEngaged() {
		return this.coPilotJoystick.getLeftStickX() < -ACTIVATION_THRESHOLD || this.coPilotJoystick.getLeftStickX() > ACTIVATION_THRESHOLD
				|| this.coPilotJoystick.getLeftStickY() < -ACTIVATION_THRESHOLD || this.coPilotJoystick.getLeftStickY() > ACTIVATION_THRESHOLD;
	}

	private boolean isOverdriveActivated() {
		return this.mainJoystick.getRightTrigger() > ACTIVATION_THRESHOLD;
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		this.joyDriveSubsystem.arcadeDrive(0,0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		this.joyDriveSubsystem.arcadeDrive(0,0);
	}
}

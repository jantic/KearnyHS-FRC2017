package org.usfirst.frc.team1572.robot.commands.main;

import org.usfirst.frc.team1572.robot.JoystickButtonMap;
import org.usfirst.frc.team1572.robot.JoystickController;
import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.BaseJoyDriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;


public class TeleDrive extends Command {
	private static final double ACTIVATION_THRESHOLD = 0.1;
	private final JoystickController mainJoystick = JoystickController.MAIN_JOYSTICK;
	private final JoystickController coPilotJoystick = JoystickController.COPILOT_JOYSTICK;
	private final BaseJoyDriveSubsystem joyDriveSubsystem = Robot.joydriveSubystem;

	public TeleDrive() {
		requires(Robot.joydriveSubystem);
	}

	@Override
	protected void initialize() {
		// Do nothing
	}

	@Override
	protected void execute() {

		if (isCoPilotJoystickEngaged()) {
			driveWithCoPilot();
		}
		else if (isCoPilotOverdriveEngaged()) {
			driveWithCoPilotOverdrive();
		}
		else if (isOverdriveActivated()) {
			driveWithOverridrive();
		} 
		else {
			defaultDrive();
		}
	}

	private void defaultDrive() {
		this.joyDriveSubsystem.getRobotDrive().arcadeDrive(-this.mainJoystick.getLeftStickY() * 0.75,
				-this.mainJoystick.getLeftStickX());
	}

	private void driveWithOverridrive() {
		this.joyDriveSubsystem.getRobotDrive().arcadeDrive(-this.mainJoystick.getLeftStickY(),
				-this.mainJoystick.getLeftStickX());
	}

	private void driveWithCoPilot() {
		this.joyDriveSubsystem.getRobotDrive().arcadeDrive(-this.coPilotJoystick.getLeftStickY() * 0.65,
				-this.coPilotJoystick.getLeftStickX() * 0.75);
	}
	
	private void driveWithCoPilotOverdrive() {
		this.joyDriveSubsystem.getRobotDrive().arcadeDrive(-this.coPilotJoystick.getLeftStickY() * 0.9,
				-this.coPilotJoystick.getLeftStickX() * 0.9);
	}

	private boolean isCoPilotJoystickEngaged() {
		return this.coPilotJoystick.getLeftStickX() < -ACTIVATION_THRESHOLD || this.coPilotJoystick.getLeftStickX() > ACTIVATION_THRESHOLD
				|| this.coPilotJoystick.getLeftStickY() < -ACTIVATION_THRESHOLD || this.coPilotJoystick.getLeftStickY() > ACTIVATION_THRESHOLD;
	}
	
	private boolean isCoPilotOverdriveEngaged() {
		if(JoystickButtonMap.seven != null){
			return true;
		}
		return false;
	}

	private boolean isOverdriveActivated() {
		return this.mainJoystick.getRightTrigger() > ACTIVATION_THRESHOLD;
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		this.joyDriveSubsystem.arcadeDrive(0,0);
	}

}

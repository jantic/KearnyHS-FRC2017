package org.usfirst.frc.team1572.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team1572.robot.RobotMap;
import org.usfirst.frc.team1572.robot.commands.StreamJoyDriveOutput;
import org.usfirst.frc.team1572.robot.utls.LogitechF310Map;

import com.ctre.CANTalon.TalonControlMode;

public abstract class BaseJoyDrive extends Subsystem {
	private final RobotDrive robotDrive = RobotMap.robotDrive;
	private final LogitechF310Map joyMap = new LogitechF310Map();
	
	public abstract void arcadeDrive(Joystick stick);
	
	public abstract void arcadeDrive(final double joystickX, final double joystickY);
	
    @Override
	public final void initDefaultCommand() {
        setDefaultCommand(new StreamJoyDriveOutput());
    }
    
	protected final RobotDrive getRobotDrive(){
		return this.robotDrive;
	}
	
	protected final LogitechF310Map getJoyMap() {
		return this.joyMap;
	}

	protected final void updateDisplay() {
		final StreamJoyDriveOutput streamJoyDriveOutput = new StreamJoyDriveOutput();
		streamJoyDriveOutput.updateDisplay();
	}
	
	public final void stop() {
		this.getRobotDrive().drive(0, 0);
	}
    
	protected abstract SpeedController getLeftSpeedController();
	
	protected abstract SpeedController getRightSpeedController();

	public abstract double getLeftDriveTrainSpeed();
	
	public abstract double getRightDriveTrainSpeed();

	public abstract int getLeftDriveEncoderPosition();
	
	public abstract int getRightDriveEncoderPosition();
	
	public abstract TalonControlMode getLeftDriveTrainControlMode();
	
	public abstract TalonControlMode getRightDriveTrainControlMode();

}


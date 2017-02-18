package org.usfirst.frc.team1572.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;

public class VelocityTalonDriveSubsystem extends BaseTalonDriveSubsystem {
    @Override
	public void arcadeDrive(Joystick stick) {
    	arcadeDrive(getJoyMap().getLeftXAxis(stick), getJoyMap().getLeftYAxis(stick));
	}
    
	@Override
	public void arcadeDrive(final double joystickX, final double joystickY) {
		final double maxRPM = getMaxRpm();
		final double leftMotor  = joystickX - joystickY;
		final double rightMotor = joystickX + joystickY;
		getLeftSpeedController().set(leftMotor*maxRPM);
		getRightSpeedController().set(rightMotor*maxRPM);
		updateDisplay();	
	}
    
	private double getMaxRpm() {
		return 75;
	}
}


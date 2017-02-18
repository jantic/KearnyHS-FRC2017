package org.usfirst.frc.team1572.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;

public class VoltageTalonDriveSubsystem extends BaseTalonDriveSubsystem {
    @Override
	public void arcadeDrive(Joystick stick) {
		arcadeDrive(getJoyMap().getLeftXAxis(stick), getJoyMap().getLeftYAxis(stick));
	}
    
	@Override
	public void arcadeDrive(final double joystickX, final double joystickY) {
		final double speedFactor = getSpeedFactor();
		getRobotDrive().arcadeDrive(joystickY * speedFactor, joystickX * speedFactor);
		updateDisplay();	
	}

	private double getSpeedFactor() {
		return 0.75;
	}
}


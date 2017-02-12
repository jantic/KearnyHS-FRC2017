package org.usfirst.frc.team1572.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team1572.robot.Robot;

public class VoltageTalonDrive extends BaseTalonDrive {
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
		double speedFactor;
		
		if(Robot.teledrive.coPilotDrive()) {
			speedFactor = 0.25;
		}
		else if(Robot.teledrive.overdrive()) {
			speedFactor = 1;
		}
		else {
			speedFactor = 0.75;
		}
		return speedFactor;
	}
}


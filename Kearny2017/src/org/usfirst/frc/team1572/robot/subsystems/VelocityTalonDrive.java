package org.usfirst.frc.team1572.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team1572.robot.Robot;

public class VelocityTalonDrive extends BaseTalonDrive {
    @Override
	public void arcadeDrive(Joystick stick) {
    	arcadeDrive(getJoyMap().getLeftXAxis(stick), getJoyMap().getLeftYAxis(stick));
	}
    
	@Override
	public void arcadeDrive(final double joystickX, final double joystickY) {
		final double maxRPM = getMaxRpm();
		final double leftMotor  = joystickY - joystickX;
		final double rightMotor = joystickY + joystickX;
		getLeftSpeedController().set(leftMotor*maxRPM);
		getRightSpeedController().set(rightMotor*maxRPM);
		updateDisplay();	
	}
    
	private double getMaxRpm() {
		double maxRPM;

		if(Robot.teledrive.coPilotDrive()){
			maxRPM = 25;
		}
		else if(Robot.teledrive.overdrive()) {
			maxRPM = 100;
		}
		else{
			maxRPM = 75;
		}
		return maxRPM;
	}
}


package org.usfirst.frc.team1572.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import org.usfirst.frc.team1572.robot.RobotMap;
import com.ctre.CANTalon.TalonControlMode;

public class VictorJoyDrive extends BaseJoyDrive {
	private final Victor leftDrive = RobotMap.victorLeftDriveTrain;
	private final Victor rightDrive = RobotMap.victorRightDriveTrain;
	
    @Override
	public void arcadeDrive(Joystick stick) {
    	arcadeDrive(getJoyMap().getLeftYAxis(stick), getJoyMap().getLeftXAxis(stick));
		updateDisplay();
	}
    
	@Override
	public void arcadeDrive(double joystickX, double joystickY) {
	   	getRobotDrive().arcadeDrive(joystickX, -joystickY);
	   	updateDisplay();	
	}

    @Override
	protected SpeedController getLeftSpeedController(){
    	return this.leftDrive;
    }
	
    @Override
    protected SpeedController getRightSpeedController(){
		return this.rightDrive;
	}

	@Override
	public double getLeftDriveTrainSpeed(){
		return this.leftDrive.getSpeed();
	}
	
	@Override
	public double getRightDriveTrainSpeed(){
		return this.rightDrive.getSpeed();
	}

	@Override
	public int getLeftDriveEncoderPosition(){
		return 0;
	}
	
	@Override
	public int getRightDriveEncoderPosition(){
		return 0;
	}
	
	@Override
	public TalonControlMode getLeftDriveTrainControlMode(){
		return TalonControlMode.Disabled;
	}
	
	@Override
	public TalonControlMode getRightDriveTrainControlMode(){
		return TalonControlMode.Disabled;
	}
}


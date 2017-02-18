package org.usfirst.frc.team1572.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;

import org.usfirst.frc.team1572.robot.RobotMap;
import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

public abstract class BaseTalonDriveSubsystem extends BaseJoyDriveSubsystem {
	private final CANTalon leftDrive = RobotMap.talonLeftDrivetrain;
	private final CANTalon rightDrive = RobotMap.talonRightDrivetrain;
	
	@Override
	public final double getLeftDriveTrainSpeed(){
		return this.leftDrive.getSpeed();
	}
	
	@Override
	public final double getRightDriveTrainSpeed(){
		return this.rightDrive.getSpeed();
	}

	@Override
	public final int getLeftDriveEncoderPosition(){
		return this.leftDrive.getEncPosition();
	}
	
	@Override
	public final int getRightDriveEncoderPosition(){
		return this.rightDrive.getEncPosition();
	}
	
	@Override
	public final TalonControlMode getLeftDriveTrainControlMode(){
		return this.leftDrive.getControlMode();
	}
	
	@Override
	public final TalonControlMode getRightDriveTrainControlMode(){
		return this.rightDrive.getControlMode();
	}
	
	@Override
	protected final SpeedController getLeftSpeedController() {
		return this.leftDrive;
	}

	@Override
	protected final SpeedController getRightSpeedController() {
		return this.rightDrive;
	}

}


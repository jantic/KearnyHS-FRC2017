package org.usfirst.frc.team1572.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.RobotMap;
import org.usfirst.frc.team1572.robot.commands.StreamJoyDriveOutput;
import org.usfirst.frc.team1572.robot.utls.LogitechF310Map;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

public class JoyDrive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private double maxRPM;
	private double speedFactor;
	private final RobotDrive robotDrive = RobotMap.robotDrive;
	private final CANTalon leftDrive = RobotMap.leftDrivetrain;
	private final CANTalon rightDrive = RobotMap.rightDrivetrain;
	private final LogitechF310Map joyMap = new LogitechF310Map();


    @Override
	public void initDefaultCommand() {
        setDefaultCommand(new StreamJoyDriveOutput());
    }
    
	public void arcadeDriveVoltage(Joystick stick) {
		if(Robot.teledrive.coPilotDrive()) {
			speedFactor = 0.25;
		}
		else if(Robot.teledrive.overdrive()) {
			speedFactor = 1;
		}
		else {
			speedFactor = 0.75;
		}
		robotDrive.arcadeDrive(joyMap.getLeftYAxis(stick) * speedFactor,joyMap.getLeftXAxis(stick) * speedFactor);
	}
    
    public void arcadeDriveVelocity(Joystick stick) {
		double leftMotor = 0.0;
		double rightMotor = 0.0; 
		//robotDrive.arcadeDrive(targetRPM, joyMap.getLeftXAxis(stick))
		if(Robot.teledrive.coPilotDrive()){
			maxRPM = 25;
		}
		else if(Robot.teledrive.overdrive()) {
			maxRPM = 100;
		}
		else{
			maxRPM = 75;
		}

		leftMotor  = joyMap.getLeftYAxis(stick) - joyMap.getLeftXAxis(stick);
		rightMotor = joyMap.getLeftYAxis(stick) + joyMap.getLeftXAxis(stick);

		leftDrive.set(leftMotor*maxRPM);
		rightDrive.set(rightMotor*maxRPM);
		System.out.println(leftDrive.getControlMode().name());
		System.out.println(rightDrive.getControlMode().name());

		
		updateDisplay();


	}


	private void updateDisplay() {
		final StreamJoyDriveOutput streamJoyDriveOutput = new StreamJoyDriveOutput();
		streamJoyDriveOutput.updateDisplay();

	}
	
	public double getLeftDriveTrainSpeed(){
		return this.leftDrive.getSpeed();
	}
	
	public double getRightDriveTrainSpeed(){
		return this.rightDrive.getSpeed();
	}
	
	public int getLeftDriveEncoderPosition(){
		return this.leftDrive.getEncPosition();
	}
	
	public int getRightDriveEncoderPosition(){
		return this.rightDrive.getEncPosition();
	}
	
	public TalonControlMode getLeftDriveTrainControlMode(){
		return this.leftDrive.getControlMode();
	}
	
	public TalonControlMode getRightDriveTrainControlMode(){
		return this.rightDrive.getControlMode();
	}
	
	public void stop() {
		this.robotDrive.drive(0, 0);
	}

}


package org.usfirst.frc.team1572.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1572.robot.RobotMap;
import org.usfirst.frc.team1572.robot.utls.LogitechF310Map;

import com.ctre.CANTalon;

public class JoyDrive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private final double maxRPM = 100.00;
	private final RobotDrive robotDrive = RobotMap.robotDrive;
	private final CANTalon leftDrive = RobotMap.leftDrivetrain;
	private final CANTalon rightDrive = RobotMap.rightDrivetrain;
	private final LogitechF310Map joyMap = new LogitechF310Map();

    @Override
	public void initDefaultCommand() {
  
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//leftDrive.getPostion;
    	//leftDrive.getSpeed()
    	//leftDrive.setPosition(0);
    }
    
	public void arcadeDrive(Joystick stick) {
		double leftMotor = 0.0;
		double rightMotor = 0.0; 
		//robotDrive.arcadeDrive(targetRPM, joyMap.getLeftXAxis(stick))
		
		leftMotor  = this.joyMap.getLeftYAxis(stick) - this.joyMap.getLeftXAxis(stick);
		rightMotor = this.joyMap.getLeftYAxis(stick) + this.joyMap.getLeftXAxis(stick);
		this.leftDrive.set(leftMotor*this.maxRPM);
		this.rightDrive.set(rightMotor*this.maxRPM);
		System.out.println(this.leftDrive.getControlMode().name());
		System.out.println(this.rightDrive.getControlMode().name());
		
		System.out.println(leftMotor*this.maxRPM);
		System.out.println(rightMotor*this.maxRPM);
		System.out.println();
	}
	
	public void stop() {
		this.robotDrive.drive(0, 0);
	}
	
	  
}


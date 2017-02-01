package org.usfirst.frc.team1572.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1572.robot.RobotMap;
import org.usfirst.frc.team1572.robot.utls.LogitechF310Map;

import java.util.Scanner;
import com.ctre.CANTalon;
/**
 *
 */
public class JoyDrive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	double maxRPM = 100.00;
  	RobotDrive robotDrive = RobotMap.robotDrive;
	CANTalon leftDrive = RobotMap.leftDrivetrain;
	CANTalon rightDrive = RobotMap.rightDrivetrain;
	public LogitechF310Map joyMap = new LogitechF310Map();

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
		
		leftMotor  = joyMap.getLeftYAxis(stick) - joyMap.getLeftXAxis(stick);
		rightMotor = joyMap.getLeftYAxis(stick) + joyMap.getLeftXAxis(stick);
		leftDrive.set(leftMotor*maxRPM);
		rightDrive.set(rightMotor*maxRPM);
		System.out.println(leftDrive.getControlMode().name());
		System.out.println(rightDrive.getControlMode().name());
		
		System.out.println(leftMotor*maxRPM);
		System.out.println(rightMotor*maxRPM);
		System.out.println();
	}
	
	public void stop() {
		robotDrive.drive(0, 0);
	}
	
	  
}


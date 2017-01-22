package org.usfirst.frc.team1572.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1572.robot.RobotMap;
import java.util.Scanner;
import com.ctre.CANTalon;
/**
 *
 */
public class JoyDrive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
  	RobotDrive robotDrive = RobotMap.robotDrive;
	CANTalon leftDrive = RobotMap.leftDrivetrain;
	CANTalon rightDrive = RobotMap.rightDrivetrain;

    public void initDefaultCommand() {
  
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	public void arcadeDrive(Joystick stick) {
		robotDrive.arcadeDrive(stick);
	}
	
	public void stop() {
		robotDrive.drive(0, 0);
	}
	  
}


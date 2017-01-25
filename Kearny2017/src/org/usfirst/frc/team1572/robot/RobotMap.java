package org.usfirst.frc.team1572.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import com.ctre.CANTalon.TalonControlMode;
import java.util.Scanner;
import com.ctre.CANTalon;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static int leftDrivetrainPort = 1;
	public static int rightDrivetrainPort = 2;
	public static int leftDriveSlave1Port = 3;
	public static int leftDriveSlave2Port = 4;
	public static int rightDriveSlave1Port = 5;
	public static int rightDriveSlave2Port = 6;
	
	
	
	public static CANTalon leftDrivetrain;
	public static CANTalon rightDrivetrain;
	public static RobotDrive robotDrive;
	public static CANTalon leftDriveSlave1;
	public static CANTalon leftDriveSlave2;
	public static CANTalon rightDriveSlave1;
	public static CANTalon rightDriveSlave2;
	
	public static void init() {
		leftDrivetrain = new CANTalon(leftDrivetrainPort);
		rightDrivetrain = new CANTalon(rightDrivetrainPort);
		robotDrive = new RobotDrive(leftDrivetrain, rightDrivetrain);
		leftDriveSlave1 = new CANTalon(leftDriveSlave1Port);
		leftDriveSlave2 = new CANTalon(leftDriveSlave2Port);
		rightDriveSlave1 = new CANTalon(rightDriveSlave1Port);
		rightDriveSlave2 = new CANTalon(rightDriveSlave2Port);
		leftDriveSlave1.changeControlMode(TalonControlMode.Follower);
		leftDriveSlave1.set(leftDrivetrainPort);
		leftDriveSlave2.changeControlMode(TalonControlMode.Follower);
		leftDriveSlave2.set(leftDrivetrainPort);
		rightDriveSlave1.changeControlMode(TalonControlMode.Follower);
		rightDriveSlave1.set(rightDrivetrainPort);
		rightDriveSlave2.changeControlMode(TalonControlMode.Follower);
		rightDriveSlave2.set(rightDrivetrainPort);
	}
	 
	// [IMPORTANT!]: Use ChipotleArm as variable
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}

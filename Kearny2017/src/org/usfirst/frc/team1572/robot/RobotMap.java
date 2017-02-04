package org.usfirst.frc.team1572.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import java.util.Scanner;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Ultrasonic;
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
	public static int liftPort = 7;
	
	
	public static CANTalon leftDrivetrain;
	public static CANTalon rightDrivetrain;
	public static RobotDrive robotDrive;
	public static CANTalon leftDriveSlave1;
	public static CANTalon leftDriveSlave2;
	public static CANTalon rightDriveSlave1;
	public static CANTalon rightDriveSlave2;
	public static DoubleSolenoid clawHand;
	public static DoubleSolenoid rightArm;
	public static DoubleSolenoid leftArm;
	public static Victor lift;
	public static Victor clawIntake;
	public static Victor ballHopper;
	public static CANTalon shooter;
	
	public static Ultrasonic sensor;
	public static Compressor compressor; 
	
	public static void init() {
		leftDrivetrain = new CANTalon(leftDrivetrainPort);
		leftDrivetrain.reverseOutput(true);
		leftDrivetrain.reverseSensor(true);
		leftDrivetrain.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		leftDrivetrain.configEncoderCodesPerRev(1440);
		leftDrivetrain.changeControlMode(TalonControlMode.Speed);
		leftDrivetrain.configNominalOutputVoltage(0, 0);
		leftDrivetrain.configPeakOutputVoltage(12.0, -12.0);
		leftDrivetrain.setProfile(0);
		leftDrivetrain.setF(0.5);
		leftDrivetrain.setP(0.01);
		leftDrivetrain.setI(0);
		leftDrivetrain.setD(0);
		leftDrivetrain.set(0);
		
		rightDrivetrain = new CANTalon(rightDrivetrainPort);
		rightDrivetrain.reverseOutput(false);
		rightDrivetrain.reverseSensor(false);
		rightDrivetrain.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		rightDrivetrain.configEncoderCodesPerRev(1440);
		rightDrivetrain.changeControlMode(TalonControlMode.Speed);
		rightDrivetrain.configNominalOutputVoltage(0, 0);
		rightDrivetrain.configPeakOutputVoltage(12.0, -12.0);
		rightDrivetrain.setProfile(0);
		rightDrivetrain.setF(0.5);
		rightDrivetrain.setP(0.01);
		rightDrivetrain.setI(0);
		rightDrivetrain.setD(0);
		rightDrivetrain.set(0);
		
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
		
		shooter = new CANTalon(10);
		// may need to set up ports?
		compressor = new Compressor(0);
		
		clawHand = new DoubleSolenoid(0,1);
		clawHand.set(DoubleSolenoid.Value.kOff);
		rightArm = new DoubleSolenoid(2,3);
		rightArm.set(DoubleSolenoid.Value.kOff);
		leftArm = new DoubleSolenoid(4,5);
		leftArm.set(DoubleSolenoid.Value.kOff);
		
		lift = new Victor(7);
		clawIntake = new Victor(8);
		ballHopper = new Victor(9);
		//sensor = new Ultrasonic(pingChannel, echoChannel);
		sensor = new Ultrasonic(0,1);
		
		// FIX THIS SO AGUREMNTS MAKES SENSE
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

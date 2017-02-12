package org.usfirst.frc.team1572.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Ultrasonic;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static int compressorPort = 0;
	public static int talonLeftDrivetrainPort = 1;
	public static int talonRightDrivetrainPort = 2;
	public static int leftDriveSlave1Port = 3;
	public static int leftDriveSlave2Port = 4;
	public static int rightDriveSlave1Port = 5;
	public static int rightDriveSlave2Port = 6;
	public static int shooterPort = 7;
	public static int victorLeftDrivetrainPort = 8;
	public static int victorRightDrivetrainPort = 9;
	public static int eCPRPort = 1440;
	public static int liftPort = 1;
	public static int ballHopperPort = 2;
	public static int clawIntakePort = 3;
	public static int clawHandPort1 = 2;
	public static int clawHandPort = 3;
	public static int rightArmPort1 = 0;
	public static int rightArmPort = 1;
	public static int sensorPort1 = 0;
	public static int sensorPort = 1;
	
	public static Victor victorLeftDriveTrain;
	public static Victor victorRightDriveTrain;
	
	public static CANTalon talonLeftDrivetrain;
	public static CANTalon talonRightDrivetrain;
	public static RobotDrive robotDrive;
	public static CANTalon leftDriveSlave1;
	public static CANTalon leftDriveSlave2;
	public static CANTalon rightDriveSlave1;
	public static CANTalon rightDriveSlave2;
	public static DoubleSolenoid clawHand;
	public static DoubleSolenoid Arm;
	public static Victor lift;
	public static Victor clawIntake;
	public static Victor ballHopper;
	public static CANTalon shooter;
	public static Ultrasonic sensor;
	public static Compressor compressor; 
	
	public static void init() {
		if(Robot.driveType.isTalonDrive()){
			initTalonDrive(Robot.driveType);
		}
		else{
			initVictorDrive();
		}
		
	
		shooter = new CANTalon(shooterPort);
		compressor = new Compressor(compressorPort);	
		clawHand = new DoubleSolenoid(clawHandPort1,clawHandPort);
		clawHand.set(DoubleSolenoid.Value.kOff);
		Arm = new DoubleSolenoid(rightArmPort1,rightArmPort);
		Arm.set(DoubleSolenoid.Value.kOff);		
		lift = new Victor(liftPort);
		ballHopper = new Victor(ballHopperPort);
		clawIntake = new Victor(clawIntakePort);
		
		//sensor = new Ultrasonic(pingChannel, echoChannel);
		// FIX THIS SO AGUREMNTS MAKES SENSE
		sensor = new Ultrasonic(sensorPort1,sensorPort);
	}

	private static void initVictorDrive() {
		victorLeftDriveTrain = new Victor(victorLeftDrivetrainPort);
		victorRightDriveTrain = new Victor(victorRightDrivetrainPort);
		robotDrive = new RobotDrive(victorLeftDriveTrain, victorRightDriveTrain);
	}

	private static void initTalonDrive(final DriveType driveType) {
		talonLeftDrivetrain = new CANTalon(talonLeftDrivetrainPort);
		talonLeftDrivetrain.reverseOutput(true);
		talonRightDrivetrain = new CANTalon(talonRightDrivetrainPort);
		talonRightDrivetrain.reverseOutput(false);
		
		if (driveType.equals(DriveType.TALON_VELOCITY)) {
			talonLeftDrivetrain.setFeedbackDevice(FeedbackDevice.QuadEncoder);
			talonLeftDrivetrain.configEncoderCodesPerRev(eCPRPort);
			talonLeftDrivetrain.changeControlMode(TalonControlMode.Speed);
			talonLeftDrivetrain.configNominalOutputVoltage(0, 0);
			talonLeftDrivetrain.reverseSensor(true);
			talonLeftDrivetrain.configPeakOutputVoltage(12.0, -12.0);
			talonLeftDrivetrain.setProfile(0);
			talonLeftDrivetrain.setF(0.5);
			talonLeftDrivetrain.setP(0.01);
			talonLeftDrivetrain.setI(0);
			talonLeftDrivetrain.setD(0);
			talonLeftDrivetrain.set(0);
			talonRightDrivetrain.reverseSensor(false);
			talonRightDrivetrain.setFeedbackDevice(FeedbackDevice.QuadEncoder);
			talonRightDrivetrain.configEncoderCodesPerRev(eCPRPort);
			talonRightDrivetrain.changeControlMode(TalonControlMode.Speed);
			talonRightDrivetrain.configNominalOutputVoltage(0, 0);
			talonRightDrivetrain.configPeakOutputVoltage(12.0, -12.0);
			talonRightDrivetrain.setProfile(0);
			talonRightDrivetrain.setF(0.5);
			talonRightDrivetrain.setP(0.01);
			talonRightDrivetrain.setI(0);
			talonRightDrivetrain.setD(0);
			talonRightDrivetrain.set(0);
		}
		else {
			talonLeftDrivetrain.changeControlMode(TalonControlMode.Voltage);
			talonRightDrivetrain.changeControlMode(TalonControlMode.Voltage);
		}
		
		robotDrive = new RobotDrive(talonLeftDrivetrain, talonRightDrivetrain);
		leftDriveSlave1 = new CANTalon(leftDriveSlave1Port);
		leftDriveSlave2 = new CANTalon(leftDriveSlave2Port);
		rightDriveSlave1 = new CANTalon(rightDriveSlave1Port);
		rightDriveSlave2 = new CANTalon(rightDriveSlave2Port);
		leftDriveSlave1.changeControlMode(TalonControlMode.Follower);
		leftDriveSlave1.set(talonLeftDrivetrainPort);
		leftDriveSlave2.changeControlMode(TalonControlMode.Follower);
		leftDriveSlave2.set(talonLeftDrivetrainPort);
		rightDriveSlave1.changeControlMode(TalonControlMode.Follower);
		rightDriveSlave1.set(talonRightDrivetrainPort);
		rightDriveSlave2.changeControlMode(TalonControlMode.Follower);
		rightDriveSlave2.set(talonRightDrivetrainPort);
	}
}

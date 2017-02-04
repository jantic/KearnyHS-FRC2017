
package org.usfirst.frc.team1572.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1572.robot.utls.LogitechF310Map;
import org.usfirst.frc.team1572.robot.commands.DriveDistance;
import org.usfirst.frc.team1572.robot.commands.LeftGear;
import org.usfirst.frc.team1572.robot.commands.MidGear;
import org.usfirst.frc.team1572.robot.commands.RightGear;
import org.usfirst.frc.team1572.robot.commands.TeleDrive;
import org.usfirst.frc.team1572.robot.subsystems.BallHopper;
import org.usfirst.frc.team1572.robot.subsystems.ChipotleArm;
import org.usfirst.frc.team1572.robot.subsystems.ClawHand;
import org.usfirst.frc.team1572.robot.subsystems.ClawIntake;
import org.usfirst.frc.team1572.robot.subsystems.JoyDrive;
import org.usfirst.frc.team1572.robot.subsystems.Lift;
import org.usfirst.frc.team1572.robot.subsystems.Sensor;
import org.usfirst.frc.team1572.robot.subsystems.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static JoyDrive joydrive;
	public static TeleDrive teledrive;
	public static DriveDistance drivedistance;
	public static ClawHand clawhand;
	public static ChipotleArm chipotlearm;
	public static LogitechF310Map logitechF310Map;
	public static Sensor sensor;
	public static Lift lifter;
	public static Shooter shooter;
	public static LeftGear leftgear;
	public static MidGear midgear;
	public static RightGear rightgear;
	
	boolean buttonValue = SmartDashboard.getBoolean("MidGear", true);
	boolean buttonValue2 = SmartDashboard.getBoolean("MidGear", true);
	boolean buttonValue3 = SmartDashboard.getBoolean("MidGear", true);
	
	 double dashData = SmartDashboard.getNumber("DB/Slider 0", 0.0);
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		 joydrive = new JoyDrive();
		 clawhand = new ClawHand();
		 chipotlearm = new ChipotleArm();
		 shooter = new Shooter();
		 lifter = new Lift();
		 teledrive = new TeleDrive();
		 leftgear = new LeftGear();
		 rightgear = new RightGear();
		 midgear = new MidGear();
		SmartDashboard.putBoolean("MidGear", false);
		SmartDashboard.putBoolean("LeftGear", false);
		SmartDashboard.putBoolean("RightGear", false);

		 //drivedistance = new DriveDistance(dist);
		 //Does not take varible dist, may need to put 0 to define
		oi = new OI();
		oi.init();
		SmartDashboard.putData("Auto mode", chooser);
		
	  	ClawHand.claw.set(DoubleSolenoid.Value.kOff);
    	ChipotleArm.rightArm.set(DoubleSolenoid.Value.kOff);
    	ChipotleArm.leftArm.set(DoubleSolenoid.Value.kOff);
    	sensor = new Sensor();
		
		 
		 
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		if(buttonValue == true) {
			
		Scheduler.getInstance().add(midgear);
		
		}
		if(buttonValue2 == true) {
			
		Scheduler.getInstance().add(leftgear);
		
		}
		if(buttonValue3 == true) {
			
		Scheduler.getInstance().add(rightgear);
		
		}
		Scheduler.getInstance().run();
		//we need to add smartDashboard buttons or something like that for auto
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		
  
		Scheduler.getInstance().add(teledrive);
		System.out.println("after add");
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
	
		ClawHand.openClaw();
		ClawHand.closeClaw();
		ClawIntake.clawIntake();
		ChipotleArm.lowerArm();
		ChipotleArm.raiseArm();
		Lift.Lifter();
		BallHopper.ballIntake();
		Shooter.shoot();

		Scheduler.getInstance().run();
		
		System.out.println(RobotMap.leftDrivetrain.getSpeed() + " left rpm");
		System.out.println(RobotMap.rightDrivetrain.getSpeed() + " right rpm");
		System.out.println(RobotMap.rightDrivetrain.getEncPosition() + " RightEncPos");
		System.out.println(RobotMap.leftDrivetrain.getEncPosition() + " leftEncPos");
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
/*
 * 
logitechF310Map.getButtonA();
logitechF310Map.getButtonB();
logitechF310Map.getButtonBack();
logitechF310Map.getButtonL3();
logitechF310Map.getButtonLB();
logitechF310Map.getButtonR3();
logitechF310Map.getButtonRB();
logitechF310Map.getButtonStart();
logitechF310Map.getButtonX();
logitechF310Map.getButtonY();
logitechF310Map.getLeftTrigger();
logitechF310Map.getLeftXAxis();
logitechF310Map.getLeftYAxis();
logitechF310Map.getRightTrigger();
logitechF310Map.getRightXAxis();
logitechF310Map.getRightYAxis();
//logitechF310Map.getPOV();
 */
//Scheduler.getInstance().add(drivedistance);

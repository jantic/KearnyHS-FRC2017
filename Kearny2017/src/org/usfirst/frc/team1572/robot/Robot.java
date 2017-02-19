
package org.usfirst.frc.team1572.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1572.robot.utls.LogitechF310Map;

import org.usfirst.frc.team1572.robot.commands.AimForGearAutonomously;
import org.usfirst.frc.team1572.robot.commands.AimForGearManually;
import org.usfirst.frc.team1572.robot.commands.AimForPegAutonomously;
import org.usfirst.frc.team1572.robot.commands.AimForPegManually;
import org.usfirst.frc.team1572.robot.commands.ArmToggle;
import org.usfirst.frc.team1572.robot.commands.AutonomousCommand;
import org.usfirst.frc.team1572.robot.commands.ClawToggle;
import org.usfirst.frc.team1572.robot.commands.GearGrab;
import org.usfirst.frc.team1572.robot.commands.ReleaseGear;
import org.usfirst.frc.team1572.robot.commands.TeleDrive;
import org.usfirst.frc.team1572.robot.subsystems.BallHopperSubysystem;
import org.usfirst.frc.team1572.robot.subsystems.BaseJoyDriveSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.CameraSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.ChipotleArmSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.ClawHandSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.ClawIntakeSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.EncoderSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.VictorJoyDriveSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.VoltageTalonDriveSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.LiftSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.HeadingSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.SonarSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.ShooterSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.VelocityTalonDriveSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static final DriveType DRIVE_TYPE = DriveType.VICTOR; //TODO:  Switch to voltage talon for main robot.
	public static final AutonomousMode AUTONOMOUS_MODE = AutonomousMode.TEST_GEAR_2;
	public static final double TURNING_SPEED = 0.53;
	public static BaseJoyDriveSubsystem joydriveSubystem;	
	public static ClawHandSubsystem clawhandSubsystem;
	public static ClawIntakeSubsystem clawIntakeSubsystem;
	public static ChipotleArmSubsystem chipotlearmSubystem;
	public static LogitechF310Map logitechF310Map;
	public static SonarSubsystem sonarSubystem;
	public static LiftSubsystem liftSubystem;
	public static ShooterSubsystem shooterSubsystem;
	public static CameraSubsystem cameraSubsystem;
	public static BallHopperSubysystem ballHopperSubsystem;
	public static HeadingSubsystem headingSubsystem;
	public static EncoderSubsystem encoderSubsystem;


	private Command autonomousCommand;
	private SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		initSubsystems();  	
    	initSmartDashboard();
	}

	private void initSubsystems() {
		joydriveSubystem = generateJoyDrive();
		clawhandSubsystem = new ClawHandSubsystem();
		clawIntakeSubsystem = new ClawIntakeSubsystem();
		chipotlearmSubystem = new ChipotleArmSubsystem();
		shooterSubsystem = new ShooterSubsystem();
		liftSubystem = new LiftSubsystem();
		ballHopperSubsystem = new BallHopperSubysystem();
		

		cameraSubsystem = new CameraSubsystem();
		headingSubsystem = new HeadingSubsystem();
	  	ClawHandSubsystem.claw.set(DoubleSolenoid.Value.kForward);
    	ChipotleArmSubsystem.Arm.set(DoubleSolenoid.Value.kOff);
    	sonarSubystem = new SonarSubsystem();
    	encoderSubsystem = new EncoderSubsystem();
	}

	private BaseJoyDriveSubsystem generateJoyDrive() {
		switch(DRIVE_TYPE){
			case TALON_VELOCITY:
				return new VelocityTalonDriveSubsystem();
			case TALON_VOLTAGE:
				return new VoltageTalonDriveSubsystem();
			default:
				return new VictorJoyDriveSubsystem();
		}
	}

	private void initSmartDashboard() {
		SmartDashboard.putData("Auto mode", this.chooser);
		SmartDashboard.putData(Scheduler.getInstance());
		SmartDashboard.putData("Peg Auto Aim Manual", new AimForPegManually());
		SmartDashboard.putData("Gear Auto Aim Manual", new AimForGearManually());
		SmartDashboard.putData("Peg Auto Aim Autonomously", new AimForPegAutonomously());
		SmartDashboard.putData("Gear Auto Aim Autonomously", new AimForGearAutonomously());
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		//do nothing
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
		this.autonomousCommand = new AutonomousCommand(AUTONOMOUS_MODE);

		if (this.autonomousCommand != null){
			this.autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (this.autonomousCommand != null){
			this.autonomousCommand.cancel();
		}
		
		Scheduler.getInstance().add(new TeleDrive());
		Scheduler.getInstance().add(new ArmToggle());
		Scheduler.getInstance().add(new ClawToggle());
		Scheduler.getInstance().add(new GearGrab());
		Scheduler.getInstance().add(new ReleaseGear());
	}

	/**
	 * This function is called periodically during operator control
	 * 
	 */
	
	//TODO:  This really needs rework- all this stuff should be handled in commands
	@Override
	public void teleopPeriodic() {

		if(JoystickController.COPILOT_JOYSTICK.getButton6()) {
			clawIntakeSubsystem.clawIntake();
		}
		else {
			clawIntakeSubsystem.stopIntake();
		}
		if(JoystickController.MAIN_JOYSTICK.getButton4() || JoystickController.COPILOT_JOYSTICK.getButton2()) {
			liftSubystem.Lifter();
		}
		else {
			liftSubystem.stopLifter(); 
		}
		if(JoystickController.COPILOT_JOYSTICK.getButton3() || JoystickController.MAIN_JOYSTICK.getButton3()) {
			ballHopperSubsystem.ballIntake();
		}
		else{
			ballHopperSubsystem.stopBallIntake();
		} //B
		if(JoystickController.COPILOT_JOYSTICK.getButton1()) {
			shooterSubsystem.shoot();
		}
		else{
			shooterSubsystem.stopshoot();
		}
		if(JoystickController.COPILOT_JOYSTICK.getButton8() && JoystickController.COPILOT_JOYSTICK.getButton9()){
			liftSubystem.reverseLifter();
		}
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}

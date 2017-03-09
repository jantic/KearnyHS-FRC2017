
package org.usfirst.frc.team1572.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1572.robot.utls.LogitechF310Map;
import org.usfirst.frc.team1572.robot.commands.autonomous.LeftGearAutonomous;
import org.usfirst.frc.team1572.robot.commands.autonomous.MidGearAutonomous;
import org.usfirst.frc.team1572.robot.commands.autonomous.RightGearAutonomous;
import org.usfirst.frc.team1572.robot.commands.autonomous.TestAutonomous;
import org.usfirst.frc.team1572.robot.commands.main.AimForGearAutonomously;
import org.usfirst.frc.team1572.robot.commands.main.AimForGearManually;
import org.usfirst.frc.team1572.robot.commands.main.AimForPegAutonomously;
import org.usfirst.frc.team1572.robot.commands.main.AimForPegManually;
import org.usfirst.frc.team1572.robot.commands.main.TeleDrive;
import org.usfirst.frc.team1572.robot.subsystems.BallHopperSubysystem;
import org.usfirst.frc.team1572.robot.subsystems.BaseJoyDriveSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.CameraSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.ChipotleArmSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.ClawHandSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.ClawIntakeSubsystem;
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
	public static final DriveType DRIVE_TYPE = DriveType.TALON_VOLTAGE; //TODO:  Switch to voltage talon for main robot.
	public static final double TURNING_SPEED = 0.7;
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
	private final SendableChooser<Command> autonomousChooser = new SendableChooser<>();

	private Command autonomousCommand;

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
    	sonarSubystem = new SonarSubsystem();
    	//encoderSubsystem = new EncoderSubsystem();
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
		initAutonomousChooser();
		SmartDashboard.putData(Scheduler.getInstance());
		SmartDashboard.putData("Peg Auto Aim Manual", new AimForPegManually());
		SmartDashboard.putData("Gear Auto Aim Manual", new AimForGearManually());
		SmartDashboard.putData("Peg Auto Aim Autonomously", new AimForPegAutonomously());
		SmartDashboard.putData("Gear Auto Aim Autonomously", new AimForGearAutonomously());
	}
	
	private void initAutonomousChooser(){
		this.autonomousChooser.addDefault("Left Gear", new LeftGearAutonomous());
		this.autonomousChooser.addObject("Mid Gear", new MidGearAutonomous());
		this.autonomousChooser.addObject("Right Gear", new RightGearAutonomous());
		this.autonomousChooser.addObject("Test", new TestAutonomous());
		SmartDashboard.putData("Autonomous Mode", this.autonomousChooser);
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
		this.autonomousCommand = this.autonomousChooser.getSelected();
		this.autonomousCommand.start();
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
		if(this.autonomousCommand!=null){
			this.autonomousCommand.cancel();
		}
		
		Scheduler.getInstance().add(new TeleDrive());
	}

	/**
	 * This function is called periodically during operator control
	 * 
	 */
	
	@Override
	public void teleopPeriodic() {
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


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
import org.usfirst.frc.team1572.robot.commands.DriveDistance;
import org.usfirst.frc.team1572.robot.commands.GearGrab;
import org.usfirst.frc.team1572.robot.commands.ReleaseGear;
import org.usfirst.frc.team1572.robot.commands.TeleDrive;
import org.usfirst.frc.team1572.robot.subsystems.BallHopper;
import org.usfirst.frc.team1572.robot.subsystems.BaseJoyDrive;
import org.usfirst.frc.team1572.robot.subsystems.CameraSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.ChipotleArm;
import org.usfirst.frc.team1572.robot.subsystems.ClawHand;
import org.usfirst.frc.team1572.robot.subsystems.ClawIntake;
import org.usfirst.frc.team1572.robot.subsystems.ENC;
import org.usfirst.frc.team1572.robot.subsystems.VictorJoyDrive;
import org.usfirst.frc.team1572.robot.subsystems.VoltageTalonDrive;
import org.usfirst.frc.team1572.robot.subsystems.Lift;
import org.usfirst.frc.team1572.robot.subsystems.NavigationSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.Sensor;
import org.usfirst.frc.team1572.robot.subsystems.Shooter;
import org.usfirst.frc.team1572.robot.subsystems.VelocityTalonDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static final DriveType DRIVE_TYPE = DriveType.TALON_VOLTAGE;
	public static final AutonomousMode AUTONOMOUS_MODE = AutonomousMode.TEST_GEAR;
	public static OI oi;
	public static BaseJoyDrive joydrive;
	public static TeleDrive teledrive;
	public static DriveDistance drivedistance;
	public static ClawHand clawhand;
	public static ClawIntake clawIntake;
	public static ChipotleArm chipotlearm;
	public static LogitechF310Map logitechF310Map;
	public static Sensor sensor;
	public static Lift lifter;
	public static Shooter shooter;
	public static CameraSubsystem cameraSubsystem;
	public static GearGrab geargrab;
	public static ReleaseGear releasegear;
	public static ClawToggle clawtoggle;
	public static ArmToggle armtoggle;
	public static NavigationSubsystem navigationSubsystem;
	public static ENC enc;


	// boolean buttonValue = SmartDashboard.getBoolean("RightGear", true);
	// boolean buttonValue2 = SmartDashboard.getBoolean("MidGear", true);
	// boolean buttonValue3 = SmartDashboard.getBoolean("LeftGear", true);

	//double dashData = SmartDashboard.getNumber("DB/Slider 0", 0.0);

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
		joydrive = generateJoyDrive();
		clawhand = new ClawHand();
		clawIntake = new ClawIntake();
		chipotlearm = new ChipotleArm();
		shooter = new Shooter();
		lifter = new Lift();
		teledrive = new TeleDrive();
		geargrab = new GearGrab();
		releasegear = new ReleaseGear();
		clawtoggle = new ClawToggle();
		armtoggle = new ArmToggle();
		cameraSubsystem = new CameraSubsystem();
		navigationSubsystem = new NavigationSubsystem();
		OI.init();
		oi = new OI();	
	  	ClawHand.claw.set(DoubleSolenoid.Value.kForward);
    	ChipotleArm.Arm.set(DoubleSolenoid.Value.kOff);
    	sensor = new Sensor();
    	enc = new ENC();
	}

	private BaseJoyDrive generateJoyDrive() {
		switch(DRIVE_TYPE){
			case TALON_VELOCITY:
				return new VelocityTalonDrive();
			case TALON_VOLTAGE:
				return new VoltageTalonDrive();
			default:
				return new VictorJoyDrive();
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
		
		Scheduler.getInstance().add(teledrive);
		Scheduler.getInstance().add(armtoggle);
		Scheduler.getInstance().add(clawtoggle);
		Scheduler.getInstance().add(geargrab);
		Scheduler.getInstance().add(releasegear);
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {

		if(OI.joyCoPilot.getRawButton(6)) {
			ClawIntake.clawIntake();
		}
		else {
			ClawIntake.stopIntake();
		}
		if(OI.joyPilot.getRawButton(4) || OI.joyCoPilot.getRawButton(2)) {
			Lift.Lifter();
		}
		else {
			Lift.stopLifter(); 
		}
		if(OI.joyCoPilot.getRawButton(3) || OI.joyPilot.getRawButton(3)) {
			BallHopper.ballIntake();
		}
		else{
			BallHopper.stopBallIntake();
		} //B
		if(OI.joyCoPilot.getRawButton(1)) {
			Shooter.shoot();
		}
		else{
			Shooter.stopshoot();
		}
		if(OI.joyCoPilot.getRawButton(8) && OI.joyCoPilot.getRawButton(9)){
			Lift.reverseLifter();
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

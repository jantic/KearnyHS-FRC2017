 
package org.usfirst.frc.team1572.robot;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import com.ctre.CANTalon.TalonControlMode;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	/* slaves talons for arcade drive */
	CANTalon _frontLeftSlave = new CANTalon(3); 		/* device IDs here (1 of 2) */
	CANTalon _rearLeftSlave = new CANTalon(4);
	CANTalon _frontRightSlave = new CANTalon(5);
	CANTalon _rearRightSlave = new CANTalon(6);

	/* drive talons  */
	CANTalon _leftDrive = new CANTalon(1);
	CANTalon _rightDrive = new CANTalon(2);
	
	RobotDrive _drive = new RobotDrive(_leftDrive, _rightDrive);

	Joystick _joy = new Joystick(0);
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	/* take our extra talons and just have them follow the Talons updated in arcadeDrive */
    	_frontLeftSlave.changeControlMode(TalonControlMode.Follower);
    	_frontRightSlave.changeControlMode(TalonControlMode.Follower);
    	_rearLeftSlave.changeControlMode(TalonControlMode.Follower);
    	_rearRightSlave.changeControlMode(TalonControlMode.Follower);
    	
    	_frontLeftSlave.set(1); 							/* device IDs here (2 of 2) */
    	_frontRightSlave.set(2);
    	_rearLeftSlave.set(1);
    	_rearRightSlave.set(2);
    	
    	_rightDrive.setInverted(true);
    	
    	
    	/* the Talons on the left-side of my robot needs to drive reverse(red) to move robot forward.
    	 * Since _leftSlave just follows frontLeftMotor, no need to invert it anywhere. */
    	//_drive.setInvertedMotor(MotorType.kFrontLeft, true);
    	//_drive.setInvertedMotor(MotorType.kRearLeft, true);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	double forward = _joy.getRawAxis(0); // logitech gampad left X, positive is forward
    	double turn = _joy.getRawAxis(1); //logitech gampad right X, positive means turn right
    	_drive.arcadeDrive(forward, turn);
    }
}
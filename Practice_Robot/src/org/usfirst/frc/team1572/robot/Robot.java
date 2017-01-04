package org.usfirst.frc.team1572.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Joystick stick;
	Joystick stick2;  
	int autoLoopCounter;
	Victor leftDrive;
	Victor rightDrive;
	double leftY;
	double rightY;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	stick = new Joystick(0);
    	stick2 = new Joystick(1);
    	leftDrive = new Victor(0);
    	rightDrive = new Victor(1);
    }
    
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() {
    	autoLoopCounter = 0;
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
    }
    
    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit(){
    }
 
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	leftY = stick.getRawAxis(1);
    	rightY = stick2.getRawAxis(1);
    	leftDrive.set(leftY);
    	rightDrive.set(rightY);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run();
    }
    
}

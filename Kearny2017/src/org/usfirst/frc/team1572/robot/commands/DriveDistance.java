package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1572.robot.RobotMap;
import java.util.Scanner;
import com.ctre.CANTalon;
import org.usfirst.frc.team1572.robot.subsystems.JoyDrive;

/**
 *
 */
public class DriveDistance extends Command {
	
	private double m_finalDistance;
	private double m_currentDistance;
	
    public DriveDistance(double dist) {
        // Use requires() here to declare subsystem dependencies
    	//requires(Robot.joydrive);
    	m_finalDistance = dist;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	m_currentDistance = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    //	double leftSpeed = RobotMap.leftDrivetrain.getSpeed();
    	//double rightSpeed = RobotMap.rightDrivetrain.getSpeed();
    	//double time = 20;
    	//double totalSpeed = leftSpeed + rightSpeed;
    	//double speed = totalSpeed/2;
    //	double distanceTraveled = time * speed;
    	//m_currentDistance = distanceTraveled + m_currentDistance;
    	
    	//turn on motors here?
    
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return m_finalDistance <= m_currentDistance;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

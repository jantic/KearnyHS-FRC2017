package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command {
	
	private double m_finalDistance;
	private double m_currentDistance;
	
    public DriveDistance(double dist) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.joydrive);
    	m_finalDistance = dist;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	m_currentDistance = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
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

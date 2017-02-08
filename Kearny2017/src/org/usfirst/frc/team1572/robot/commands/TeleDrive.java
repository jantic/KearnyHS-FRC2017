package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleDrive extends Command {

    public TeleDrive() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.joydrive);
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	//nothing to do here
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
    	Robot.joydrive.arcadeDrive(Robot.oi.getJoyPilot()); 
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
	protected void end() {
    	//nothing to do here
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
	protected void interrupted() {
    	//nothing to do here
    }
}

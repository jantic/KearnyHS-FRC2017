package org.usfirst.frc.team1572.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReachGear extends Command {

    public ReachGear() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	//do nothing
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
    	//do nothing
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
	protected void end() {
    	//do nothing
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
	protected void interrupted() {
    	//do nothing
    }
}

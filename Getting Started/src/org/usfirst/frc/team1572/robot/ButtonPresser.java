package org.usfirst.frc.team1572.robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ButtonPresser extends Command {

    private static final String BUTTON_PRESSING_TEST = "Button Pressing Test";

	public ButtonPresser() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		SmartDashboard.putString(BUTTON_PRESSING_TEST, "button started");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putString(BUTTON_PRESSING_TEST, "button initialized");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putString(BUTTON_PRESSING_TEST, "button pressed");
    	System.out.println("button pressed");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	SmartDashboard.putString(BUTTON_PRESSING_TEST, "button not pressed");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

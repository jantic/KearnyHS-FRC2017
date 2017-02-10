package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.OI;
import org.usfirst.frc.team1572.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleDrive extends Command {

	private boolean coPilotDrive;
	private boolean overdrive;
	
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
    	if(OI.joyCoPilot.getRawAxis(0) < -0.1 || OI.joyCoPilot.getRawAxis(0) > 0.1 || OI.joyCoPilot.getRawAxis(1) < -0.1 || OI.joyCoPilot.getRawAxis(1) > 0.1){
    		coPilotDrive = true;
    		Robot.joydrive.arcadeDrive(Robot.oi.getJoyCoPilot());
    	}
    	else if(OI.joyPilot.getRawButton(2)){
    		overdrive = true;
    		Robot.joydrive.arcadeDrive(Robot.oi.getJoyPilot());
    	}
    	else {
    		Robot.joydrive.arcadeDrive(Robot.oi.getJoyPilot()); 
    	}
    }
    
    public boolean coPilotDrive() {
    	return coPilotDrive;
    }
    
    public boolean overdrive() {
    	return overdrive;
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

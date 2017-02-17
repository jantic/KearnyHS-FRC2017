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
			overdrive = false;
			Robot.joydrive.getRobotDrive().arcadeDrive(-OI.joyCoPilot.getRawAxis(1)*0.65 , -OI.joyCoPilot.getRawAxis(0)*0.5);
		}
		else if(OI.joyPilot.getRawAxis(3)>0.1){
			overdrive = true;
			coPilotDrive = false;
			Robot.joydrive.getRobotDrive().arcadeDrive(-OI.joyPilot.getRawAxis(1) , -OI.joyPilot.getRawAxis(0));
		}
		else {
			overdrive = false;
			coPilotDrive = false;
			Robot.joydrive.getRobotDrive().arcadeDrive(-OI.joyPilot.getRawAxis(1) , -OI.joyPilot.getRawAxis(0)*0.75); 
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

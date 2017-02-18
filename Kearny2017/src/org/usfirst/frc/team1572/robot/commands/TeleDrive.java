package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.JoystickController;
import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.BaseJoyDriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleDrive extends Command {

	private boolean coPilotDrive;
	private boolean overdrive;
	private BaseJoyDriveSubsystem joyDriveSubsystem = Robot.joydriveSubystem;
	
    public TeleDrive() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.joydriveSubystem);
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	//Do nothing
    }

    //TODO:  Reevaluate this.  Note that this effectively gives the co-pilot control over the main pilot.  Why have a copilot in the first place?
    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
		if(JoystickController.joyCoPilot.getRawAxis(0) < -0.1 || JoystickController.joyCoPilot.getRawAxis(0) > 0.1 || JoystickController.joyCoPilot.getRawAxis(1) < -0.1 || JoystickController.joyCoPilot.getRawAxis(1) > 0.1){
			this.coPilotDrive = true;
			this.overdrive = false;
			this.joyDriveSubsystem.getRobotDrive().arcadeDrive(-JoystickController.joyCoPilot.getRawAxis(1)*0.65 , -JoystickController.joyCoPilot.getRawAxis(0)*0.5);
		}
		else if(JoystickController.joyPilot.getRawAxis(3)>0.1){
			this.overdrive = true;
			this.coPilotDrive = false;
			this.joyDriveSubsystem.getRobotDrive().arcadeDrive(-JoystickController.joyPilot.getRawAxis(1) , -JoystickController.joyPilot.getRawAxis(0));
		}
		else {
			this.overdrive = false;
			this.coPilotDrive = false;
			this.joyDriveSubsystem.getRobotDrive().arcadeDrive(-JoystickController.joyPilot.getRawAxis(1) , -JoystickController.joyPilot.getRawAxis(0)*0.75); 
		}	
    }
    
    public boolean coPilotDrive() {
    	return this.coPilotDrive;
    }
    
    public boolean overdrive() {
    	return this.overdrive;
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

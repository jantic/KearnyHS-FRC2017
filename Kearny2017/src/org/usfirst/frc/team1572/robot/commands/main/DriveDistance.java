package org.usfirst.frc.team1572.robot.commands.main;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.commands.streaming.StreamEncoderOutput;
import org.usfirst.frc.team1572.robot.commands.streaming.StreamHeadingOutput;

import edu.wpi.first.wpilibj.command.TimedCommand;

import org.usfirst.frc.team1572.robot.subsystems.BaseJoyDriveSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.EncoderSubsystem;

public class DriveDistance extends TimedCommand {
	private final BaseJoyDriveSubsystem joyDrive = Robot.joydriveSubystem;
	private final EncoderSubsystem encoderSubsystem = Robot.encoderSubsystem;
	private final double targetDisplacement; //positve or negative
	
	public DriveDistance(final double targetDisplacement) {
    	super(5);
    	requires(Robot.joydriveSubystem);
    	requires(Robot.encoderSubsystem);
    	this.targetDisplacement = targetDisplacement;  	
    }
    
    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	this.encoderSubsystem.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
		final double joystickX = 0.0;
		final double joystickY = this.targetDisplacement > 0 ? 0.5 : -0.5;
		this.joyDrive.arcadeDrive(joystickX, joystickY);
		updateDisplay();
    }
    
    private void updateDisplay(){
    	final StreamHeadingOutput headingOutputStream = new StreamHeadingOutput();
    	headingOutputStream.streamToDashboard();
    	final StreamEncoderOutput encoderOutputStream = new StreamEncoderOutput();
    	encoderOutputStream.streamToDashboard();
    }
    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished() { 		
		final double distanceDriven = this.encoderSubsystem.getDistanceDriven();
		
    	if(this.targetDisplacement <= distanceDriven && this.targetDisplacement > 0){
			return true;
		}
		
    	if(this.targetDisplacement >= distanceDriven && this.targetDisplacement <= 0){
			return true;
		}
    	
		return super.isFinished();
    }

    // Called once after isFinished returns true
    @Override
	protected void end() {
		this.joyDrive.arcadeDrive(0 , 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
	protected void interrupted() {
    	this.joyDrive.arcadeDrive(0 , 0);
    }
}
// Called just before this Command runs the first time

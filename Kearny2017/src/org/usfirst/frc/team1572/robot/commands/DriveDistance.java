package org.usfirst.frc.team1572.robot.commands;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.usfirst.frc.team1572.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1572.robot.subsystems.BaseJoyDriveSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.EncoderSubsystem;
//import org.usfirst.frc.team1572.robot.subsystems.NavigationSubsystem;

public class DriveDistance extends Command {
	//private NavigationSubsystem navSubsystem;
	private BaseJoyDriveSubsystem joyDrive;
	private EncoderSubsystem encoderSubsystem;
	private final double targetDisplacement; //positve or negative
	private static final int TIMEOUT = 10; //seconds
	private LocalDateTime startTime;
	
	
	
    public DriveDistance(final double targetDisplacement) {
    	requires(Robot.joydriveSubystem);
    	requires(Robot.encoderSubsystem);
    	this.targetDisplacement = targetDisplacement;  	
    }
    
    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	this.encoderSubsystem = Robot.encoderSubsystem;
    	this.joyDrive = Robot.joydriveSubystem;
    	this.encoderSubsystem.reset();
		this.startTime = LocalDateTime.now();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
		final double joystickY = 0.0;
		final double joystickX = this.targetDisplacement > 0 ? 0.5 : -0.5;
		this.joyDrive.arcadeDrive(joystickX, joystickY);
		updateDisplay();
    }
    
    private void updateDisplay(){
    	final StreamHeadingOutput outputStream = new StreamHeadingOutput();
    	outputStream.execute();
    }
    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished() { 
		final LocalDateTime currentTime = LocalDateTime.now();
		
		final long elapsedSeconds = ChronoUnit.SECONDS.between(this.startTime, currentTime);
		
		if(elapsedSeconds > TIMEOUT){
			return true;
		}
    	 	
		final double distanceDriven = this.encoderSubsystem.getDistanceDriven();
		
    	if(this.targetDisplacement <= distanceDriven && this.targetDisplacement > 0){
			return true;
		}
		
    	if(this.targetDisplacement >= distanceDriven && this.targetDisplacement <= 0){
			return true;
		}
    	
		return false;
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
    	//nothing to do here
    }
}
// Called just before this Command runs the first time

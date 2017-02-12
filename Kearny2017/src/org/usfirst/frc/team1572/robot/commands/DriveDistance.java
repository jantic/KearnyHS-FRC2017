package org.usfirst.frc.team1572.robot.commands;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.usfirst.frc.team1572.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1572.robot.subsystems.BaseJoyDrive;
import org.usfirst.frc.team1572.robot.subsystems.NavigationSubsystem;

public class DriveDistance extends Command {
	private NavigationSubsystem navSubsystem;
	private BaseJoyDrive joyDrive;
	private final double targetDisplacement;
	
	private LocalDateTime startTime;
	private static long TIMEOUT = 5;
	
    public DriveDistance(final double targetDisplacement) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.joydrive);
    	requires(Robot.navigationSubsystem);
    	this.targetDisplacement = targetDisplacement;
    }
    
    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	this.navSubsystem = Robot.navigationSubsystem;
    	this.joyDrive = Robot.joydrive;
		navSubsystem.reset();
		this.startTime = LocalDateTime.now();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
		final double joystickX = 0;
		final double joystickY = targetDisplacement > 0 ? 0.5 : -0.5;
		this.joyDrive.arcadeDrive(joystickX, joystickY);
		updateDisplay();
    }
    
    private void updateDisplay(){
    	final StreamNavigationOutput outputStream = new StreamNavigationOutput();
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
		
		final double displacement = this.navSubsystem.getDisplacementY();
    	
		if(targetDisplacement > 0){
			return displacement > targetDisplacement;
		}
		else{
			return displacement < targetDisplacement; 
		}
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

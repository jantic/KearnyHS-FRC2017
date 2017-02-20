package org.usfirst.frc.team1572.robot.commands;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.commands.streaming.StreamShooterOutput;
import org.usfirst.frc.team1572.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class ChangeShooterRPM extends Command {
	private final ShooterSubsystem shooterSubsystem = Robot.shooterSubsystem;
	private double targetRPM;
	private final double rpmIncremement;
	private LocalDateTime startTime;
	private static long TIMEOUT = 5;

	public ChangeShooterRPM(final double rpmIncremement) {
		this.rpmIncremement = rpmIncremement;
		requires(Robot.shooterSubsystem);
	}


	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		this.startTime = LocalDateTime.now();
		this.targetRPM = Math.max(0.0, this.shooterSubsystem.getCurrentRPM() + rpmIncremement);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		this.shooterSubsystem.spinUpShooter(targetRPM);
		updateDisplay();
	}
	
    private void updateDisplay(){
    	final StreamShooterOutput outputStream = new StreamShooterOutput();
    	outputStream.streamToDashboard();
    }
	
	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		final LocalDateTime currentTime = LocalDateTime.now();
		final long elapsedSeconds = ChronoUnit.SECONDS.between(this.startTime, currentTime);
		
		if(elapsedSeconds > TIMEOUT){
			return true;
		}
			
		return this.shooterSubsystem.isAtTargetRPM();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		// nothing to do here
		}

	}
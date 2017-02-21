package org.usfirst.frc.team1572.robot.commands.subtasks;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.commands.streaming.StreamShooterOutput;

import edu.wpi.first.wpilibj.command.TimedCommand;

import org.usfirst.frc.team1572.robot.subsystems.ShooterSubsystem;

public class ShootBalls extends TimedCommand {
	private final ShooterSubsystem shooterSubsystem = Robot.shooterSubsystem;
	private Instant pulseStartTime;
	private static final long pulseSpanMS = 200;
	private boolean shooting = false;

    public ShootBalls() {
    	super(0.5);
    	requires(Robot.shooterSubsystem); 	
    }

    @Override
	protected void initialize() {
    	this.shooterSubsystem.startShooting();
    	this.pulseStartTime = Instant.now();
    	this.shooting = true;
    }
    
    @Override
    protected void execute(){
    	final Instant currentTime = Instant.now();
    
    	final long elapsedTime = ChronoUnit.MILLIS.between(this.pulseStartTime, currentTime);
    	
    	if(elapsedTime > pulseSpanMS){
    		if(this.shooting){
    			this.shooterSubsystem.stopShooting();
    			this.shooting = false;
    		}
    		else{
    			// TODO: only do this if at target speed
    			this.shooterSubsystem.startShooting();
    			this.shooting = true;
    		}
    		
    		this.pulseStartTime = Instant.now();
    	}
    	
		updateDisplay();
    }

    private void updateDisplay(){
    	final StreamShooterOutput shooterOutputStream = new StreamShooterOutput();
    	shooterOutputStream.streamToDashboard();
    }

    @Override
	protected boolean isFinished() {    	
    	return super.isFinished();
    }

}


package org.usfirst.frc.team1572.robot.commands.subtasks;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.commands.streaming.StreamShooterOutput;

import edu.wpi.first.wpilibj.command.TimedCommand;

import org.usfirst.frc.team1572.robot.subsystems.ShooterSubsystem;

public class SpinUpShooter extends TimedCommand {
	private static final double RPM_TOLERANCE = 3;
	private final ShooterSubsystem shooterSubsystem = Robot.shooterSubsystem;
	private final double targetRPM;

    public SpinUpShooter(final double targetRPM) {
    	super(3);
    	this.targetRPM = targetRPM;
    	requires(Robot.shooterSubsystem); 	
    }

    @Override
	protected void initialize() {
    	this.shooterSubsystem.shoot(this.targetRPM);
		updateDisplay();
    }

    private void updateDisplay(){
    	final StreamShooterOutput shooterOutputStream = new StreamShooterOutput();
    	shooterOutputStream.streamToDashboard();
    }

    @Override
	protected boolean isFinished() { 
    	if(Math.abs(this.targetRPM - this.shooterSubsystem.getCurrentRPM()) < RPM_TOLERANCE){
    		return true;
    	}
    	
    	return super.isFinished();
    }

}


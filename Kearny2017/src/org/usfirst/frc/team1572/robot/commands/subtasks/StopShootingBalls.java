package org.usfirst.frc.team1572.robot.commands.subtasks;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.commands.streaming.StreamShooterOutput;

import edu.wpi.first.wpilibj.command.TimedCommand;

import org.usfirst.frc.team1572.robot.subsystems.ShooterSubsystem;

public class StopShootingBalls extends TimedCommand {
	private final ShooterSubsystem shooterSubsystem = Robot.shooterSubsystem;

    public StopShootingBalls() {
    	super(0.5);
    	requires(Robot.shooterSubsystem); 	
    }

    @Override
	protected void initialize() {
    	this.shooterSubsystem.stopShooting();
    }
    
    @Override
    protected void execute(){
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


package org.usfirst.frc.team1572.robot.commands.subtasks;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.commands.streaming.StreamShooterOutput;
import org.usfirst.frc.team1572.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class SpinUpShooter extends TimedCommand {
	private final ShooterSubsystem shooterSubsystem = Robot.shooterSubsystem;
	private final double targetRPM;

	public SpinUpShooter(final double targetRPM) {
		super(5);
		this.targetRPM = targetRPM;
		requires(Robot.shooterSubsystem);
	}

	@Override
	protected void initialize() {
		this.shooterSubsystem.spinUpShooter(this.targetRPM);
	}

	@Override
	protected void execute() {
		updateDisplay();
	}
	
    private void updateDisplay(){
    	final StreamShooterOutput outputStream = new StreamShooterOutput();
    	outputStream.streamToDashboard();
    }
	
	@Override
	protected boolean isFinished() {
		if(this.shooterSubsystem.isAtTargetRPM()){
			return true;
		}
		
		return super.isFinished();
	}
}

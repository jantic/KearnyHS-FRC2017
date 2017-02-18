package org.usfirst.frc.team1572.robot.commands;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.BaseJoyDrive;
import org.usfirst.frc.team1572.robot.subsystems.NavigationSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class TurnUntilAngle extends Command {
	private BaseJoyDrive joyDrive;
	private NavigationSubsystem navSubsystem;
	private final double targetAngle;
	private final double angleTolerance = 5;
	private LocalDateTime startTime;
	private static long TIMEOUT = 5;

	public TurnUntilAngle(final double targetAngle) {
		this.targetAngle = targetAngle;
		requires(Robot.joydrive);
		requires(Robot.navigationSubsystem);
	}


	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
    	this.navSubsystem = Robot.navigationSubsystem;
    	this.joyDrive = Robot.joydrive;
		this.navSubsystem.reset();
		this.startTime = LocalDateTime.now();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		final double joystickX = generateJoystickX();
		final double joystickY = 0.0;
		this.joyDrive.arcadeDrive(joystickX, joystickY);
		updateDisplay();
	}
	
    private void updateDisplay(){
    	final StreamNavigationOutput outputStream = new StreamNavigationOutput();
    	outputStream.execute();
    }
	
	private double generateJoystickX(){
		if(this.targetAngle >= 0){
			return 0.5;
		}
		
		return -0.5;
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		final LocalDateTime currentTime = LocalDateTime.now();
		final long elapsedSeconds = ChronoUnit.SECONDS.between(this.startTime, currentTime);
		
		if(elapsedSeconds > TIMEOUT){
			return true;
		}
		
		final double currentAngle = this.navSubsystem.getAngle();
		final double diff = (this.targetAngle - currentAngle);
		
		return (Math.abs(diff) < this.angleTolerance);
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		// nothing to do here
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		// nothing to do here
	}
}
package org.usfirst.frc.team1572.robot.commands.main;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.commands.streaming.StreamHeadingOutput;
import org.usfirst.frc.team1572.robot.subsystems.BaseJoyDriveSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.HeadingSubsystem;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class TurnUntilAngle extends TimedCommand {
	private final BaseJoyDriveSubsystem joyDrive = Robot.joydriveSubystem;
	private final HeadingSubsystem headingSubystem = Robot.headingSubsystem;
	private final double targetAngle;
	private final double angleTolerance = 1;

	public TurnUntilAngle(final double targetAngle) {
		super(5);
		this.targetAngle = targetAngle;
		requires(Robot.joydriveSubystem);
		requires(Robot.headingSubsystem);
	}


	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		this.headingSubystem.reset();
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
    	final StreamHeadingOutput outputStream = new StreamHeadingOutput();
    	outputStream.streamToDashboard();
    }
	
	private double generateJoystickX(){
		if(this.targetAngle >= 0){
			return -Robot.TURNING_SPEED;
		}
		return Robot.TURNING_SPEED;
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		final double currentAngle = this.headingSubystem.getAngle();
		final double diff = (this.targetAngle - currentAngle);
		
		if(Math.abs(diff) < this.angleTolerance){
			return true;
		}
		
		return super.isFinished();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		this.joyDrive.arcadeDrive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		this.joyDrive.arcadeDrive(0, 0);
	}
}
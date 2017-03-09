package org.usfirst.frc.team1572.robot.commands.main;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.commands.streaming.StreamHeadingOutput;
import org.usfirst.frc.team1572.robot.subsystems.BaseJoyDriveSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.HeadingSubsystem;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class TurnUntilAngle extends TimedCommand {
	private final StreamHeadingOutput outputStream = new StreamHeadingOutput();
	private final BaseJoyDriveSubsystem joyDrive = Robot.joydriveSubystem;
	private final HeadingSubsystem headingSubystem = Robot.headingSubsystem;
	private double targetAngle;
	private final double angleTolerance = 3;
	private double turnSpeed;

	public TurnUntilAngle(final double targetAngle, final double speed) {
		super(5);
		this.targetAngle = targetAngle;
		requires(Robot.joydriveSubystem);
		requires(Robot.headingSubsystem);
		this.turnSpeed = speed;
	}


	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		this.headingSubystem.reset();
		this.targetAngle = this.targetAngle + this.headingSubystem.getAngle();
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
    	this.outputStream.streamToDashboard();
    }
	
	private double generateJoystickX(){
		double p = 1/20d;
		double error = this.targetAngle - this.headingSubystem.getAngle();
		if(this.turnSpeed > 0){
		return -this.turnSpeed * error * p - 0.25;
		}
		return this.turnSpeed * error * p + 0.25;
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
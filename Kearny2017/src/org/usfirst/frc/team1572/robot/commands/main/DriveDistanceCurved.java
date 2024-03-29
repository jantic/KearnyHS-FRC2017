package org.usfirst.frc.team1572.robot.commands.main;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.RobotMap;
import org.usfirst.frc.team1572.robot.commands.streaming.StreamEncoderOutput;
import org.usfirst.frc.team1572.robot.commands.streaming.StreamHeadingOutput;

import edu.wpi.first.wpilibj.command.TimedCommand;

import org.usfirst.frc.team1572.robot.subsystems.BaseJoyDriveSubsystem;
import com.ctre.CANTalon;

public class DriveDistanceCurved extends TimedCommand {
	private final BaseJoyDriveSubsystem joyDrive = Robot.joydriveSubystem;
	private final CANTalon leftDrive = RobotMap.talonLeftDrivetrain;
	private final CANTalon rightDrive = RobotMap.talonRightDrivetrain;
	//private final EncoderSubsystem encoderSubsystem = Robot.encoderSubsystem;
	private final double targetDisplacement; //positve or negative
	private double currentDisplacement;
	private long lastTimeMilli;
	private final double driveSpeed;
	private final double curve;
	
	public DriveDistanceCurved(final double targetDisplacement, final double speed, final double timeOut, final double curve) {
		super(timeOut);
		this.driveSpeed = speed;
    	requires(Robot.joydriveSubystem);
    	//requires(Robot.encoderSubsystem);
    	this.targetDisplacement = targetDisplacement;
    	this.curve = curve;
    }
	
    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	//this.encoderSubsystem.reset();
    	this.currentDisplacement = 0;
    	this.lastTimeMilli = -1;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
    	final long currentTimeMilli = System.currentTimeMillis();
    	if(this.lastTimeMilli > 0) {
    		final long dt = currentTimeMilli - this.lastTimeMilli;
    		final double avgRpm = (Math.abs(this.leftDrive.getSpeed()) + Math.abs(this.rightDrive.getSpeed())) / 2d;
    		final double avgSpd = 4d * Math.PI * avgRpm / 60000d; // inches per millisecond
    		System.out.println("leftRPM " + this.leftDrive.getSpeed());
    		System.out.println("rightRPM " + this.rightDrive.getSpeed());
    		System.out.println("RPM " + avgRpm);
    		System.out.println("Speed " + avgSpd);
    		System.out.println("Displacement " + this.currentDisplacement);
    		System.out.println("Target Displacement " + this.targetDisplacement);
    		if(this.targetDisplacement > 0){
    			this.currentDisplacement += avgSpd * dt;
    		}
    		else{
    			this.currentDisplacement -= avgSpd * dt;
    		}
    	}
    	this.lastTimeMilli = currentTimeMilli;
    	double joystickY = 0;
		double joystickX = this.curve;
		if(this.targetDisplacement < 0) {
			joystickY = -this.driveSpeed;
		}
		else{
			joystickY = this.driveSpeed;
		}
		this.joyDrive.arcadeDrive(joystickX, joystickY);
		updateDisplay();
    }
    
    private void updateDisplay() {
    	final StreamHeadingOutput headingOutputStream = new StreamHeadingOutput();
    	headingOutputStream.streamToDashboard();
    	final StreamEncoderOutput encoderOutputStream = new StreamEncoderOutput();
    	encoderOutputStream.streamToDashboard();
    }
    
    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished() { 		
//		final double distanceDriven = this.encoderSubsystem.getDistanceDriven();
//    	if(this.targetDisplacement <= distanceDriven && this.targetDisplacement > 0){
//			return true;
//		}
//    	if(this.targetDisplacement >= distanceDriven && this.targetDisplacement <= 0){
//			return true;
//		}
    	if(this.targetDisplacement > 0){
    		if(this.currentDisplacement >= this.targetDisplacement) {
    			return true;
    		}
    	}
    	else if(this.currentDisplacement <= this.targetDisplacement) {
    		return true;
    	}
    	

		return super.isFinished();
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
    	this.joyDrive.arcadeDrive(0 , 0);
    }
}

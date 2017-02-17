package org.usfirst.frc.team1572.robot.commands;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1572.robot.subsystems.BaseJoyDrive;
import org.usfirst.frc.team1572.robot.subsystems.NavigationSubsystem;

public class DriveDistanceB extends Command {
	private NavigationSubsystem navSubsystem;
	private BaseJoyDrive joyDrive;
	private final double targetDisplacement;
	
	private LocalDateTime startTime;
	private double DRIVEOUT;
	private static double DRIVEDONE;
	
    public DriveDistanceB(final double targetDisplacement, final double driveDone) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.joydrive);
    	requires(Robot.navigationSubsystem);
    	this.targetDisplacement = targetDisplacement;
    	this.DRIVEDONE = driveDone;
    	
    }
    
    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	RobotMap.enc.reset();
    	this.navSubsystem = Robot.navigationSubsystem;
    	this.joyDrive = Robot.joydrive;
		this.startTime = LocalDateTime.now();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
		final double joystickY = 0.0;
		final double joystickX = targetDisplacement > 0 ? 0.5 : -0.5;
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
		double distance = RobotMap.enc.getRate();
		double distance2 = RobotMap.enc.getDistance();
		this.DRIVEOUT = distance2;
		
    	if(DRIVEDONE <= DRIVEOUT){
    		this.joyDrive.arcadeDrive(0 , 0);
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
// Called just before this Command runs the first time

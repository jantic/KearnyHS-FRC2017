package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.vision.CameraType;
import org.usfirst.frc.team1572.robot.vision.IAutoAim;
import org.usfirst.frc.team1572.robot.vision.PegTargetAutoAim;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReachDaGear extends Command {
	private final AimForPegAutonomously m_aim = new AimForPegAutonomously();
	private final IAutoAim autoAim = new PegTargetAutoAim();
    public ReachDaGear() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    		Robot.navigationSubsystem.reset();
    		//m_aim.alignRobotToTarget(this.autoAim, CameraType.PEG_CAMERA);
    		m_aim.initialize();
    		m_aim.execute();
    		m_aim.isFinished();
    		m_aim.end();
    		m_aim.interrupted();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double distToGear = Robot.sensor.getDistance();
		if ( distToGear <= 8) {
		return true;
	}
		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

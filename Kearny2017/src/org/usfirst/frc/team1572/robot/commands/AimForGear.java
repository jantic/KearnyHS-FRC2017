package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.vision.GearTargetAutoAim;
import org.usfirst.frc.team1572.robot.vision.IAutoAim;
import org.usfirst.frc.team1572.robot.vision.VisionCenteringCommand;

import edu.wpi.first.wpilibj.command.Command;

public class AimForGear extends Command {
	private final IAutoAim autoAim = new GearTargetAutoAim();
	private VisionCenteringCommand lastCenteringCommand = VisionCenteringCommand.NULL;

    public AimForGear() {
    	requires(Robot.joydrive);  	
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	//nothing to do here
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
    	final VisionCenteringCommand centeringCommand = this.autoAim.generateCenteringCommand();
    	//TODO:  Put turning code here- this is where we ask Rich (the adult).
    	//Because of the dynamic nature of the turning I don't think we can make this a command group.
    	//i.e. we might have to duplicate some turning code.
    	this.lastCenteringCommand = centeringCommand;
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished() {
        return this.lastCenteringCommand.equals(VisionCenteringCommand.CENTER);
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
		// nothing to do here
    }
}

package org.usfirst.frc.team1572.robot.commands.main;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.ChipotleArmSubsystem;
import edu.wpi.first.wpilibj.command.TimedCommand;


public class ClawUp extends TimedCommand {
	private final ChipotleArmSubsystem chipotleArmSubsystem = Robot.chipotlearmSubystem;

    public ClawUp() {
    	super(1);
    	requires(Robot.chipotlearmSubystem);
    }
    
    @Override
	protected void initialize() {
		this.chipotleArmSubsystem.raiseArm();
    }

    @Override
	protected void end() {
    	this.chipotleArmSubsystem.stop();
    }
}

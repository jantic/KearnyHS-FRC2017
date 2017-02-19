package org.usfirst.frc.team1572.robot.commands.main;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.ClawHandSubsystem;
import edu.wpi.first.wpilibj.command.TimedCommand;


public class GearRelease extends TimedCommand {
	private final ClawHandSubsystem clawHandSubsystem = Robot.clawhandSubsystem;

    public GearRelease() {
    	super(1);
    	requires(Robot.clawhandSubsystem);
    }
    
    @Override
	protected void initialize() {
		this.clawHandSubsystem.openClaw();
    }

    @Override
	protected void end() {
    	this.clawHandSubsystem.stop();
    }
}

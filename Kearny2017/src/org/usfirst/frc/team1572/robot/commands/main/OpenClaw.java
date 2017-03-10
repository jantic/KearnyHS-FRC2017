package org.usfirst.frc.team1572.robot.commands.main;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.ChipotleArmSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.ClawHandSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.ClawIntakeSubsystem;
import edu.wpi.first.wpilibj.command.TimedCommand;


public class OpenClaw extends TimedCommand {
	private final ClawHandSubsystem clawHandSubsystem = Robot.clawhandSubsystem;

    public OpenClaw() {
    	super(1);
    	requires(Robot.clawhandSubsystem);
    }
    
    @Override
	protected void initialize() {
		this.clawHandSubsystem.openClaw();
    }

    
}

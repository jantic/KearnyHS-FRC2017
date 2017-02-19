package org.usfirst.frc.team1572.robot.commands.main;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.ChipotleArmSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.ClawHandSubsystem;
import edu.wpi.first.wpilibj.command.TimedCommand;

public class GearGrabClose extends TimedCommand {
	private final ClawHandSubsystem clawHandSubsystem = Robot.clawhandSubsystem;
	private final ChipotleArmSubsystem chipotleArmSubsystem = Robot.chipotlearmSubystem;
	
	public GearGrabClose() {
		super(1);
		requires(Robot.clawhandSubsystem);
		requires(Robot.chipotlearmSubystem);
	}
	
	@Override
	protected void initialize() {
		this.clawHandSubsystem.closeClaw();
		this.chipotleArmSubsystem.raiseArm(); 
	}
	
	@Override
	protected void end() {
		this.clawHandSubsystem.stop();
		this.chipotleArmSubsystem.stop();
	}
}
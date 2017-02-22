package org.usfirst.frc.team1572.robot.commands.main;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.ChipotleArmSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.ClawHandSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.ClawIntakeSubsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.TimedCommand;

public class GearGrabClose extends TimedCommand {
	private final ClawHandSubsystem clawHandSubsystem = Robot.clawhandSubsystem;
	private final ChipotleArmSubsystem chipotleArmSubsystem = Robot.chipotlearmSubystem;
	private final ClawIntakeSubsystem clawIntakeSubsystem = Robot.clawIntakeSubsystem;
	
	public GearGrabClose() {
		super(1);
		requires(Robot.clawhandSubsystem);
		requires(Robot.chipotlearmSubystem);
		requires(Robot.clawIntakeSubsystem);
	}
	
	@Override
	protected void initialize() {
		this.clawHandSubsystem.closeClaw();
		//Timer.delay(0.05);
		this.chipotleArmSubsystem.raiseArm(); 
	}
	
	@Override
	protected void end() {
		this.clawIntakeSubsystem.stopIntake();
		this.clawHandSubsystem.stop();
		this.chipotleArmSubsystem.stop();
		
	}
}
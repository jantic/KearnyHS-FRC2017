package org.usfirst.frc.team1572.robot.commands.main;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.ChipotleArmSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.ClawHandSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.ClawIntakeSubsystem;
import edu.wpi.first.wpilibj.command.TimedCommand;


public class ClawIntakeReverse extends TimedCommand {
	private final ClawHandSubsystem clawHandSubsystem = Robot.clawhandSubsystem;
	private final ChipotleArmSubsystem chipotleArmSubsystem = Robot.chipotlearmSubystem;
	private final ClawIntakeSubsystem clawIntakeSubsystem = Robot.clawIntakeSubsystem;

    public ClawIntakeReverse() {
    	super(5);
    	requires(Robot.clawhandSubsystem);
    	requires(Robot.chipotlearmSubystem);
    	requires(Robot.clawIntakeSubsystem);
    }
    
    @Override
	protected void initialize() {
		this.clawIntakeSubsystem.reverseIntake();
		this.chipotleArmSubsystem.raiseArm();
    }

    @Override
	protected void end() {
    	this.clawIntakeSubsystem.stopIntake();
    	this.chipotleArmSubsystem.stop();
    }
}


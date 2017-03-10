package org.usfirst.frc.team1572.robot.commands.main;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.ChipotleArmSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.ClawHandSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.ClawIntakeSubsystem;
import edu.wpi.first.wpilibj.command.TimedCommand;


public class ClawDown extends TimedCommand {

	private final ChipotleArmSubsystem chipotleArmSubsystem = Robot.chipotlearmSubystem;


    public ClawDown() {
    	super(5);
    	requires(Robot.chipotlearmSubystem);
    }
    
    @Override
	protected void initialize() {
		this.chipotleArmSubsystem.lowerArm(); 
    }

}

package org.usfirst.frc.team1572.robot.commands.subtasks;

import org.usfirst.frc.team1572.robot.Robot;
import edu.wpi.first.wpilibj.command.TimedCommand;

import org.usfirst.frc.team1572.robot.subsystems.BallHopperSubysystem;

public class StopBallHopper extends TimedCommand {
	private final BallHopperSubysystem ballHopperSubsystem = Robot.ballHopperSubsystem;

    public StopBallHopper() {
    	super(0.5);
    	requires(Robot.ballHopperSubsystem); 	
    }

    @Override
	protected void initialize() {
    	this.ballHopperSubsystem.stop();
    }
}


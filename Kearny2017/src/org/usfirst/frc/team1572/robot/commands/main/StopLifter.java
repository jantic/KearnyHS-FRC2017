package org.usfirst.frc.team1572.robot.commands.main;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.LiftSubsystem;

import edu.wpi.first.wpilibj.command.TimedCommand;


public class StopLifter extends TimedCommand {
		private final LiftSubsystem liftSubystem = Robot.liftSubystem;
  	
        public StopLifter() {
        	super(0.5);
        	requires(Robot.liftSubystem);
        }
        
        @Override
		protected void initialize() {
        	this.liftSubystem.stopLifter();
        }

        @Override
		protected boolean isFinished() {
    		return super.isFinished();
        }
}
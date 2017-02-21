package org.usfirst.frc.team1572.robot.commands;
import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.HeadingSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class ResetAll extends Command {
		private final HeadingSubsystem headingSubsystem = new HeadingSubsystem();
  	
        public void ClawintakeForwards() {
        	requires(Robot.headingSubsystem);
        }
        
        @Override
		protected void initialize() {
        	this.headingSubsystem.reset();
        	//this.headingSubsystem.resetDisplacement();
    		//this.navxSensor.reset();
    		//this.navxSensor.resetDisplacement();
        }

        @Override
		protected boolean isFinished() {
    		return true;
        }

}


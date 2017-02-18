package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.JoystickController;
import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.ClawHandSubsystem;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClawToggle extends Command {

		private boolean buttonPressed;
		private double loopcounter = 0;
		private ClawHandSubsystem clawHandSubsystem;
		private static boolean running = false;
    	
        public ClawToggle() {
            // Use requires() here to declare subsystem dependencies
        	//Do nothing
        	requires(Robot.clawhandSubsystem);
        
        }
        


        // Called just before this Command runs the first time
        @Override
		protected void initialize() {
        	this.clawHandSubsystem = Robot.clawhandSubsystem;
        }

        // Called repeatedly when this Command is scheduled to run
        @Override
		protected void execute() {
        	this.buttonPressed = JoystickController.joyPilot.getRawButton(6);
        	if(this.buttonPressed && this.loopcounter > 20 && !ReleaseGear.running() && !GearGrab.running() && !ArmToggle.running()){
        		this.loopcounter = 0;
        		running = true;
        		if(this.clawHandSubsystem.clawOpen()){
        			this.clawHandSubsystem.closeClaw();
        		}
        		else{
        			this.clawHandSubsystem.openClaw();
        		}
        	}
        	else{
        		running = false;
        	}
        	this.loopcounter = this.loopcounter + 1;
        
        }
        public static boolean running() {
        	return running;
        }
        
        // Make this return true when this Command no longer needs to run execute()
        @Override
		protected boolean isFinished() {
			return false;
        	
        }

        // Called once after isFinished returns true
        @Override
		protected void end() {
        	//DO NOTHING
        }

        // Called when another command which requires one or more of the same
        // subsystems is scheduled to run
        @Override
		protected void interrupted() {
        	//DO NOTHING
        }
}
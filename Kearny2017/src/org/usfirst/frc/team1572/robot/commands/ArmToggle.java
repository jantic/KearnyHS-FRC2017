package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.OI;
import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.ChipotleArm;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmToggle extends Command {

		private boolean buttonPressed;
		private double loopcount = 0;
		private static boolean running;
    	
        public ArmToggle() {
            // Use requires() here to declare subsystem dependencies
        	requires(Robot.chipotlearm);
        }
        


        // Called just before this Command runs the first time
        @Override
		protected void initialize() {
        	//Do nothing
        }

        // Called repeatedly when this Command is scheduled to run
        @Override
		protected void execute() {
        	this.buttonPressed = OI.joyPilot.getRawButton(5);
        	if(this.buttonPressed && this.loopcount > 20 && !ReleaseGear.running() && !GearGrab.running() && !ClawToggle.running()){
        		running = true;
        		this.loopcount = 0;
        		if(ChipotleArm.clawDown()){
        			ChipotleArm.raiseArm();
        		}
        		else{
        			ChipotleArm.lowerArm();
        		}
        	}
        	else{
        		running = false;
        	}
        	this.loopcount = this.loopcount + 1;
        
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
        	//Do nothing
        }

        // Called when another command which requires one or more of the same
        // subsystems is scheduled to run
        @Override
		protected void interrupted() {
        	//Do nothing
        }
}
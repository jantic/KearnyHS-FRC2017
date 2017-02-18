package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.OI;
import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.ChipotleArm;
import org.usfirst.frc.team1572.robot.subsystems.ClawHand;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReleaseGear extends Command {

		private boolean buttonPushed;
		private double loopcount;
		private static boolean running;
    	
        public ReleaseGear() {
            // Use requires() here to declare subsystem dependencies
        	requires(Robot.clawhand);
        	requires(Robot.chipotlearm);
        }

        // Called just before this Command runs the first time
        @Override
		protected void initialize() {
        	//do nothing
        }

        // Called repeatedly when this Command is scheduled to run
        @Override
		protected void execute() {
        	this.buttonPushed = OI.joyPilot.getRawButton(2) || OI.joyCoPilot.getRawButton(5);
        	if(this.buttonPushed && !GearGrab.running() && !ClawToggle.running() && !ArmToggle.running()){
        		this.loopcount = 0;
        		ClawHand.openClaw();
        		ChipotleArm.lowerArm();
        		running = true;
        	}
        	else{
        		if(this.loopcount < 20){
        			ClawHand.closeClaw();
        			ChipotleArm.raiseArm();
        			running = true;
        		}
        		else{
        			running = false;
        		}
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
        	//do nothing
        }

        // Called when another command which requires one or more of the same
        // subsystems is scheduled to run
        @Override
		protected void interrupted() {
        	//do nothing
        }
}
package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.JoystickController;
import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.subsystems.ChipotleArmSubsystem;
import org.usfirst.frc.team1572.robot.subsystems.ClawHandSubsystem;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearGrab extends Command {

		//private boolean gearDetected;
		private boolean buttonPressed;
		private double loopcount;
		private static boolean running;
		private final ClawHandSubsystem clawHandSubsystem = Robot.clawhandSubsystem;
		private final ChipotleArmSubsystem chipotleArmSubsystem = Robot.chipotlearmSubystem;
		//private long timeout;
    	
        public GearGrab() {
        	requires(Robot.clawhandSubsystem);
        	requires(Robot.chipotlearmSubystem);
        }
        


        // Called just before this Command runs the first time
        @Override
		protected void initialize() {
        	//Do nothing
        }

        // Called repeatedly when this Command is scheduled to run
        @Override
		protected void execute() {
        	this.buttonPressed = JoystickController.MAIN_JOYSTICK.getButton1() || JoystickController.COPILOT_JOYSTICK.getButton4();
        	
        	if(this.buttonPressed /*&& !gearDetected*/ && !ReleaseGear.running() && !ClawToggle.running() && !ArmToggle.running()){
        		this.loopcount = 0;
        		this.clawHandSubsystem.openClaw();
        		this.chipotleArmSubsystem.lowerArm();
        		running = true;
        	}
        	else{
        		if(this.loopcount < 20){
        			this.clawHandSubsystem.closeClaw();
        			this.chipotleArmSubsystem.raiseArm();
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
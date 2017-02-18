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
		private ClawHandSubsystem clawHandSubsystem;
		private ChipotleArmSubsystem chipotleArmSubsystem;
		//private long timeout;
    	
        public GearGrab() {
            // Use requires() here to declare subsystem dependencies
        	requires(Robot.clawhandSubsystem);
        	//requires(Robot.clawIntake);
        	requires(Robot.chipotlearmSubystem);
        	//requires(Robot.sensor);
        }
        


        // Called just before this Command runs the first time
        @Override
		protected void initialize() {
        	this.clawHandSubsystem = Robot.clawhandSubsystem;
        	this.chipotleArmSubsystem = Robot.chipotlearmSubystem;
        }

        // Called repeatedly when this Command is scheduled to run
        @Override
		protected void execute() {
        	this.buttonPressed = JoystickController.joyPilot.getRawButton(1) || JoystickController.joyCoPilot.getRawButton(4);
        	/*if(Sensor.getDistance() < 1){
        		gearDetected = true;
        	}*/
        	if(this.buttonPressed /*&& !gearDetected*/ && !ReleaseGear.running() && !ClawToggle.running() && !ArmToggle.running()){
        		this.loopcount = 0;
        		this.clawHandSubsystem.openClaw();
        		this.chipotleArmSubsystem.lowerArm();
        		//ClawIntake.clawIntake();
        		running = true;
        	}
        	else{
        		if(this.loopcount < 20){
        			this.clawHandSubsystem.closeClaw();
        			//ClawIntake.stopIntake();
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
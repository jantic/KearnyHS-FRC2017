package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.OI;
import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.RobotMap;
import org.usfirst.frc.team1572.robot.subsystems.ChipotleArm;
import org.usfirst.frc.team1572.robot.subsystems.ClawHand;
import org.usfirst.frc.team1572.robot.subsystems.ClawIntake;
import org.usfirst.frc.team1572.robot.subsystems.Sensor;

import edu.wpi.first.wpilibj.Timer;
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
        protected void initialize() {
        }

        // Called repeatedly when this Command is scheduled to run
        protected void execute() {
        	buttonPushed = OI.joyPilot.getRawButton(2) || OI.joyCoPilot.getRawButton(5);
        	if(buttonPushed && !GearGrab.running() && !ClawToggle.running() && !ArmToggle.running()){
        		loopcount = 0;
        		ClawHand.openClaw();
        		ChipotleArm.lowerArm();
        		running = true;
        	}
        	else{
        		if(loopcount < 20){
        			ClawHand.closeClaw();
        			ChipotleArm.raiseArm();
        			running = true;
        		}
        		else{
        			running = false;
        		}
        	}
        	loopcount = loopcount + 1;
        
        }
        public static boolean running() {
        	return running;
        }
        
        // Make this return true when this Command no longer needs to run execute()
        protected boolean isFinished() {
			return false;
        	
        }

        // Called once after isFinished returns true
        protected void end() {
        }

        // Called when another command which requires one or more of the same
        // subsystems is scheduled to run
        protected void interrupted() {
        }
}
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
public class ClawToggle extends Command {

		private boolean buttonPressed;
		private double loopcounter = 0;
		private static boolean running;
    	
        public ClawToggle() {
            // Use requires() here to declare subsystem dependencies
        	requires(Robot.clawhand);
        }
        


        // Called just before this Command runs the first time
        protected void initialize() {
        }

        // Called repeatedly when this Command is scheduled to run
        protected void execute() {
        	buttonPressed = OI.joyPilot.getRawButton(6);
        	if(buttonPressed && loopcounter > 20 && !ReleaseGear.running() && !GearGrab.running() && !ArmToggle.running()){
        		loopcounter = 0;
        		running = true;
        		if(ClawHand.clawOpen()){
        			ClawHand.closeClaw();
        		}
        		else{
        			ClawHand.openClaw();
        		}
        	}
        	else{
        		running = false;
        	}
        	loopcounter = loopcounter + 1;
        
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
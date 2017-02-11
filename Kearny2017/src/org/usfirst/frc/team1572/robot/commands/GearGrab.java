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
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitUntilCommand;

/**
 *
 */
public class GearGrab extends Command {

		//private boolean gearDetected;
		private boolean buttonPressed;
		private double loopcount;
		private long timeout;
    	
        public GearGrab() {
            // Use requires() here to declare subsystem dependencies
        	requires(Robot.clawhand);
        	requires(Robot.clawIntake);
        	requires(Robot.chipotlearm);
        	//requires(Robot.sensor);
        }
        


        // Called just before this Command runs the first time
        protected void initialize() {
        }

        // Called repeatedly when this Command is scheduled to run
        protected void execute() {
        	buttonPressed = OI.joyPilot.getRawButton(3) || OI.joyCoPilot.getRawButton(5);
        	/*if(Sensor.getDistance() < 1){
        		gearDetected = true;
        	}*/
        	if(buttonPressed /*&& !gearDetected*/){
        		loopcount = 0;
        		ClawHand.openClaw();
        		ChipotleArm.lowerArm();
        		ClawIntake.clawIntake();
        	}
        	else{
        		if(loopcount < 30){
        			ClawHand.closeClaw();
        			ClawIntake.stopIntake();
        			if(loopcount > 20){
        				ChipotleArm.raiseArm();
        			}
        		}
        	}
        	loopcount = loopcount + 1;
        
        }
        // Make this return true when this Command no longer needs to run execb n        ute()
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
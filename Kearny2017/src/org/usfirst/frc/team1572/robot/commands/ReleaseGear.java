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

		private boolean buttonPressed;
		private double loopcount;
    	
        public ReleaseGear() {
            // Use requires() here to declare subsystem dependencies
        	//requires(Robot.clawhand);
        	//requires(Robot.chipotlearm);
        }
        


        // Called just before this Command runs the first time
        protected void initialize() {
        }

        // Called repeatedly when this Command is scheduled to run
        protected void execute() {
        	buttonPressed = OI.joyCoPilot.getRawButton(2);
        	if(buttonPressed){
        		loopcount = 0;
        		//ClawHand.openClaw();
        		//ChipotleArm.lowerArm();
        	}
        	else{
        		if(loopcount < 10){
        			//ClawHand.closeClaw();
        			//ChipotleArm.raiseArm();
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
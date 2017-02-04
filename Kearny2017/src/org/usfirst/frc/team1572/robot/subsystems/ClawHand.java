package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.OI;
import org.usfirst.frc.team1572.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawHand extends Subsystem {
	public static DoubleSolenoid claw = RobotMap.clawHand;
    
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
		
    public void initDefaultCommand() {
    	claw.set(DoubleSolenoid.Value.kOff);
        
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public static void openClaw() {
    	if (OI.joyPilot.getRawButton(3)) {
        	claw.set(DoubleSolenoid.Value.kForward);
    	}
    }
    
    public static void closeClaw() {
    	if (OI.joyPilot.getRawButton(4)) {
        	claw.set(DoubleSolenoid.Value.kReverse);
    	}
    }
}
//82984285
package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.OI;
import org.usfirst.frc.team1572.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ChipotleArm extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static DoubleSolenoid rightArm = RobotMap.rightArm;
	public static DoubleSolenoid leftArm = RobotMap.leftArm;
	
    public void initDefaultCommand() {
    	rightArm.set(DoubleSolenoid.Value.kOff);
    	leftArm.set(DoubleSolenoid.Value.kOff);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public static void lowerArm() {
		
		if (OI.joyPilot.getRawButton(1)) {
	    	rightArm.set(DoubleSolenoid.Value.kForward);
	    	leftArm.set(DoubleSolenoid.Value.kForward);
		}

    }
    
    public static void raiseArm() {
    	
		if (OI.joyPilot.getRawButton(2)) {
	    	rightArm.set(DoubleSolenoid.Value.kReverse);
	    	leftArm.set(DoubleSolenoid.Value.kReverse);
		}

    }
}


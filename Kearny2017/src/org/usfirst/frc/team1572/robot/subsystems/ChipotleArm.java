package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ChipotleArm extends Subsystem {
	// Blame Donald ^
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	DoubleSolenoid rightArm = RobotMap.rightArm;
    	DoubleSolenoid leftArm = RobotMap.leftArm;
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


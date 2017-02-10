package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.OI;
import org.usfirst.frc.team1572.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ChipotleArm extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public final static DoubleSolenoid Arm = RobotMap.Arm;
	
    @Override
	public void initDefaultCommand() {
    	Arm.set(DoubleSolenoid.Value.kOff);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public static void lowerArm() {
		
		
	    Arm.set(DoubleSolenoid.Value.kForward);
		

    }
    
    public static void raiseArm() {
    	
		
	    Arm.set(DoubleSolenoid.Value.kReverse);
		

    }
}


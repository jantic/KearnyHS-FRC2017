package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ChipotleArmSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public final static DoubleSolenoid Arm = RobotMap.Arm;
	//TODO:  Not threadsafe
	private static boolean clawDown;
	
    @Override
	public void initDefaultCommand() {
    	Arm.set(DoubleSolenoid.Value.kOff);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void lowerArm() {
    	
	    Arm.set(DoubleSolenoid.Value.kForward);
	    clawDown = true;
    	
    }
    
    public void raiseArm() {
    	
	    Arm.set(DoubleSolenoid.Value.kReverse);
	    clawDown = false;
    	
    }
    public boolean clawDown(){
    	return clawDown;
    }
}
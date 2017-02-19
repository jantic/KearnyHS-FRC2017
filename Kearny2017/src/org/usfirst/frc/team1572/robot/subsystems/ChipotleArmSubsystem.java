package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ChipotleArmSubsystem extends Subsystem {
	private final DoubleSolenoid arm = RobotMap.Arm;
	
    @Override
	public void initDefaultCommand() {
    	//Do nothing
    }
    
    public void lowerArm() {	
	    this.arm.set(DoubleSolenoid.Value.kForward); 	
    }
    
    public void raiseArm() {	
	    this.arm.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void stop() {
    	this.arm.set(DoubleSolenoid.Value.kOff);
    }
}
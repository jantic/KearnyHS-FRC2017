package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClawHandSubsystem extends Subsystem {
	private final DoubleSolenoid claw = RobotMap.clawHand;

    @Override
	public void initDefaultCommand() {
    	//DO Nothing
    }
    
    public void openClaw() {
        this.claw.set(DoubleSolenoid.Value.kForward);
    }
    
    public void closeClaw() {   	
        this.claw.set(DoubleSolenoid.Value.kReverse);	
    }
    
    public void stop(){
    	this.claw.set(DoubleSolenoid.Value.kOff);
    }
}

package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawHand extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	DoubleSolenoid claw = RobotMap.clawHand;
	
    public void initDefaultCommand() {
    	claw.set(DoubleSolenoid.Value.kOff);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void openClaw() {
    	claw.set(DoubleSolenoid.Value.kForward);
    }
    public void closeClaw() {
    	claw.set(DoubleSolenoid.Value.kReverse);
    }
}
//82984285
package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.OI;
import org.usfirst.frc.team1572.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClawHand extends Subsystem {
public final static DoubleSolenoid claw = RobotMap.clawHand;
    private static boolean clawOpen;
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
		
    @Override
	public void initDefaultCommand() {
    	claw.set(DoubleSolenoid.Value.kOff);
        
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public static void openClaw() {
    	
        claw.set(DoubleSolenoid.Value.kForward);
        clawOpen = true;
    	
    }
    
    public static void closeClaw() {
    	
        claw.set(DoubleSolenoid.Value.kReverse);
        clawOpen = false;
    	
    }
    public static boolean clawOpen(){
    	return clawOpen;
    }
}
//82984285
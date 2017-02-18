package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClawIntakeSubsystem extends Subsystem {
	private final static Victor clawIntake = RobotMap.clawIntake;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    @Override
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void clawIntake() {
        clawIntake.set(0.75);      
    }

    public void stopIntake() {
    	
    	clawIntake.set(0);
    	
    }
    
    public void reverseIntake() {
    	
    	clawIntake.set(-0.75);
    	
    }

}


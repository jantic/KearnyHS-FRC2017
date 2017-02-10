package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.OI;
import org.usfirst.frc.team1572.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallHopper extends Subsystem {
	private final static Victor hopper = RobotMap.ballHopper;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    @Override
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public static void ballIntake() {
    	if (OI.joyPilot.getRawButton(5) || OI.joyCoPilot.getRawButton(3)) {
    		
    		hopper.set(-0.75);
    	}
    	else{
    		hopper.set(0);
    	}
    }
}


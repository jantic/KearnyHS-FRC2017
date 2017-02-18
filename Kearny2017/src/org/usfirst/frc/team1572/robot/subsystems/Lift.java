package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lift extends Subsystem {
	private static Victor lift = RobotMap.lift;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    @Override
	public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public static void Lifter() {
    	lift.set(-1);
    }
    public static void stopLifter() {
    	lift.set(0);
    }
    public static void reverseLifter() {
    	lift.set(1);
    }

}


package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	Victor lift = RobotMap.lift;
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


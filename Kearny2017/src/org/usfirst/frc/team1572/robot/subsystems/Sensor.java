package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.RobotMap;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sensor extends Subsystem {
	
	Ultrasonic ultra = RobotMap.sensor;
    	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


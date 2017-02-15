package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.RobotMap;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Sensor extends Subsystem {
	
	//static Ultrasonic ultra = RobotMap.sensor;
    	

    @Override
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public static void getDistance(){
		//double distance = ultra.pidGet();
    	//return distance;
    }
}

//oh no! i forgot the -2!

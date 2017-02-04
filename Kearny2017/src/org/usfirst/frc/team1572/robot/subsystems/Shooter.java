package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.OI;
import org.usfirst.frc.team1572.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	public static CANTalon shooter = RobotMap.shooter;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public static void shoot() {
    	if (OI.joyPilot.getRawButton(5)) {
    		shooter.set(0.75);
    	}
    }
}


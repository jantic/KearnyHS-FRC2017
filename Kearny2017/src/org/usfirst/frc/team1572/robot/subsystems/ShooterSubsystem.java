package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterSubsystem extends Subsystem {
	private static final CANTalon shooter = RobotMap.shooter;
	private static final Victor shooterIntake = RobotMap.shooterIntake;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    @Override
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void shoot() {
    	shooter.set(0.75);
    	shooterIntake.set(1);
    }
    public void stopshoot() {
    	shooter.set(0);
    	shooterIntake.set(0);
    }
}


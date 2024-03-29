package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallHopperSubysystem extends Subsystem {

	private final static Victor hopper = RobotMap.ballHopper;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    @Override
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void run() {
    	hopper.set(-0.75);
    }
    public void stop() {
    	hopper.set(0);
    }
    public void reverse() {
    	hopper.set(0.5);
    }
}


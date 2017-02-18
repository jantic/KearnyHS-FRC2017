package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.RobotMap;
import org.usfirst.frc.team1572.robot.commands.StreamEncoderOutput;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class EncoderSubsystem extends Subsystem {

	private final Encoder encoder = RobotMap.encoder;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    @Override
	public void initDefaultCommand() {
        setDefaultCommand(new StreamEncoderOutput());
    }
    
    public void reset(){
    	this.encoder.reset();
    }
    
    public double getDistanceDriven() {
    	return this.encoder.getDistance();
    }
    
    public int getScale() {
    	return this.encoder.getEncodingScale();
    }
    
    
}


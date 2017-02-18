package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.commands.StreamHeadingOutput;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

//This makes it so that only one camera is running at a time (saves bandwidth), 
//and controls access to each one.
public class HeadingSubsystem extends Subsystem{
	private final AHRS navxSensor;
	
	public HeadingSubsystem(){
		this.navxSensor  = new AHRS(SPI.Port.kMXP);
	}
	
	public void reset(){
		this.navxSensor.reset();
		this.navxSensor.resetDisplacement();
	}
	//-180 to 180
	public double getAngle(){
		return this.navxSensor.getAngle();
	}
	
	public double getCompassHeading(){
		return this.navxSensor.getCompassHeading();
	}

	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new StreamHeadingOutput());	
	}
}

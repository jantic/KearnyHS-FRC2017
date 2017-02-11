package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.commands.StreamNavigationOutput;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

//This makes it so that only one camera is running at a time (saves bandwidth), 
//and controls access to each one.
public class NavigationSubsystem extends Subsystem{
	private final AHRS navigationSensor  = new AHRS(SPI.Port.kMXP);
	
	public void reset(){
		this.navigationSensor.reset();
	}
	
	public float getDisplacementX(){
		return this.navigationSensor.getDisplacementX();
	}
	
	public float getDisplacementY(){
		return this.navigationSensor.getDisplacementX();
	}
	
	public double getAngle(){
		return this.navigationSensor.getAngle();
	}
	
	public double getCompassHeading(){
		return this.navigationSensor.getCompassHeading();
	}
	
	public float getVelocityX(){
		return this.navigationSensor.getVelocityX();
	}
	
	public float getVelocityY(){
		return this.navigationSensor.getVelocityY();
	}

	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new StreamNavigationOutput());	
	}
}

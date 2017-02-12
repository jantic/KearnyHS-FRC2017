package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.commands.StreamNavigationOutput;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

//This makes it so that only one camera is running at a time (saves bandwidth), 
//and controls access to each one.
public class NavigationSubsystem extends Subsystem{
	private final AHRS navigationSensor;
	
	public NavigationSubsystem(){
		this.navigationSensor  = new AHRS(SPI.Port.kMXP);
	}
	
	public void reset(){
		this.navigationSensor.reset();
		this.navigationSensor.resetDisplacement();
	}
	
	//Meters
	public float getDisplacementX(){
		return this.navigationSensor.getDisplacementX();
	}
	
	//Meters
	public float getDisplacementY(){
		//return this.navigationSensor.getDisplacementY();
		return this.navigationSensor.getDisplacementY();
	}
	
	//-180 to 180
	public double getAngle(){
		return this.navigationSensor.getAngle();
	}
	
	public double getCompassHeading(){
		return this.navigationSensor.getCompassHeading();
	}
	
	//Meters/Second
	public float getVelocityX(){
		return this.navigationSensor.getVelocityX();
	}
	
	//Meters/Second
	public float getVelocityY(){
		return this.navigationSensor.getVelocityY();
	}

	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new StreamNavigationOutput());	
	}
}

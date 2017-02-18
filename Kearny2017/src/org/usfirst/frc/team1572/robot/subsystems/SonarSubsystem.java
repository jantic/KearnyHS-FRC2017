package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.RobotMap;
import org.usfirst.frc.team1572.robot.commands.StreamSonarOutput;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SonarSubsystem extends Subsystem {
	
	private final AnalogInput sonarSensor = RobotMap.sonarSensor;
    	
    @Override
	public void initDefaultCommand() {
    	setDefaultCommand(new StreamSonarOutput());
    }
    
    public double getDistance(){
    	double voltsPerInch = 5.0/512.0;
		double volt =  this.sonarSensor.getAverageVoltage();
		double rangeInInches = volt / voltsPerInch;
		return rangeInInches;
    }
}


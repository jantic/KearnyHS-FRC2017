package org.usfirst.frc.team1572.robot.subsystems;

import org.usfirst.frc.team1572.robot.RobotMap;
import org.usfirst.frc.team1572.robot.commands.streaming.StreamShooterOutput;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterSubsystem extends Subsystem {
	private final CANTalon shooter = RobotMap.shooter;
	private final Victor shooterIntake = RobotMap.shooterIntake;
	private Double targetRpm = new Double(0.0);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public ShooterSubsystem(){
        this.shooter.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        this.shooter.reverseSensor(true);
        this.shooter.configEncoderCodesPerRev(3);
        this.shooter.configNominalOutputVoltage(+0.0f, -0.0f);
        this.shooter.configPeakOutputVoltage(+12.0f, -12.0f);
        this.shooter.setVoltageRampRate(0.25);
        this.shooter.setProfile(0);
        this.shooter.enableBrakeMode(false);
        this.shooter.setPosition(0);
        this.shooter.setVoltageRampRate(24);
        this.shooter.changeControlMode(TalonControlMode.Speed);
        this.shooter.setF(0.003);
        this.shooter.setP(0.0005);
        this.shooter.setI(0.00005);
        this.shooter.setD(0.01);
	}

    @Override
	public void initDefaultCommand() {
        setDefaultCommand(new StreamShooterOutput());
    }

    public void spinUpShooter(final double rpm) {
    	synchronized(this.targetRpm){
    		this.targetRpm = new Double(rpm);
    		
    		this.shooter.set(-rpm);
    		//TODO: Shooting will call another motor to push ball into spinner
    	}
    	//this.shooterIntake.set(1);
    }
    
    public void startShooting() {
    	this.shooterIntake.set(-1);	
    }
    
    public void stopShooting() {
    	this.shooterIntake.set(0); 	
    }
    
    public double getCurrentRPM(){
    	return -this.shooter.getSpeed();
    }
    
    public double getTargetRPM(){
    	synchronized(this.targetRpm){
    		return this.targetRpm.doubleValue();
    	}
    }
    
    public void stopAll() {
    	synchronized(this.targetRpm){
    		this.targetRpm = new Double(0);
    	}
		this.shooter.set(0);
    	this.shooterIntake.set(0);
    }
    
	public boolean isAtTargetRPM() {
		if (this.getTargetRPM() >= this.getCurrentRPM()) {
			return true;
		}
		return false;
	}
	
}


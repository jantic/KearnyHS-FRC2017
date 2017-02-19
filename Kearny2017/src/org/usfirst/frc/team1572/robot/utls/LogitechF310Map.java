package org.usfirst.frc.team1572.robot.utls;

import edu.wpi.first.wpilibj.Joystick;

public class LogitechF310Map {
	
	private Joystick stick;
	
	public LogitechF310Map() {
		
	}
	
	public boolean getButtonA(Joystick stick) {
		//System.out.println("A = " + stick.getRawButton(1));
		return stick.getRawButton(1);
	}
	
	public boolean getButtonB(Joystick stick) {
		//System.out.println("B = " + stick.getRawButton(2));
		return stick.getRawButton(2);
	}
	
	public boolean getButtonX(Joystick stick) {
		//System.out.println("X = " + stick.getRawButton(3));
		return stick.getRawButton(3);
	}
	
	public boolean getButtonY(Joystick stick) {
		//System.out.println("Y = " + stick.getRawButton(4));
		return stick.getRawButton(4);
	}
	
	public boolean getButtonLB(Joystick stick) {
		//System.out.println("LB = " + stick.getRawButton(5));
		return stick.getRawButton(5);
	}
	
	public boolean getButtonRB(Joystick stick) {
		//System.out.println("RB = " + stick.getRawButton(6));
		return stick.getRawButton(6);
	}
	
	public boolean getButtonBack(Joystick stick) {
		//System.out.println("BACK = " + stick.getRawButton(7));
		return stick.getRawButton(7);
	}
	
	public boolean getButtonStart(Joystick stick) {
		//System.out.println("START = " + stick.getRawButton(8));
		return stick.getRawButton(8);
	}
	
	public boolean getButtonL3(Joystick stick) {
		//System.out.println("L3 = " + stick.getRawButton(9));
		return stick.getRawButton(9);
	}
	
	public boolean getButtonR3(Joystick stick) {
		//System.out.println("R3 = " + stick.getRawButton(10));
		return stick.getRawButton(10);
	}
	
	public double getLeftXAxis(Joystick stick) {
		//System.out.println("LX = " + stick.getRawAxis(0));
		return stick.getRawAxis(0);
	}
	
	public double getLeftYAxis(Joystick stick) {
		//System.out.println("LY = " + stick.getRawAxis(1));
		return stick.getRawAxis(1);
	}
	
	public double getLeftTrigger(Joystick stick) {
		//System.out.println("LT = " + stick.getRawAxis(2));
		return stick.getRawAxis(2);
	}
	
	public double getRightTrigger(Joystick stick) {
		//System.out.println("RT = " + stick.getRawAxis(3));
		return stick.getRawAxis(3);
	}
	
	public double getRightXAxis(Joystick stick) {
		//System.out.println("RX = " + stick.getRawAxis(4));
		return stick.getRawAxis(4);
	}
	
	public double getRightYAxis(Joystick stick) {
		//System.out.println("RY = " + stick.getRawAxis(5));
		return stick.getRawAxis(5);
	}
	
	//public void getPOV() {
	//	for (int i=0; i < stick.getPOVCount(); ++i) {
	//		System.out.println("POV " + i + " = " + stick.getPOV(i));
	//	}
	//}
	
}

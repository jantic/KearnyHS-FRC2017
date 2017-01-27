package org.usfirst.frc.team1572.robot.utls;

import edu.wpi.first.wpilibj.Joystick;

public class LogitechF310Map {
	
	private Joystick m_stick;
	
	public LogitechF310Map(Joystick stick) {
		m_stick = stick;
		//m_stick.getButtonCount();
	}
	
	public boolean getButtonA() {
		//System.out.println("A = " + m_stick.getRawButton(1));
		return m_stick.getRawButton(1);
	}
	
	public boolean getButtonB() {
		//System.out.println("B = " + m_stick.getRawButton(2));
		return m_stick.getRawButton(2);
	}
	
	public boolean getButtonX() {
		//System.out.println("X = " + m_stick.getRawButton(3));
		return m_stick.getRawButton(3);
	}
	
	public boolean getButtonY() {
		//System.out.println("Y = " + m_stick.getRawButton(4));
		return m_stick.getRawButton(4);
	}
	
	public boolean getButtonLB() {
		//System.out.println("LB = " + m_stick.getRawButton(5));
		return m_stick.getRawButton(5);
	}
	
	public boolean getButtonRB() {
		//System.out.println("RB = " + m_stick.getRawButton(6));
		return m_stick.getRawButton(6);
	}
	
	public boolean getButtonBack() {
		//System.out.println("BACK = " + m_stick.getRawButton(7));
		return m_stick.getRawButton(7);
	}
	
	public boolean getButtonStart() {
		//System.out.println("START = " + m_stick.getRawButton(8));
		return m_stick.getRawButton(8);
	}
	
	public boolean getButtonL3() {
		//System.out.println("L3 = " + m_stick.getRawButton(9));
		return m_stick.getRawButton(9);
	}
	
	public boolean getButtonR3() {
		//System.out.println("R3 = " + m_stick.getRawButton(10));
		return m_stick.getRawButton(10);
	}
	
	public double getLeftXAxis() {
		//System.out.println("LX = " + m_stick.getRawAxis(0));
		return m_stick.getRawAxis(0);
	}
	
	public double getLeftYAxis() {
		//System.out.println("LY = " + m_stick.getRawAxis(1));
		return m_stick.getRawAxis(1);
	}
	
	public double getLeftTrigger() {
		//System.out.println("LT = " + m_stick.getRawAxis(2));
		return m_stick.getRawAxis(2);
	}
	
	public double getRightTrigger() {
		//System.out.println("RT = " + m_stick.getRawAxis(3));
		return m_stick.getRawAxis(3);
	}
	
	public double getRightXAxis() {
		//System.out.println("RX = " + m_stick.getRawAxis(4));
		return m_stick.getRawAxis(4);
	}
	
	public double getRightYAxis() {
		//System.out.println("RY = " + m_stick.getRawAxis(5));
		return m_stick.getRawAxis(5);
	}
	
	//public void getPOV() {
	//	for (int i=0; i < m_stick.getPOVCount(); ++i) {
			System.out.println("POV " + i + " = " + m_stick.getPOV(i));
	//	}
	//}
	
}

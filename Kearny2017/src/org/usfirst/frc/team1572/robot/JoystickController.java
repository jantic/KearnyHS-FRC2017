package org.usfirst.frc.team1572.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class JoystickController {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.

	private final Joystick joystick;
	private final Button button1;
	private final Button button2;
	private final Button button3;
	private final Button button4;
	private final Button button5;	
	private final Button button6;
	private final Button button7;
	private final Button button8;
	private final Button button9;

	public static JoystickController MAIN_JOYSTICK = new JoystickController(0);
	public static JoystickController COPILOT_JOYSTICK = new JoystickController(1);
	
	private JoystickController(final int port){
		this.joystick = new Joystick(port);
		this.button1 = new JoystickButton(this.joystick, 1);
		this.button2 = new JoystickButton(this.joystick, 2);
		this.button3 = new JoystickButton(this.joystick, 3);
		this.button4 = new JoystickButton(this.joystick, 4);
		this.button5 = new JoystickButton(this.joystick, 5);	
		this.button6 = new JoystickButton(this.joystick, 6);
		this.button7 = new JoystickButton(this.joystick, 7);
		this.button8 = new JoystickButton(this.joystick, 8);
		this.button9 = new JoystickButton(this.joystick, 9);
	}
	
	public double getLeftStickX(){
		return this.joystick.getRawAxis(0);
	}
	
	public double getLeftStickY(){
		return this.joystick.getRawAxis(1);
	}
	
	public double getLeftTrigger(){
		return this.joystick.getRawAxis(2);
	}
	
	public double getRightTrigger(){
		return this.joystick.getRawAxis(3);
	}
	
	public boolean getButton1(){
		return this.button1.get();
	}
	
	public boolean getButton2(){
		return this.button2.get();
	}
	
	public boolean getButton3(){
		return this.button3.get();
	}
	
	
	public boolean getButton4(){
		return this.button4.get();
	}
	
	
	public boolean getButton5(){
		return this.button5.get();
	}
	
	
	public boolean getButton6(){
		return this.button6.get();
	}
	
	
	public boolean getButton7(){
		return this.button7.get();
	}
	
	
	public boolean getButton8(){
		return this.button8.get();
	}
	
	
	public boolean getButton9(){
		return this.button9.get();
	}
	
	//button.whenPressed(new Robot.drivedistance(10));
	

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

}

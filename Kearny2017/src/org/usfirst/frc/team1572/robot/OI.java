package org.usfirst.frc.team1572.robot;

import org.usfirst.frc.team1572.robot.RobotMap;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.

	public final static Joystick joyPilot = new Joystick(0);
	public final static Joystick joyCoPilot = new Joystick(1);
	//private final static Button button = new JoystickButton(joyPilot, 2);
	//private final static Button button2 = new JoystickButton(joyPilot, 3);
	
	public static void init() {
		
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
	public Joystick getJoyPilot() {
	    return joyPilot;
	}
	public Joystick getJoyCoPilot() {
		return joyCoPilot;
	}

}

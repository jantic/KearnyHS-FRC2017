package org.usfirst.frc.team1572.robot;

import org.usfirst.frc.team1572.robot.commands.main.GearGrabClose;
import org.usfirst.frc.team1572.robot.commands.main.GearGrabOpen;
import org.usfirst.frc.team1572.robot.commands.main.RunLifterBackwards;
import org.usfirst.frc.team1572.robot.commands.main.RunLifterForwards;
import org.usfirst.frc.team1572.robot.commands.main.ShootCloseStart;
import org.usfirst.frc.team1572.robot.commands.main.ShootEnd;
import org.usfirst.frc.team1572.robot.commands.main.StopLifter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class JoystickController {
	private final Joystick joystick;
	public static JoystickController MAIN_JOYSTICK = generateMainJoystick();
	public static JoystickController COPILOT_JOYSTICK = generateCoPilotJoystick();
	
	private static JoystickController generateMainJoystick(){
		final Joystick joystick = new Joystick(0);	
		//TODO:  Figure out a button mapping for GearRelease
		setButtonBehavior(joystick, 1, new GearGrabOpen(), new GearGrabClose());
		setButtonBehavior(joystick, 4, new RunLifterBackwards(), new StopLifter());		
		return new JoystickController(joystick);
	}

	private static JoystickController generateCoPilotJoystick(){
		final Joystick joystick = new Joystick(1);
		setButtonBehavior(joystick, 1, new ShootCloseStart(), new ShootEnd());
		setButtonBehavior(joystick, 2, new RunLifterForwards(), new StopLifter());
		//TODO:  Figure out a button mapping for GearRelease
		setButtonBehavior(joystick, 4, new GearGrabOpen(), new GearGrabClose());
		setButtonBehavior(joystick, 8, new RunLifterBackwards(), new StopLifter());
		return new JoystickController(joystick);
	}
	
	private static void setButtonBehavior(final Joystick joystick, final int buttonNum, 
			final Command whileHeldCommand, final Command whenReleasedCommand){
		final Button button = new JoystickButton(joystick, buttonNum);
		button.whileHeld(whileHeldCommand);
		button.whenReleased(whenReleasedCommand);
	}
	
	private JoystickController(final Joystick joystick){
		this.joystick = joystick;
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
}

package org.usfirst.frc.team1572.robot;

import org.usfirst.frc.team1572.robot.commands.HopperIntake;
import org.usfirst.frc.team1572.robot.commands.HopperIntakeOff;
import org.usfirst.frc.team1572.robot.commands.HopperReverseIntake;
import org.usfirst.frc.team1572.robot.commands.main.AimForPegManually;
import org.usfirst.frc.team1572.robot.commands.main.ClawUp;
import org.usfirst.frc.team1572.robot.commands.main.GearGrabClose;
import org.usfirst.frc.team1572.robot.commands.main.GearGrabOpen;
import org.usfirst.frc.team1572.robot.commands.main.GearRelease;
import org.usfirst.frc.team1572.robot.commands.main.RunLifterForwards;
import org.usfirst.frc.team1572.robot.commands.main.ShootClose;
import org.usfirst.frc.team1572.robot.commands.main.ShootFar;
import org.usfirst.frc.team1572.robot.commands.main.StopLifter;
import org.usfirst.frc.team1572.robot.commands.main.StopShooting;
import org.usfirst.frc.team1572.robot.commands.streaming.StreamGearCamera;
import org.usfirst.frc.team1572.robot.commands.streaming.StreamPegCamera;

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
		setButtonBehavior(joystick, JoystickButtonMap.A, new GearGrabOpen(), new GearGrabClose());
		setButtonBehavior(joystick,JoystickButtonMap.B, new GearRelease(), new ClawUp());
		setButtonBehavior(joystick, JoystickButtonMap.X, new HopperIntake(), new HopperIntakeOff());
		setButtonBehavior(joystick, JoystickButtonMap.Y, new RunLifterForwards(), new StopLifter());	
		setButtonBehavior(joystick, JoystickButtonMap.LB, new AimForPegManually());
		
		return new JoystickController(joystick);
	}

	private static JoystickController generateCoPilotJoystick(){
		final Joystick joystick = new Joystick(1);
		setButtonBehavior(joystick, JoystickButtonMap.six, new ShootClose(), new StopShooting());
		setButtonBehavior(joystick, JoystickButtonMap.one, new ShootFar(), new StopShooting());
		//Note: want to spin up shooter and automatically fire when target rpm is reached
		setButtonBehavior(joystick, JoystickButtonMap.two, new RunLifterForwards(), new StopLifter());
		
		setButtonBehavior(joystick, JoystickButtonMap.three, new HopperIntake(), new HopperIntakeOff());
		setButtonBehavior(joystick,JoystickButtonMap.five, new GearRelease(), new ClawUp());
		//TODO:  Figure out a button mapping for GearRelease
		setButtonBehavior(joystick, JoystickButtonMap.four, new GearGrabOpen(), new GearGrabClose());
		setButtonBehavior(joystick, JoystickButtonMap.seven, new StreamPegCamera(), new StreamGearCamera());
		setButtonBehavior(joystick, JoystickButtonMap.eight, new HopperReverseIntake(), new HopperIntakeOff());
		//setButtonBehavior(joystick, 5, new RunLifterBackwards(), new StopLifter());
		return new JoystickController(joystick);
	}
	
	private static void setButtonBehavior(final Joystick joystick, final JoystickButtonMap buttonMap, final Command whileHeldCommand) {
		final Button button = new JoystickButton(joystick, buttonMap.getButtonNumber());
		button.whileHeld(whileHeldCommand);
	}
	
	private static void setButtonBehavior(final Joystick joystick, final JoystickButtonMap buttonMap, 
										  final Command whileHeldCommand, final Command whenReleasedCommand) {
		final Button button = new JoystickButton(joystick, buttonMap.getButtonNumber());
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

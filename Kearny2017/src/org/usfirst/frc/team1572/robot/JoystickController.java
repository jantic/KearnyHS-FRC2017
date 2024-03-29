package org.usfirst.frc.team1572.robot;

import org.usfirst.frc.team1572.robot.commands.main.AimForPegManually;
import org.usfirst.frc.team1572.robot.commands.main.ClawDown;
import org.usfirst.frc.team1572.robot.commands.main.ClawIntake;
import org.usfirst.frc.team1572.robot.commands.main.ClawIntakeReverse;
import org.usfirst.frc.team1572.robot.commands.main.ClawUp;
import org.usfirst.frc.team1572.robot.commands.main.CloseClaw;
import org.usfirst.frc.team1572.robot.commands.main.GearGrabClose;
import org.usfirst.frc.team1572.robot.commands.main.GearGrabOpen;
import org.usfirst.frc.team1572.robot.commands.main.GearRelease;
import org.usfirst.frc.team1572.robot.commands.main.HopperIntake;
import org.usfirst.frc.team1572.robot.commands.main.HopperIntakeOff;
import org.usfirst.frc.team1572.robot.commands.main.HopperReverseIntake;
import org.usfirst.frc.team1572.robot.commands.main.OpenClaw;
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
		setButtonBehavior(joystick, JoystickButtonMap.RB, new OpenClaw(), new CloseClaw());
		setButtonBehavior(joystick, JoystickButtonMap.LB, new ClawDown(), new ClawUp());
		return new JoystickController(joystick);
	}

	private static JoystickController generateCoPilotJoystick(){
		final Joystick joystick = new Joystick(1);
		//setButtonBehavior(joystick, JoystickButtonMap.six, new ShootClose(), new StopShooting());
		setButtonBehavior(joystick, JoystickButtonMap.one, new ShootFar(), new StopShooting());
		//Note: want to spin up shooter and automatically fire when target rpm is reached
		setButtonBehavior(joystick, JoystickButtonMap.two, new RunLifterForwards(), new StopLifter());
		
		setButtonBehavior(joystick, JoystickButtonMap.three, new HopperIntake(), new HopperIntakeOff());
		setButtonBehavior(joystick,JoystickButtonMap.five, new GearRelease(), new ClawUp());
		//TODO:  Figure out a button mapping for GearRelease
		setButtonBehavior(joystick, JoystickButtonMap.four, new GearGrabOpen(), new GearGrabClose());
		//setButtonBehavior(joystick, JoystickButtonMap.seven, new StreamPegCamera(), new StreamGearCamera());
		setButtonBehavior(joystick, JoystickButtonMap.six, new HopperReverseIntake(), new HopperIntakeOff());
		//setButtonBehavior(joystick, 5, new RunLifterBackwards(), new StopLifter());
		setButtonBehavior(joystick, JoystickButtonMap.eight, new ClawDown(), new ClawUp());
		//setButtonBehavior(joystick, JoystickButtonMap.nine, new OpenClaw(), new CloseClaw());
		setButtonBehavior(joystick, JoystickButtonMap.nine, new ClawIntake(), new ClawIntakeReverse());
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

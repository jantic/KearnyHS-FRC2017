package org.usfirst.frc.team1572.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1572.vision.GearTargetAutoAim;
import org.usfirst.frc.team1572.vision.IAutoAim;
import org.usfirst.frc.team1572.vision.PegTargetAutoAim;
import org.usfirst.frc.team1572.vision.VisionCenteringCommand;

/**
 * This is a demo program showing the use of OpenCV to do vision processing. The
 * image is acquired from the USB camera, then a rectangle is put on the image
 * and sent to the dashboard. OpenCV has many methods for different types of
 * processing.
 */
public class Robot extends IterativeRobot {
	Thread visionThread;

	@Override
	public void robotInit() {
		this.visionThread = new Thread(() -> {
			final IAutoAim pegAutoAim = new PegTargetAutoAim();
			final IAutoAim gearAutoAim = new GearTargetAutoAim();
			
			while (!Thread.interrupted()) {
				final VisionCenteringCommand pegCenteringCommand = pegAutoAim.generateCenteringCommand();
				SmartDashboard.putString("Peg Centering Command", pegCenteringCommand.name());					
				final VisionCenteringCommand gearCenteringCommand = gearAutoAim.generateCenteringCommand();
				SmartDashboard.putString("Gear Centering Command", gearCenteringCommand.name());
			}
		});
		this.visionThread.setDaemon(true);
		this.visionThread.start();
	}
}

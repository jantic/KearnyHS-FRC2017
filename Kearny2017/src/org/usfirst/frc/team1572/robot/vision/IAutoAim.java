package org.usfirst.frc.team1572.robot.vision;

import org.opencv.core.Mat;

public interface IAutoAim {

	VisionCenteringCommand generateCenteringCommand(final Mat latestImage);

}
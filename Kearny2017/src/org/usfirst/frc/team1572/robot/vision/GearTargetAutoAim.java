package org.usfirst.frc.team1572.robot.vision;

import java.util.ArrayList;

import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.usfirst.frc.team1572.robot.vision.grip.GearTargetVision;

public class GearTargetAutoAim implements IAutoAim {
	private final GearTargetVision gearTargetVision = new GearTargetVision();
	
	@Override
	public VisionCenteringCommand generateCenteringCommand(final Mat imageMatrix){
		this.gearTargetVision.process(imageMatrix);
		final ArrayList<MatOfPoint> gearContours = this.gearTargetVision.filterContoursOutput();
		final Point gearTargetCenter = getGearTargetCenterPoint(gearContours);

		if (gearTargetCenter != null) {
			final Point centerOfView = calculateCenterOfView(this.gearTargetVision);
			return AutoAimUtils.generateCenteringCommand(centerOfView, gearTargetCenter);
		}
		
		return VisionCenteringCommand.NULL;
	}
	
	private static Point calculateCenterOfView(GearTargetVision gearTargetVision){
		final int width = gearTargetVision.cvResizeOutput().width();
		final int height = gearTargetVision.cvResizeOutput().height();
		return new Point(width/2, height/2);
	}

	private static Point getGearTargetCenterPoint(final ArrayList<MatOfPoint> contours) {
		AutoAimUtils.sortByArea(contours);

		if (contours.size() >= 1) {
			return AutoAimUtils.getRectangleCenterPoint(contours.get(0));
		}

		return null;
	}
}

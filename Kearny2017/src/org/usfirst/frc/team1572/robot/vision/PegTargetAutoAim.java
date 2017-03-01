package org.usfirst.frc.team1572.robot.vision;

import java.util.ArrayList;

import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.usfirst.frc.team1572.robot.vision.grip.PegTargetVision;

public class PegTargetAutoAim implements IAutoAim {
	private final PegTargetVision pegTargetVision = new PegTargetVision();
	
	@Override
	public VisionCenteringCommand generateCenteringCommand(final Mat imageMatrix){
		this.pegTargetVision.process(imageMatrix);
		final ArrayList<MatOfPoint> pegContours = this.pegTargetVision.filterContoursOutput();
		final Point pegTargetCenter = getPegTargetCenterPoint(pegContours);

		if (pegTargetCenter != null) {
			final Point centerOfView = calculateCenterOfView(this.pegTargetVision);
			return AutoAimUtils.generateCenteringCommand(centerOfView, pegTargetCenter);
		}
		
		return VisionCenteringCommand.NULL;
	}
	public double centerError(final Mat imageMatrix) {
		this.pegTargetVision.process(imageMatrix);
		final ArrayList<MatOfPoint> pegContours = this.pegTargetVision.filterContoursOutput();
		final Point pegTargetCenter = getPegTargetCenterPoint(pegContours);

		if (pegTargetCenter != null) {
			final Point centerOfView = calculateCenterOfView(this.pegTargetVision);
			return AutoAimUtils.getVisionError(centerOfView, pegTargetCenter);
		}
		//return null
		return -10000;
	}
	
	private static Point calculateCenterOfView(final PegTargetVision pegTargetVision){
		final int width = pegTargetVision.cvResizeOutput().width();
		final int height = pegTargetVision.cvResizeOutput().height();
		return new Point(width/2, height/2);
	}

	private static Point getPegTargetCenterPoint(final ArrayList<MatOfPoint> contours){
		AutoAimUtils.sortByArea(contours);
		
		if(contours.size() >= 2){
			final Point centerPoint1 = AutoAimUtils.getRectangleCenterPoint(contours.get(0));
			final Point centerPoint2 = AutoAimUtils.getRectangleCenterPoint(contours.get(1));
			final double averageX = (centerPoint1.x + centerPoint2.x)/2;
			final double averageY = (centerPoint1.y + centerPoint2.y)/2;
			return new Point(averageX, averageY);
		}
		
		return null;
	}
}

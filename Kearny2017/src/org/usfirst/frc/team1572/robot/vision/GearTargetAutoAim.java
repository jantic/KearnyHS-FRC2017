package org.usfirst.frc.team1572.robot.vision;

import java.util.ArrayList;

import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.usfirst.frc.team1572.robot.vision.camera.CameraType;
import org.usfirst.frc.team1572.robot.vision.camera.EasyCamera;
import org.usfirst.frc.team1572.robot.vision.camera.ImageGrabFailedException;
import org.usfirst.frc.team1572.robot.vision.grip.GearTargetVision;

public class GearTargetAutoAim implements IAutoAim {
	private final EasyCamera easyCamera = EasyCamera.getInstance(CameraType.GEAR_CAMERA);
	private final GearTargetVision gearTargetVision = new GearTargetVision();
	
	@Override
	public VisionCenteringCommand generateCenteringCommand(){
		try{
			final Mat imageMatrix = this.easyCamera.getLatestImage();
			this.gearTargetVision.process(imageMatrix);
			final ArrayList<MatOfPoint> gearContours = this.gearTargetVision.filterContoursOutput();
			final Point gearTargetCenter = getGearTargetCenterPoint(gearContours);
	
			if (gearTargetCenter != null) {
				final Point centerOfView = calculateCenterOfView(this.gearTargetVision);
				return AutoAimUtils.generateCenteringCommand(centerOfView, gearTargetCenter);
			}
		}
		catch(ImageGrabFailedException e){
			System.out.println("Error while grabbing gear camera image:" + e.getMessage());
		}
		catch(Exception e){
			System.out.println("Error while calculating latest gear centering command:" + e.getMessage());
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

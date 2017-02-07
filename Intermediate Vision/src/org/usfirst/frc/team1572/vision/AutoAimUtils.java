package org.usfirst.frc.team1572.vision;

import java.util.ArrayList;
import java.util.Collections;

import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

public class AutoAimUtils {
	private static final double CENTER_TOLERANCE = 8.0;
	
	public static Point getRectangleCenterPoint(final MatOfPoint contour){
		final Rect rectangle = Imgproc.boundingRect(contour);
		final Point centerPoint = new Point(rectangle.br().x - rectangle.width / 2,
				rectangle.br().y - rectangle.height / 2);
		return centerPoint;
	}

	public static void sortByArea(final ArrayList<MatOfPoint> contours) {
		Collections.sort(contours, new ContourComparator());
	}
	
	public static VisionCenteringCommand generateCenteringCommand(final Point centerOfView, final Point objectLocation){
		final double diffX = centerOfView.x - objectLocation.x;

		
		if(diffX > -CENTER_TOLERANCE && diffX < CENTER_TOLERANCE){
			return VisionCenteringCommand.CENTER;
		}
		
		if(diffX > 0){
			return VisionCenteringCommand.LEFT;
		}
		
		return VisionCenteringCommand.RIGHT;
	}
	
}

package org.usfirst.frc.team1572.robot.vision;

import java.util.Comparator;

import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

public class ContourComparator implements Comparator<MatOfPoint> {
	@Override
	public int compare(MatOfPoint c1, MatOfPoint c2) {
		final Rect rectangle1 = Imgproc.boundingRect(c1);
		final Rect rectangle2 = Imgproc.boundingRect(c2);
		return Double.compare(rectangle2.area(), rectangle1.area());
	}
}

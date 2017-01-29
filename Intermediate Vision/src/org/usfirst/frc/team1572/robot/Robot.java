package org.usfirst.frc.team1572.robot;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import vision.PegTargetVision;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

/**
 * This is a demo program showing the use of OpenCV to do vision processing. The
 * image is acquired from the USB camera, then a rectangle is put on the image
 * and sent to the dashboard. OpenCV has many methods for different types of
 * processing.
 */
public class Robot extends IterativeRobot {

	// constants for the color rbg values
	public static final Scalar RED = new Scalar(0, 0, 255), BLUE = new Scalar(255, 0, 0), GREEN = new Scalar(0, 255, 0),
			BLACK = new Scalar(0, 0, 0), YELLOW = new Scalar(0, 255, 255),
			// these are the threshold values in order
			LOWER_BOUNDS = new Scalar(58, 0, 109), UPPER_BOUNDS = new Scalar(93, 255, 240);

	// Constants for known variables
	// the height to the top of the target in first stronghold is 97 inches
	public static final int TOP_TARGET_HEIGHT = 97;
	// the physical height of the camera lens
	public static final int TOP_CAMERA_HEIGHT = 32;

	// camera details, can usually be found on the datasheets of the camera
	public static final double VERTICAL_FOV = 51;
	public static final double HORIZONTAL_FOV = 67;
	public static final double CAMERA_ANGLE = 10;

	Thread visionThread;

	@Override
	public void robotInit() {
		visionThread = new Thread(() -> {
			// Get the UsbCamera from CameraServer
			UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
			// Set the resolution
			camera.setResolution(640, 480);

			// Get a CvSink. This will capture Mats from the camera
			CvSink cvSink = CameraServer.getInstance().getVideo();
			// Setup a CvSource. This will send images back to the Dashboard
			CvSource outputStream = CameraServer.getInstance().putVideo("Rectangle", 640, 480);

			// Mats are very memory expensive. Lets reuse this Mat.
			Mat imageMatrix = new Mat();
			final PegTargetVision pegTargetVision = new PegTargetVision();

			// This cannot be 'true'. The program will never exit if it is. This
			// lets the robot stop this thread when restarting robot code or
			// deploying.
			while (!Thread.interrupted()) {
				// Tell the CvSink to grab a frame from the camera and put it
				// in the source mat. If there is an error notify the output.
				if (cvSink.grabFrame(imageMatrix) == 0) {
					// Send the output the error.
					outputStream.notifyError(cvSink.getError());
					// skip the rest of the current iteration
					continue;
				}
				// Put a rectangle on the image
				// Imgproc.rectangle(mat, new Point(100, 100), new Point(400,
				// 400),
				// new Scalar(255, 255, 255), 5);
				// Give the output stream a new image to display
				// outputStream.putFrame(mat);
				pegTargetVision.process(imageMatrix);
				final ArrayList<MatOfPoint> pegTargetContours = pegTargetVision.filterContoursOutput();
				final Point pegTargetCenter = getPegTargetCenterPoint(pegTargetContours);
				
				if(pegTargetCenter!=null){
					SmartDashboard.putString("Peg Target Center", String.valueOf(pegTargetCenter));
				}
			}
		});
		visionThread.setDaemon(true);
		visionThread.start();
	}

	private Point getPegTargetCenterPoint(final ArrayList<MatOfPoint> contours){
		sortByArea(contours);
		
		if(contours.size() >= 2){
			final Point centerPoint1 = getRectangleCenterPoint(contours.get(0));
			final Point centerPoint2 = getRectangleCenterPoint(contours.get(1));
			final double averageX = (centerPoint1.x + centerPoint2.x)/2;
			final double averageY = (centerPoint1.y + centerPoint2.y)/2;
			return new Point(averageX, averageY);
		}
		
		return null;
	}
	
	private static Point getRectangleCenterPoint(final MatOfPoint contour){
		final Rect rectangle = Imgproc.boundingRect(contour);
		final Point centerPoint = new Point(rectangle.br().x - rectangle.width / 2,
				rectangle.br().y - rectangle.height / 2);
		return centerPoint;
	}

	private static void sortByArea(final ArrayList<MatOfPoint> contours) {
		Collections.sort(contours, new ContourComparator());
	}

	static class ContourComparator implements Comparator<MatOfPoint> {
		public int compare(MatOfPoint c1, MatOfPoint c2) {
			final Rect rectangle1 = Imgproc.boundingRect(c1);
			final Rect rectangle2 = Imgproc.boundingRect(c2);
			return Double.compare(rectangle2.area(), rectangle1.area());
		}
	}
}

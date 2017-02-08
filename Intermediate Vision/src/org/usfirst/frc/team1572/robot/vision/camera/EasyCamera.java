package org.usfirst.frc.team1572.robot.vision.camera;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.opencv.core.Mat;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class EasyCamera {
	private static Map<CameraType, EasyCamera> cameraCache = new ConcurrentHashMap<>();
	private final Mat imageMatrix = new Mat();
	private final CvSink cvSink;
	
	static{
		//TODO:  Will want to spin up two cameras here eventually (by device number?)
		final UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(640, 480);
	}
	
	public static EasyCamera getInstance(final CameraType cameraType){
		if(cameraCache.containsKey(cameraType)){
			return cameraCache.get(cameraType);
		}
		
		final CvSink cvSink = getVideoForCameraType(cameraType);
		final EasyCamera easyCamera = new EasyCamera(cvSink); 
		cameraCache.putIfAbsent(cameraType, easyCamera);
		return cameraCache.get(cameraType);
	}

	private static CvSink getVideoForCameraType(@SuppressWarnings("unused") final CameraType cameraType) {
		//TODO: Will want to get a different camera per cameraType eventually (by device number?) 
		return CameraServer.getInstance().getVideo();
	}
	
	private EasyCamera(final CvSink cvSink){
		this.cvSink = cvSink;
	}
	
	public Mat getLatestImage() throws ImageGrabFailedException{
		if (this.cvSink.grabFrame(this.imageMatrix) == 0) {
			throw new ImageGrabFailedException("Failed to grab image: " + this.cvSink.getError());
		}
		
		return this.imageMatrix;
	}
}

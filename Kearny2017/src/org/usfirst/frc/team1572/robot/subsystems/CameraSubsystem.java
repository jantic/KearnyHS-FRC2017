package org.usfirst.frc.team1572.robot.subsystems;

import org.opencv.core.Mat;
import org.usfirst.frc.team1572.robot.commands.StreamPegCamera;
import org.usfirst.frc.team1572.robot.vision.CameraType;
import org.usfirst.frc.team1572.robot.vision.ImageGrabFailedException;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

//This makes it so that only one camera is running at a time (saves bandwidth), 
//and controls access to each one.
public class CameraSubsystem extends Subsystem{
	private final CameraServer cameraServer = CameraServer.getInstance();
	private final Mat imageMatrix = new Mat(); //reuse due to intense memory usage
	private CameraType currentCameraType = CameraType.NULL;
	private UsbCamera currentCamera = null;
	private CvSink currentCameraVideoFeed = null;

	public void activateCamera(final CameraType cameraType){
		if(this.currentCameraType.equals(cameraType)){
			//nothing to do in this case.
			return;
		}
		
		if(this.currentCamera!=null){
			this.cameraServer.removeCamera(this.currentCamera.getName());
		}
		
		this.currentCameraType = cameraType;
		this.currentCamera = this.cameraServer.startAutomaticCapture(cameraType.getDeviceNum());
		this.currentCamera.setResolution(640, 480);
		this.currentCameraVideoFeed = this.cameraServer.getVideo();
	}
	
	public Mat getLatestImage() throws ImageGrabFailedException{
		final String prefix = "Failed to grab image: ";
		
		if(this.currentCameraType.equals(CameraType.NULL)){
			throw new ImageGrabFailedException(prefix + "Camera needs to be activated before attempting to grab an image");
		}
		
		if(this.currentCameraVideoFeed == null){
			throw new ImageGrabFailedException(prefix + "This shouldn't be happening but somehow you managed to do it.  Congrats!");
		}
		
		if (this.currentCameraVideoFeed.grabFrame(this.imageMatrix) == 0) {
			throw new ImageGrabFailedException(prefix + this.currentCameraVideoFeed.getError());
		}
		
		return this.imageMatrix;
	}

	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new StreamPegCamera());	
	}
}

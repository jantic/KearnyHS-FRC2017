package org.usfirst.frc.team1572.robot.vision;

public enum CameraType {
	PEG_CAMERA(0),
	GEAR_CAMERA(1),
	NULL(-1);
	
	private final int deviceNum;
	
	private CameraType(final int deviceNum){
		this.deviceNum = deviceNum;
	}

	public int getDeviceNum() {
		return this.deviceNum;
	}
}

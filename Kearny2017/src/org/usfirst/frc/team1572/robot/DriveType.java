package org.usfirst.frc.team1572.robot;

public enum DriveType {
	TALON_VELOCITY(true),
	TALON_VOLTAGE(true),
	VICTOR(false);
	
	private final boolean isTalonDrive;
	
	private DriveType(final boolean isTalonDrive){
		this.isTalonDrive = isTalonDrive;
	}

	public boolean isTalonDrive() {
		return isTalonDrive;
	}
}

package org.usfirst.frc.team1572.robot.commands.main;



import org.usfirst.frc.team1572.robot.commands.subtasks.AimBase;
import org.usfirst.frc.team1572.robot.vision.CameraType;
import org.usfirst.frc.team1572.robot.vision.GearTargetAutoAim;
import org.usfirst.frc.team1572.robot.vision.IAutoAim;


public class AimForGearManually extends AimBase {
	private final IAutoAim autoAim = new GearTargetAutoAim();
	public AimForGearManually() {
		super();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		alignRobotToTarget(this.autoAim, CameraType.GEAR_CAMERA);
	}
	
	@Override
	protected boolean isFinished(){
		return true;
	}
}

package org.usfirst.frc.team1572.robot.commands;



import org.usfirst.frc.team1572.robot.vision.CameraType;
import org.usfirst.frc.team1572.robot.vision.IAutoAim;
import org.usfirst.frc.team1572.robot.vision.PegTargetAutoAim;


public class AimForPegManually extends AimBase {
	private final IAutoAim autoAim = new PegTargetAutoAim();
	public AimForPegManually() {
		super();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		alignRobotToTarget(this.autoAim, CameraType.PEG_CAMERA);
	}
	
	@Override
	protected boolean isFinished(){
		return true;
	}
}

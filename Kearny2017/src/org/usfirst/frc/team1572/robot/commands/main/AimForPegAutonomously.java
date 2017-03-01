package org.usfirst.frc.team1572.robot.commands.main;



import org.usfirst.frc.team1572.robot.commands.subtasks.AimBase;
import org.usfirst.frc.team1572.robot.vision.CameraType;
import org.usfirst.frc.team1572.robot.vision.IAutoAim;
import org.usfirst.frc.team1572.robot.vision.PegTargetAutoAim;


public class AimForPegAutonomously extends AimBase {
	private final IAutoAim autoAim = new PegTargetAutoAim();
	public AimForPegAutonomously() {
		super();

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		alignRobotToTargetNotJason(this.autoAim, CameraType.PEG_CAMERA);
		//alignRobotToTarget(this.autoAim, CameraType.PEG_CAMERA);
	}
	
}
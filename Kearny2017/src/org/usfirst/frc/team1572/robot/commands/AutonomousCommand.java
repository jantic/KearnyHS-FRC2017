package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.RobotMap;

import edu.wpi.first.wpilibj.Ultrasonic.Unit;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {
	public boolean midGear =  false;
	public boolean rightGear = false;
	public boolean leftGear = false;
	public boolean testGear = true;
    public AutonomousCommand() {
    	//1 meter

    	if (midGear) {
	    	DriveDistance drive =  new DriveDistance(-0.5, 93);
	    	DriveDistance drive2 = new DriveDistance(-0.5, 12);
	    	AimForPegAutonomously aim = new AimForPegAutonomously();
	    	
	    	Robot.navigationSubsystem.reset();
	    	addSequential(drive);
	    	//Robot.navigationSubsystem.reset();
	    	//addSequential(new TurnUntilAngle(-90, false));
	    	//1 meter
	    	//addSequential(Robot.stop);
	    	
	    	//Robot.navigationSubsystem.reset();
	    	//addSequential(drive2);
	    	Robot.navigationSubsystem.reset();
	    	addSequential(aim);
	    	//need to work with aim for peg
    	}
    	
    	else if (leftGear) {
    		DriveDistance drive =  new DriveDistance(-0.5, 93.3);
	    	DriveDistance drive2 = new DriveDistance(-0.5, 62.4039);
	    	AimForPegAutonomously aim = new AimForPegAutonomously();
	    	
	    	Robot.navigationSubsystem.reset();
	    	addSequential(drive);
	    	Robot.navigationSubsystem.reset();
	    	addSequential(new TurnUntilAngle(-58, false));
	    	//1 meter
	    	//addSequential(Robot.stop);
	    	
	    	Robot.navigationSubsystem.reset();
	    	addSequential(drive2);
	    	Robot.navigationSubsystem.reset();
	    	addSequential(aim);
	    	//need to work with aim for peg
    		
    	}
    	
    	else if (rightGear) {
    		DriveDistance drive =  new DriveDistance(-0.5, 93.3);
	    	DriveDistance drive2 = new DriveDistance(-0.5, 62.4039);
	    	AimForPegAutonomously aim = new AimForPegAutonomously();
	    	
	    	Robot.navigationSubsystem.reset();
	    	addSequential(drive);
	    	Robot.navigationSubsystem.reset();
	    	addSequential(new TurnUntilAngle(-58, true));
	    	//1 meter
	    	//addSequential(Robot.stop);
	    	
	    	Robot.navigationSubsystem.reset();
	    	addSequential(drive2);
	    	Robot.navigationSubsystem.reset();
	    	addSequential(aim);
    		
    	}
    	else if (testGear) {
    		DriveDistance drive =  new DriveDistance(-0.5, 48);
	    	DriveDistance drive2 = new DriveDistance(-0.5, 12);
	    	AimForPegAutonomously aim = new AimForPegAutonomously();
	    	
	    	Robot.navigationSubsystem.reset();
	    	addSequential(drive);
	    	Robot.navigationSubsystem.reset();
	    	addSequential(new TurnUntilAngle(-90, false));
	    	//1 meter
	    	//addSequential(Robot.stop);
	    	
	    	Robot.navigationSubsystem.reset();
	    	addSequential(drive2);
	    	Robot.navigationSubsystem.reset();
	    	addSequential(aim);
    	}
    	else {
    		Robot.joydrive.arcadeDrive(0, 0);
    	}
    }
}
    



        // Add Commands here:
        // e.g. addSequential(new Command1());     double distToGear = Robot.sensor.getDistance();
//													if ( distToGear <= 8) {
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.


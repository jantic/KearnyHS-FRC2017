package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.Robot;
import org.usfirst.frc.team1572.robot.RobotMap;

import edu.wpi.first.wpilibj.Ultrasonic.Unit;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {

    public AutonomousCommand() {
    	//1 meter
    	DriveDistance drive =  new DriveDistance(-0.5, 36);
    	DriveDistanceB drive2 = new DriveDistanceB(-0.5, 36);
    	
    	Robot.navigationSubsystem.reset();
    	addSequential(drive);
    	Robot.navigationSubsystem.reset();
    	addSequential(new TurnUntilAngle(-90, false));
    	//1 meter
    	//addSequential(Robot.stop);
    	
    	Robot.navigationSubsystem.reset();
    	addSequential(drive2);
    	Robot.navigationSubsystem.reset();
    	addSequential(new AimForPegAutonomously());
    	//need to work with aim for peg
    	
    	double distToGear = Robot.sensor.getDistance();
    	
    	if ( distToGear <= 8) {
    		Robot.joydrive.arcadeDrive(0, 0);
    	}
    	else {
    		Robot.joydrive.arcadeDrive(0.5, 0);
    	}
    	
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
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
    }
}

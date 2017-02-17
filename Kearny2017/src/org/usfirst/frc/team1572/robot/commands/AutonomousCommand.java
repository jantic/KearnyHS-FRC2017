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
	    	//need to work with aim for peg
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


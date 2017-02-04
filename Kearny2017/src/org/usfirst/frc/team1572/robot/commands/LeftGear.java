package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftGear extends CommandGroup {

    public LeftGear() {
     
        requires(Robot.joydrive);
    }
  public void LeftGearAuto() {
        	
        	DriveDistance drive = new DriveDistance(93.3);
        	//Add turn here(58 degrees)
        	AutoTurn turn = new AutoTurn(-58);
        	DriveDistance drive2 = new DriveDistance(62.4039);
            	
        	drive.execute();
        	turn.execute();
        	drive2.execute();
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

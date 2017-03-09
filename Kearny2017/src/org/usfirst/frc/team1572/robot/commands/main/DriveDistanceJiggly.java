package org.usfirst.frc.team1572.robot.commands.main;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveDistanceJiggly extends CommandGroup {
	
	private double distance;
	private int numberIncrements;
	private double incrementDistance;
	private double turnSpeed;
	private double timeOut;
	private double forwardSpeed;

    public DriveDistanceJiggly(final double distance, final int numberIncrements, final double forwardSpeed, final double turnSpeed, final double timeOut) {
    	
    	this.distance = distance;
    	this.numberIncrements = numberIncrements;
    	this.turnSpeed = turnSpeed;
    	this.incrementDistance = this.distance/this.numberIncrements;
    	this.timeOut = timeOut/this.numberIncrements;
    	this.forwardSpeed = forwardSpeed;
    	
    	switch(this.numberIncrements){
    	case 1:
    		addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
    	case 2:
    		addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
    	case 3:
    		addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
    	case 4:
    		addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
    	case 5:
    		addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
    	case 6:
    		addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
    	case 7:
    		addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
    	case 8:
    		addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
    	case 9:
    		addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
    	case 10:
    		addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, this.turnSpeed));
        	addSequential(new DriveDistanceCurved(this.incrementDistance,this.forwardSpeed,this.timeOut, -this.turnSpeed));
		default:
			break;
    	
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

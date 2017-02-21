package org.usfirst.frc.team1572.robot.commands.autonomous;

import org.usfirst.frc.team1572.robot.commands.main.AimForPegAutonomously;
import org.usfirst.frc.team1572.robot.commands.main.DriveDistance;
import org.usfirst.frc.team1572.robot.commands.main.TurnUntilAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestAutonomous extends CommandGroup {
	
    public TestAutonomous() {
    	addSequential(new DriveDistance(70));
    	addSequential(new TurnUntilAngle(-90,0.8));
    	addParallel(new AimForPegAutonomously());
    	addParallel(new DriveDistance(48));
    }
  }
    
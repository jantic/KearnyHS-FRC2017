package org.usfirst.frc.team1572.robot.commands;

import org.usfirst.frc.team1572.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1572.robot.commands.DriveDistance;

public class MidGear extends CommandGroup {

    public MidGear() {
       requires(Robot.joydrive);
       addSequential(new DriveDistance(93.3));
    }
}
package org.usfirst.frc.team1977.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1977.robot.commands.drive.DriveSide;
import org.usfirst.frc.team1977.robot.commands.drive.DriveTime;

public class AutonomousDefault extends CommandGroup {	
	
	public AutonomousDefault() {

		addSequential(new DriveTime(0, 0, 10000));
		addSequential(new DriveTime(-.4, -.4, 13000));
	}
	
	
	
}
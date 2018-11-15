package org.usfirst.frc.team1977.robot.commands.autonomous;


import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team1977.robot.commands.drive.*;

public class AutonomousDefault extends CommandGroup {	
	
	public AutonomousDefault() {
		// Pause for 118 or any additional teams
		addSequential(new DriveTime(0, 0, 3000));
		addSequential(new DriveTime(.4, .4, 6000));
		//addSequential(new DriveSide(.4, .4, 13000));
		addSequential(new TurnTime(7100, 0.5));
		addSequential(new DriveTime(.4,.4, 7700));
	}
	
	
	
}

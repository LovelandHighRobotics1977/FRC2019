package org.usfirst.frc.team1977.robot.commands.autonomous;

import org.usfirst.frc.team1977.robot.commands.drive.DriveSide;
import org.usfirst.frc.team1977.robot.commands.drive.DriveTime;
import org.usfirst.frc.team1977.robot.commands.drive.TurnTime;
import org.usfirst.frc.team1977.robot.subsystems.Autonomous;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightAutonomous extends CommandGroup{
	
private char switchPosition = Autonomous.getSwitchPosition();
	
	
	public RightAutonomous() {
		addSequential(new DriveTime(-.25, -1, 750));
		addSequential(new DriveSide(0, -1, switchPosition == 'R'? 750: 2500));
		addSequential(new DriveTime(-.25, -.5, 750));
	}
}

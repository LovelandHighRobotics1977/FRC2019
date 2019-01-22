package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.commands.drive.DriveSide;
import frc.robot.commands.drive.DriveTime;
import frc.robot.subsystems.Autonomous;


public class MidAutonomous extends CommandGroup {
	private char switchPosition = Autonomous.getSwitchPosition();
	
	
	public MidAutonomous() {
		addSequential(new DriveTime(-.5, 1000));
		addSequential(new DriveSide(switchPosition == 'L'? 1 : -1, 2500));
		addSequential(new DriveTime(-.5, 4500));
	}
	
}

package frc.robot.commands.autonomous;

import frc.robot.commands.drive.DriveSide;
import frc.robot.commands.drive.DriveTime;
//import frc.robot.commands.drive.TurnTime;
import frc.robot.subsystems.Autonomous;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftAutonomous extends CommandGroup{
	
private char switchPosition = Autonomous.getSwitchPosition();
	
	
	public LeftAutonomous() {
		addSequential(new DriveTime(0, -1, 750));
		addSequential(new DriveSide(0, 1, switchPosition == 'L'? 750: 2500));
		addSequential(new DriveTime(0, -.5, 1000));
	}
}

package frc.robot.commands.drive;

import frc.robot.commands.CommandBase;

/**
 * A simple, non-actuator related command to be mapped to a controller button.
 * Toggles the direction coefficient for the drive subsystem between high and low
 * values.
 * 
 * @author Loveland High Robotics 1977
 * @author Evan Stewart
 */
public class DirectionToggle extends CommandBase {

	public DirectionToggle() {
		requires(drive);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		drive.setDirection(!drive.isForward());
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//Do nothing
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
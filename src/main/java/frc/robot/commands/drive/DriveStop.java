package frc.robot.commands.drive;

import frc.robot.commands.CommandBase;


public class DriveStop extends CommandBase{
	public DriveStop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( drive );
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drive.stop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//PidController.stopPID();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//PidController.stopPID();
    }
}

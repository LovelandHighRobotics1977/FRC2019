package org.usfirst.frc.team1977.robot.commands.drive;

import org.usfirst.frc.team1977.robot.commands.CommandBase;

public class UserDrive extends CommandBase {
	//Time for 180 degree turn
	
	public UserDrive() {
		requires(drive);
	}
	
	protected void execute() {
		double lPower = oi.getDriveJoystick().getLeftY();
		double rPower = oi.getDriveJoystick().getRightY();
		
		if (Math.abs(lPower) < .2) {
			lPower = 0;
		}

		if (Math.abs(rPower) < .2) {
			rPower = 0;
		}
		drive.drive(-lPower, -rPower);
		
	}
	
	// Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drive.stop();
    }
}

package frc.robot.commands.diskMotor;

import frc.robot.commands.CommandBase;

//import edu.wpi.first.wpilibj.Joystick;

public class UserDisk extends CommandBase {
	//Time for 180 degree turn
	
	public UserDisk() {
		requires(diskMotor);
	}
	
	protected void execute() {

        double leftTrigger = oi.getAuxJoystick().getLeftTriggerAxis();
        double rightTrigger = oi.getAuxJoystick().getRightTriggerAxis();
		
		if (leftTrigger > .5) {
			diskMotor.rotate();
		}

		else if (rightTrigger > .5) {
			diskMotor.reset();
        }
        else{
            diskMotor.stop();
        }

	}
	
	// Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	diskMotor.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	diskMotor.stop();
    }
}

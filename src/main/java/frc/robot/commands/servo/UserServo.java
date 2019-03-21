package frc.robot.commands.servo;

import frc.robot.commands.CommandBase;

//import edu.wpi.first.wpilibj.Joystick;

public class UserServo extends CommandBase {
	//Time for 180 degree turn
	
	public UserServo() {
		requires(armservo);
	}
	
	protected void execute() {

        double leftTrigger = oi.getAuxJoystick().getLeftTriggerAxis();
        double rightTrigger = oi.getAuxJoystick().getRightTriggerAxis();
		
		if (leftTrigger > .5) {
			armservo.rotate();
		}

		else if (rightTrigger > .5) {
			armservo.reset();
		}

	}
	
	// Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	armservo.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	armservo.stop();
    }
}

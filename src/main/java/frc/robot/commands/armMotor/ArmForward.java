package frc.robot.commands.armMotor;

import frc.robot.commands.CommandBase;

public class ArmForward extends CommandBase{
	
	long startTime;
	long endTime;
	long commandTime = 150;
	
	public ArmForward() {
		requires(shooter);
	}
	
	protected void initialize() {
		startTime = System.currentTimeMillis();
    	endTime = startTime + commandTime;
    }
	
	public void execute() {	
		armMotor.moveForward();
	}
	
	protected boolean isFinished() {
		return ( System.currentTimeMillis() >= endTime );
	}
	
	protected void interrupted() {
		armMotor.stop();
	}
	
	protected void end() {
		armMotor.stop();
	}
}


package frc.robot.commands.armMotor;

import frc.robot.commands.CommandBase;

public class ArmBack extends CommandBase{
	
	long startTime;
	long endTime;
	long commandTime = 500;
	
	public ArmBack() {
		
		requires(shooter);
	}
	
	protected void initialize() {
		startTime = System.currentTimeMillis();
    	endTime = startTime + commandTime;
    }
	
	public void execute() {	
		armMotor.moveBackward();	
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
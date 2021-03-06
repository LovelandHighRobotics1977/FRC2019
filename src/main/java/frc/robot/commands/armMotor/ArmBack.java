package frc.robot.commands.armMotor;

import frc.robot.commands.CommandBase;

public class ArmBack extends CommandBase{
	
	long startTime;
	long endTime;
	long commandTime = 150;
	
	public ArmBack() {
		
		requires(armMotor);
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
package frc.robot.commands.armMotor;

import frc.robot.commands.CommandBase;

public class ArmForward extends CommandBase{
	
	long startTime;
	long endTime;
	long commandTime = 1000;
	
	public ArmForward() {
		// This was to test an error with shooter being null
//		if(shooter == null) {
//			for(int i = 0; i < 6; i++) {
//				System.out.println("Shooter is NULL.");
//			}
//			return;
//		}
		requires(shooter);
	}
	
	protected void initialize() {
		startTime = System.currentTimeMillis();
    	endTime = startTime + commandTime;
    	//System.out.println("Roller is rolling");
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


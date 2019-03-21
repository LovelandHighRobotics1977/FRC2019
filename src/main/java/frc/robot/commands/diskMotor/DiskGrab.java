package frc.robot.commands.diskMotor;

import frc.robot.commands.CommandBase;


public class DiskGrab extends CommandBase{
	
	long startTime;
	long endTime;
	long commandTime = 150;
	
	public DiskGrab() {
		requires(diskMotor);
	}
	
	protected void initialize() {
		startTime = System.currentTimeMillis();
    	endTime = startTime + commandTime;
    }
	
	public void execute() {	
		diskMotor.rotate();
	}
	
	protected boolean isFinished() {
		return ( System.currentTimeMillis() >= endTime );
	}
	
	protected void interrupted() {
		diskMotor.stop();
	}
	
	protected void end() {
		diskMotor.stop();
	}
}


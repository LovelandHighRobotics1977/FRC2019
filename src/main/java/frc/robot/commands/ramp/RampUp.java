package frc.robot.commands.ramp;
import frc.robot.commands.CommandBase;

public class RampUp extends CommandBase{
	
	long startTime;
	long endTime;
	long commandTime = 150;
	
	public RampUp() {
		requires(ramp);
	}
	
	protected void initialize() {
		startTime = System.currentTimeMillis();
    	endTime = startTime + commandTime;
    }
	
	public void execute() {	
	    ramp.bringUp();
	}
	
	protected boolean isFinished() {
		return ( System.currentTimeMillis() >= endTime );
	}
	
	protected void interrupted() {
		ramp.stop();
	}
	
	protected void end() {
		ramp.stop();
	}
}


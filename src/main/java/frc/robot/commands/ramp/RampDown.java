package frc.robot.commands.ramp;
import frc.robot.commands.CommandBase;

public class RampDown extends CommandBase{
	
	long startTime;
	long endTime;
	long commandTime = 150;
	
	public RampDown() {
		requires(ramp);
	}
	
	protected void initialize() {
		startTime = System.currentTimeMillis();
    	endTime = startTime + commandTime;
    }
	
	public void execute() {	
	    ramp.letDown();
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


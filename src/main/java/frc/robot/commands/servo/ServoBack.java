package frc.robot.commands.servo;
import frc.robot.commands.CommandBase;


public class ServoBack extends CommandBase{

    long startTime;
	long endTime;
	long commandTime = 1000;

    public ServoBack (){
        requires(armservo);
    }

    protected void initialize() {
        startTime = System.currentTimeMillis();
        endTime = startTime + commandTime;
    }
	
	public void execute() {	
		armservo.reset();
	}
	
	protected boolean isFinished() {
		return ( System.currentTimeMillis() >= endTime );
	}
	
	protected void interrupted() {
		armservo.stop();
	}
	
	protected void end() {
		armservo.stop();
	}

}
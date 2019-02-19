package frc.robot.commands.servo;
import frc.robot.commands.CommandBase;


public class ServoServ extends CommandBase{

    long startTime;
	long endTime;
	long commandTime = 10000000;

    public ServoServ (){
        requires(armservo);
    }

    protected void initialize() {
        startTime = System.currentTimeMillis();
        endTime = startTime + commandTime;
    }
	
	public void execute() {	
		armservo.rotate();
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
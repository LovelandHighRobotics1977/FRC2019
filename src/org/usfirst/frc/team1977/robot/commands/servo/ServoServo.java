package org.usfirst.frc.team1977.robot.commands.servo;
import org.usfirst.frc.team1977.robot.commands.CommandBase;


public class ServoServ extends CommandBase{

    long startTime;
	long endTime;
	long commandTime = 1000;

    public ServoServ (){
        requires(servo);
    }

    protected void initialize() {
        startTime = System.currentTimeMillis();
        endTime = startTime + commandTime;
    }
	
	public void execute() {	
		servo.rotate();
	}
	
	protected boolean isFinished() {
		return ( System.currentTimeMillis() >= endTime );
	}
	
	protected void interrupted() {
		servo.stop();
	}
	
	protected void end() {
		servo.stop();
	}

}
package org.usfirst.frc.team1977.robot.commands.drive;

import org.usfirst.frc.team1977.robot.commands.CommandBase;


public class WideTurn extends CommandBase{
	long startTime;
	long endTime;
	double turnSpeed;
	boolean direction;
	//dir is a value either 1 for right or -1 for left
    public WideTurn( long speed , long time, int dir) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( drive );
    	startTime = System.currentTimeMillis();
    	endTime = startTime + time;
    	turnSpeed = speed;
    	
    	if(dir == 1) {
    		//Right
    		direction = true;
    	} else if (dir == -1){
    		//Left
    		direction = false;
    	}
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(direction) {
    	drive.drive( 0, turnSpeed);
    	} else {
    	drive.drive(turnSpeed, 0);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ( System.currentTimeMillis() >= endTime );
    }

    // Called once after isFinished returns true
    protected void end() {
    	drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drive.stop();
    }
}

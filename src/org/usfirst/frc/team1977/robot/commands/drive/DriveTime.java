package org.usfirst.frc.team1977.robot.commands.drive;

import org.usfirst.frc.team1977.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.Command;

public class DriveTime extends CommandBase {

	/*private final String commandName = "Drive Forward";
    private final String subsytemName = "Drive";*/

    private final double lPower, rPower;
    private final long startTime, endTime;

    public DriveTime(double leftSpeed, double rightSpeed, int timeMillis) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        //requires(drive);
        
        lPower = leftSpeed;
        rPower = rightSpeed;
        startTime = System.currentTimeMillis();
        endTime = startTime + timeMillis;
        System.out.println("drive time is go");
    }
    
 // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drive.drive(lPower, rPower);
    }
	
	// Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println("Cur " + System.currentTimeMillis());
    	System.out.println("End " + endTime);
        return (System.currentTimeMillis() >= endTime);
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

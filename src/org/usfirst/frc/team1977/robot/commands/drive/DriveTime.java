package org.usfirst.frc.team1977.robot.commands.drive;

import org.usfirst.frc.team1977.robot.commands.CommandBase;


public class DriveTime extends CommandBase {

	/*private final String commandName = "Drive Forward";
    private final String subsytemName = "Drive";*/

    private final double vPowerMin, vPowerMax;
    private final long startTime, halfTime, endTime;

    private double driveSpeed;
    
    //Percentage goes from -1 to 1 - See CTRE documentation http://www.ctr-electronics.com/downloads/api/java/html/index.html
    public DriveTime(double minSpeedPercent, double maxSpeedPercent, int timeMillis) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        //requires(drive);
        
        vPowerMin = minSpeedPercent;
        vPowerMax = maxSpeedPercent;
        startTime = System.currentTimeMillis();
        halfTime = startTime + (timeMillis / 2);
        endTime = startTime + timeMillis;
        System.out.println("drive time is go");
    }
    
 // Called just before this Command runs the first time
    protected void initialize() {
        driveSpeed = vPowerMin;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drive.drive(0, driveSpeed, 0);
    }
	
	// Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println("Current: " + System.currentTimeMillis());
    	System.out.println("End: " + endTime);
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

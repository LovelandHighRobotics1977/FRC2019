package org.usfirst.frc.team1977.robot.commands.drive;

import org.usfirst.frc.team1977.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.Command;

public class DriveSide extends CommandBase {

	/*private final String commandName = "Drive Forward";
    private final String subsytemName = "Drive";*/

    private final double vPowerMin, vPowerMax;
    private final long startTime, halfTime, endTime;
    private double driveSpeed;

    public DriveSide(double minSpeedPercent, double maxSpeedPercent, int timeMillis) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        //requires(drive);
        
        vPowerMin = minSpeedPercent;
        vPowerMax = maxSpeedPercent;
        startTime = System.currentTimeMillis();
        halfTime = startTime + (timeMillis / 2);
        endTime = startTime + timeMillis;
        System.out.println("drive time is go");
        System.out.println("Cur " + System.currentTimeMillis());
		System.out.println("End " + endTime);
    }
    
 // Called just before this Command runs the first time
    protected void initialize() {
        driveSpeed = vPowerMin;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Driving?");
        drive.drive(driveSpeed, 0, 0);
    }
	
	// Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (System.currentTimeMillis() >= endTime);
    }

    // Called once after isFinished returns true
    protected void end() {
        drive.stop();
        System.out.println("Auto ended. Current time is " + System.currentTimeMillis());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        drive.stop();
    }
}

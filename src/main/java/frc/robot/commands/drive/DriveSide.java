package frc.robot.commands.drive;

import frc.robot.commands.CommandBase;

//import edu.wpi.first.wpilibj.command.Command;

public class DriveSide extends CommandBase {

	/*private final String commandName = "Drive Forward";
    private final String subsytemName = "Drive";*/

    private final double vPower;
    private final long startTime, endTime;
    private double driveSpeed;

    public DriveSide(double speedPercent, int timeMillis) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        //requires(drive);
        
        vPower = speedPercent;
        startTime = System.currentTimeMillis();
        endTime = startTime + timeMillis;
        System.out.println("drive time is go");
        System.out.println("Cur " + System.currentTimeMillis());
		System.out.println("End " + endTime);
    }
    
 // Called just before this Command runs the first time
    protected void initialize() {
        driveSpeed = vPower;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Driving");
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

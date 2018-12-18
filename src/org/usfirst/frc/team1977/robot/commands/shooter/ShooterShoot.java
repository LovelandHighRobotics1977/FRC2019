package org.usfirst.frc.team1977.robot.commands.shooter;

import org.usfirst.frc.team1977.robot.commands.CommandBase;

public class ShooterShoot extends CommandBase{
	
	long startTime;
	long endTime;
	long commandTime = 1000;
	
	public ShooterShoot() {
		// This was to test an error with shooter being null
//		if(shooter == null) {
//			for(int i = 0; i < 6; i++) {
//				System.out.println("Shooter is NULL.");
//			}
//			return;
//		}
		requires(shooter);
	}
	
	protected void initialize() {
		startTime = System.currentTimeMillis();
    	endTime = startTime + commandTime;
    	//System.out.println("Roller is rolling");
    }
	
	public void execute() {	
		shooter.shoot();	
	}
	
	protected boolean isFinished() {
		return ( System.currentTimeMillis() >= endTime );
	}
	
	protected void interrupted() {
		shooter.stop();
	}
	
	protected void end() {
		shooter.stop();
	}
}
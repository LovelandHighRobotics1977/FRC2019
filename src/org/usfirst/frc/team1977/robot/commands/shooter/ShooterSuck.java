package org.usfirst.frc.team1977.robot.commands.shooter;

import org.usfirst.frc.team1977.robot.commands.CommandBase;

public class ShooterSuck extends CommandBase {
	
		long startTime;
		long endTime;
		long commandTime = 1000;
		
		public ShooterSuck() {
			requires(shooter);
		}
		
		protected void initialize() {
			startTime = System.currentTimeMillis();
	    	endTime = startTime + commandTime;
	    	System.out.println("Shooter is shooting");
	    }
		
		public void execute() {	
			shooter.suck();	
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
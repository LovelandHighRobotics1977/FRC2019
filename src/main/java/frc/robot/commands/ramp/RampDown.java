// package frc.robot.commands.ramp;

// import frc.robot.commands.CommandBase;

// public class RampDown extends CommandBase{
	
// 	long startTime;
// 	long endTime;
// 	long commandTime = 500;
	
// 	public RampDown(){
		
// 		requires(ramp);
// 	}
	
// 	protected void initialize() {
// 		startTime = System.currentTimeMillis();
//     	endTime = startTime + commandTime;
//     }
	
// 	public void execute() {	
// 		armMotor.moveBackward();	
// 	}
	
// 	protected boolean isFinished() {
// 		return ( System.currentTimeMillis() >= endTime );
// 	}
	
// 	protected void interrupted() {
// 		armMotor.stop();
// 	}
	
// 	protected void end() {
// 		armMotor.stop();
// 	}
// }
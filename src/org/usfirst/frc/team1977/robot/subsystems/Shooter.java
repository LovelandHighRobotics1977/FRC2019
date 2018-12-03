package org.usfirst.frc.team1977.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.VictorSP;

public class Shooter extends Subsystem {
	
	
	public static Shooter instance;
	//private Relay rollerMotor;
	private VictorSP ShooterMotor;
	
	Shooter(){
		ShooterMotor = new VictorSP(0);
	}
	public static Shooter getInstance() {
		if (instance == null) {
    		instance = new Shooter();
    	}
    	return instance;
	}
	
	public void shoot() {
		ShooterMotor.set(-.30);
	}
	
	public void suck() {
		ShooterMotor.set(.30);
	}
	
	public void stop() {
		System.out.println(ShooterMotor.get());
		ShooterMotor.stopMotor();
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}


}
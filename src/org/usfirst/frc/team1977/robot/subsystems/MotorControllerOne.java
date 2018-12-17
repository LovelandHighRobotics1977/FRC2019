package org.usfirst.frc.team1977.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class MotorControllerOne extends Subsystem {
	
	
	public static MotorControllerOne instance;
	//private Relay rollerMotor;
	private TalonSRX Motor;
	ControlMode outputMode = ControlMode.PercentOutput;

	
	MotorControllerOne(){
		//ShooterMotor = new VictorSP(0);
		Motor = new TalonSRX(4);
		Motor = new TalonSRX(5);
	}
	public static MotorControllerOne getInstance() {
		if (instance == null) {
    		instance = new MotorControllerOne();
    	}
    	return instance;
	}
	
	public void shoot() {
		//ShooterMotor.set(-.30);
		Motor.set(outputMode, .5);
	}
	
	public void suck() {
		//ShooterMotor.set(.30);
		Motor.set(outputMode, -.5);
	}
	
	public void stop() {
		System.out.println(Motor.get());
		Motor.set(outputMode, 0);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}


}
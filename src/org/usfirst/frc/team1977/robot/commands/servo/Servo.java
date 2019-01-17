package org.usfirst.frc.team1977.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Servo;

public class Servo{

    public static Servo instance;
	public Servo servo;
	
	Servo(){
		Servo = new Servo();
	}
	public static Servo getInstance() {
		if (instance == null) {
    		instance = new Servo();
    	}
    	return instance;
	}
	
	public void rotate(){
		Servo.setAngle(180);
	}

	public void stop(){
		System.out.println(Servo.get());
		Servo.stopMotor();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		break;
	}


}


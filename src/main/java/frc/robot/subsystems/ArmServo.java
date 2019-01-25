package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Servo;

public class ArmServo extends Subsystem{

    public static ArmServo instance;
	public Servo servoOne;
	public static int servoID = 9;
	ArmServo(){
		servoOne = new Servo(servoID);
	}
	public static ArmServo getInstance() {
		if (instance == null) {
    		instance = new ArmServo();
    	}
    	return instance;
	}

	
	public void rotate(){
		servoOne.setAngle(180);
	}

	public void reset(){
		servoOne.setAngle(0);
	}

	public void stop(){
		System.out.println(servoOne.get());
		servoOne.stopMotor();
	}

	@Override
	protected void initDefaultCommand() {
		// Auto-generated method stub
		return;
	}


}


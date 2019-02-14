package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Servo;

public class ArmServo extends Subsystem{

    public static ArmServo instance;
	public Servo servoOne;
	ArmServo(){
		servoOne = new Servo(RobotMap.ARM_SERVO);
	}
	public static ArmServo getInstance() {
		if (instance == null) {
    		instance = new ArmServo();
    	}
    	return instance;
	}

	
	public void rotate(){
		servoOne.setAngle(110);
		System.out.println("Servo going");
	}

	public void reset(){
		servoOne.setAngle(0);
		System.out.println("Servo going other way");
	}

	public void stop(){
		System.out.println(servoOne.get());
		servoOne.stopMotor();
	}

	@Override
	protected void initDefaultCommand() {
		// Auto-generated method stub
	}


}


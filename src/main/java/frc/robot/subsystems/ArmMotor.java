package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;

public class ArmMotor extends Subsystem {
	
	
	public static ArmMotor instance;
	private VictorSP ArmMotor;
	
	ArmMotor(){
		ArmMotor = new VictorSP(RobotMap.ARM_MOTOR);
	}
	public static ArmMotor getInstance() {
		if (instance == null) {
    		instance = new ArmMotor();
    	}
    	return instance;
	}
	
	public void moveForward() {
		ArmMotor.set(-.50);
	}
	
	public void moveBackward() {
		ArmMotor.set(.50);
	}
	
	public void stop() {
		System.out.println(ArmMotor.get());
		ArmMotor.stopMotor();
	}
	@Override
	protected void initDefaultCommand() {
		// Auto-generated method stub
		return;
	}


}
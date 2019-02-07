package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class ArmMotor extends Subsystem {
	
	
	public static ArmMotor instance;
    private TalonSRX ArmMotor;
    private ControlMode TalonControlMode = ControlMode.PercentOutput;
	
	ArmMotor(){
		ArmMotor = new TalonSRX(RobotMap.ARM_MOTOR);
	}
	public static ArmMotor getInstance() {
		if (instance == null) {
    		instance = new ArmMotor();
    	}
    	return instance;
	}
	
	public void moveForward() {
		ArmMotor.set(TalonControlMode, -.50);
	}
	
	public void moveBackward() {
		ArmMotor.set(TalonControlMode, .50);
	}
	
	public void stop() {
		//System.out.println(ArmMotor.get());
		ArmMotor.set(TalonControlMode, 0);
	}
	@Override
	protected void initDefaultCommand() {
		// Auto-generated method stub
		return;
	}


}
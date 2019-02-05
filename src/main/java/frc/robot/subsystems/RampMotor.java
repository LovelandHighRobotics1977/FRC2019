package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.VictorSP;

public class RampMotor extends Subsystem {
	
	
	public static RampMotor instance;
    private TalonSRX RampMotor;
    private ControlMode TalonControlMode = ControlMode.PercentOutput;
	
	RampMotor(){
		RampMotor = new TalonSRX(RobotMap.RAMP_MOTOR);
	}
	public static RampMotor getInstance() {
		if (instance == null) {
    		instance = new RampMotor();
    	}
    	return instance;
	}
	
	public void moveForward() {
		RampMotor.set(TalonControlMode, -.50);
	}
	
	public void moveBackward() {
		RampMotor.set(TalonControlMode, .50);
	}
	
	public void stop() {
		//System.out.println(RampMotor.get());
		RampMotor.set(TalonControlMode, 0);
	}
	@Override
	protected void initDefaultCommand() {
		// Auto-generated method stub
		return;
	}


}
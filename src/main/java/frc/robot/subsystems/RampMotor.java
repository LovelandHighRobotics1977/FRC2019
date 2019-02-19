package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Relay;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

//import edu.wpi.first.wpilibj.VictorSP;

public class RampMotor extends Subsystem {
	
	
	public static RampMotor instance;
    private Relay RampMotorOne;
    private Relay RampMotorTwo;
    private ControlMode TalonControlMode = ControlMode.PercentOutput;
	
	RampMotor(){
        RampMotorOne = new Relay(2);
        RampMotorTwo = new Relay(3);
	}
	public static RampMotor getInstance() {
		if (instance == null) {
    		instance = new RampMotor();
    	}
    	return instance;
	}
	
	public void letDown() {
        RampMotorOne.set(Relay.Value.kForward);
        RampMotorTwo.set(Relay.Value.kReverse);
	}
	
	public void bringUp() {
        RampMotorOne.set(Relay.Value.kReverse);
        RampMotorTwo.set(Relay.Value.kForward);
	}
	
	public void stop() {
		//System.out.println(RampMotor.get());
        RampMotorOne.set(Relay.Value.kOff);
        RampMotorTwo.set(Relay.Value.kOff);
	}
	@Override
	protected void initDefaultCommand() {
		// Auto-generated method stub
		return;
	}


}
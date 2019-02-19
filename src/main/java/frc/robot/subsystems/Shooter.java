package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.VictorSP;

public class Shooter extends Subsystem {
	
	
	public static Shooter instance;
	private TalonSRX ShooterMotor;
	private int shooterPower = 0;
	private ControlMode TalonControlMode = ControlMode.PercentOutput;
	
	Shooter(){
		ShooterMotor = new TalonSRX(RobotMap.SHOOTER_MOTOR);
	}
	public static Shooter getInstance() {
		if (instance == null) {
    		instance = new Shooter();
    	}
    	return instance;
	}
	
	public void shoot() {
		System.out.println("Shootee is goee with " + shooterPower * .30);
		if(shooterPower == 3){
			ShooterMotor.set(TalonControlMode, -1.00);
		}
		else{
			ShooterMotor.set(TalonControlMode, shooterPower * -.30);
		}
	}
	
	public void suck() {
		ShooterMotor.set(TalonControlMode, .05);
	}
	
	public void stop() {
		//System.out.println(ShooterMotor.get());
		ShooterMotor.set(TalonControlMode, 0);;
	}

	public void setPower(int power){
		shooterPower = power;
	}

	public int getPower(){
		return shooterPower;
	}
	@Override
	protected void initDefaultCommand() {
		// Auto-generated method stub
		return;
	}


}
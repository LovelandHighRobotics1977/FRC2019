package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;

public class Shooter extends Subsystem {
	
	
	public static Shooter instance;
	private VictorSP ShooterMotor;
	private int shooterPower = 0;
	
	Shooter(){
		ShooterMotor = new VictorSP(RobotMap.SHOOTER_MOTOR);
	}
	public static Shooter getInstance() {
		if (instance == null) {
    		instance = new Shooter();
    	}
    	return instance;
	}
	
	public void shoot() {
		System.out.println("Shootee is goee");
		ShooterMotor.set(shooterPower * -.30);
	}
	
	public void suck() {
		ShooterMotor.set(.30);
	}
	
	public void stop() {
		System.out.println(ShooterMotor.get());
		ShooterMotor.stopMotor();
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
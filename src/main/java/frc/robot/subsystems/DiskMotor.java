package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.diskMotor.UserDisk;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DiskMotor extends Subsystem {
	
	
	public static DiskMotor instance;
	private TalonSRX DiskMotor;
	private UserDisk userDisk;
    private ControlMode TalonControlMode = ControlMode.PercentOutput;
	
	DiskMotor(){
		DiskMotor = new TalonSRX(RobotMap.DISK_MOTOR);
	}
	public static DiskMotor getInstance() {
		if (instance == null) {
    		instance = new DiskMotor();
    	}
    	return instance;
	}
	
	public void rotate() {
		DiskMotor.set(TalonControlMode, -.20);
    }
    
    public void reset() {
        DiskMotor.set(TalonControlMode, .20);
    }
    
	public void stop() {
		//System.out.println(ArmMotor.get());
		DiskMotor.set(TalonControlMode, 0);
	}
	@Override
	protected void initDefaultCommand() {
		// Auto-generated method stub
		userDisk = new UserDisk();
	    setDefaultCommand(userDisk);
	}


}
package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.ArmMotor;
import frc.robot.subsystems.Drive;
//import frc.robot.subsystems.Pneumatic;
import frc.robot.subsystems.RampMotor;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.DiskMotor;
import edu.wpi.first.wpilibj.command.Command;


public abstract class CommandBase extends Command {
	/**
	 * Inherited static access to the OI.
	 */
	protected static OI oi;
	protected static Drive drive;
	protected static Shooter shooter;
	//protected static Pneumatic pneumatic;
	protected static ArmMotor armMotor;
	protected static RampMotor ramp;
	protected static DiskMotor diskMotor;
	
	/**
	 * Initialize the CommandBase, in doing so accessing and initializing every
	 * primary subsystem on the robot. Use this during robot initialization to
	 * prevent unnecessary redundancy.
	 */
	
	public static void init() {
		drive = Drive.getInstance();
		oi = OI.getInstance();
		shooter = Shooter.getInstance();
		//pneumatic = Pneumatic.getInstance();
		armMotor = ArmMotor.getInstance();
		ramp = RampMotor.getInstance();
		diskMotor = DiskMotor.getInstance();
		if(shooter == null) {
			System.out.println("Shooter in NULL in init");
		}
		
	}
}
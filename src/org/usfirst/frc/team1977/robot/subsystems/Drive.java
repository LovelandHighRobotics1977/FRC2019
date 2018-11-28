package org.usfirst.frc.team1977.robot.subsystems;

import org.usfirst.frc.team1977.robot.RobotMap;
import org.usfirst.frc.team1977.robot.commands.drive.UserDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

//import com.ctre.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private static Drive instance;
	//used for getInstance
	
	private boolean speedToggle = false;
	//for speedToggle function to halve speed
	
	/*private TALON frontLeft;
	private TALON frontRight;
	private TALON backLeft;
	private TALON backRight;*/
	
	
	private TalonSRX leftOne;
	private TalonSRX leftTwo;
	private TalonSRX rightOne;
	private TalonSRX rightTwo;
	
	
	private UserDrive userDrive;
	
	//May use if this we need to
	//robotDrive.setInvertedMotor(MotorType.frontLeft, true);
	
	private double voltageCoefficient = 1;
	private double turnPowerCoefficient = 1;

	
	public Drive(){
		//Define motor controllers for drive train on test chassis
		//These are motors.
		leftOne = new TalonSRX(RobotMap.DRIVE_LEFT_ONE_TAlON);
    	leftTwo = new TalonSRX(RobotMap.DRIVE_LEFT_TWO_TALON);
    	rightOne = new TalonSRX(RobotMap.DRIVE_RIGHT_ONE_TALON);
    	rightTwo = new TalonSRX(RobotMap.DRIVE_RIGHT_TWO_TALON);
    	
    	/* Define motor controllers for drive train on main chassis
    	 * Need this because FIRST only has TALON plugins and they have no idea what its like trying to find and install plugins from third party sites that look fairly sketchy and don't really install right and why can't just add the commonly used motor controllers that they have in their FIRST Choice Program
    	 * http://www.ctr-electronics.com/downloads/pdf/CTRE%20Toolsuite%20Installation%20Guide.pdf*/
    /*	frontLeft = new TalonSRX(RobotMap.DRIVE_FRONT_LEFT_TALON);
    	frontRight = new TalonSRX(RobotMap.DRIVE_FRONT_RIGHT_TALON);
    	backLeft = new TalonSRX(RobotMap.DRIVE_BACK_LEFT_TALON);
    	backRight = new TalonSRX(RobotMap.DRIVE_BACK_RIGHT_TALON);*/
    	
	}
	
	public void initDefaultCommand() {
	       userDrive = new UserDrive();
	       setDefaultCommand(userDrive);
	    }
	
	public static Drive getInstance() {
    	if (instance == null) {
    		instance = new Drive();
    	}
    	return instance;
    }
	
	/**
     * Set the four drive TALONs based upon the specified power values 
     * multiplied by the drivetrain voltage coefficient.
     * @param hPower Horizontal (strafing) power.  Pulled from the X axis of the
     * left stick. Positive goes right!
     * @param vPower Vertical (forward) power.  Pulled from the Y axis of the 
     * left stick. Positive goes forward!
     * @param turn Turning power.  Pulled from the left and right triggers.
     */
	
	ControlMode iJustWantToSleep = ControlMode.PercentOutput;
	public void drive(double lPower, double rPower) {
        leftOne.set(iJustWantToSleep, (lPower * voltageCoefficient));
        leftTwo.set(iJustWantToSleep, (lPower * voltageCoefficient));
        rightOne.set(iJustWantToSleep, (rPower * voltageCoefficient));
        rightTwo.set(iJustWantToSleep, (rPower * voltageCoefficient));
    }
	
	public void stop() {
    	drive(0, 0);
    }
	
	public boolean isSpeedToggle() {
    	return speedToggle;
    }
    
    public void setSpeedToggle(boolean speedToggle) {
    	this.speedToggle = speedToggle;
    	if (speedToggle) {
    		voltageCoefficient = 0.5;
    	} else {
    		voltageCoefficient = 1.0;
    	}
    }
}

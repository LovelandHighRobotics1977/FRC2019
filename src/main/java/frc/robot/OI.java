/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.input.XBoxController;
import frc.robot.commands.shooter.*;
import frc.robot.commands.servo.*;
import frc.robot.commands.armMotor.ArmBack;
import frc.robot.commands.armMotor.ArmForward;
import frc.robot.commands.drive.*;
import frc.robot.commands.armMotor.*;
import frc.robot.commands.ramp.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	//Test
	private static OI instance;
	// XBox Controller references
	private XBoxController driveJoystick;
	private XBoxController auxJoystick;
	//Other joystick will be put here as well
	
	public OI() {
		driveJoystick = new XBoxController(0);
		auxJoystick = new XBoxController(1);
		//Set other controller here once we know if it is used 
		//manipulatorJoystick = new XBoxController(1);
	}
	
	public void init() {
		//Put things here when you want buttons to trigger
		//Speed toggle
		//driveJoystick.leftWhenPressed(new SpeedToggle());
		//Turn functions for shoulders
		//driveJoystick.rightWhileHeld(new TurnTime(500,-1));
		//driveJoystick.leftWhileHeld(new TurnTime(500,1));
		//180 turn function
		//driveJoystick.rightWhenPressed(new TurnTime(500,1)); //THIS NEEDS TO BE Adjusted
		driveJoystick.aWhileHeld(new ShooterShoot(1));
		driveJoystick.bWhileHeld(new ShooterShoot(2));
		driveJoystick.xWhileHeld(new ShooterShoot(3));
		driveJoystick.yWhileHeld(new ShooterSuck());
		driveJoystick.rightWhenPressed(new DirectionToggle());
		driveJoystick.leftWhenPressed(new SpeedToggle());
		auxJoystick.xWhenPressed(new ServoServ());
		auxJoystick.bWhenPressed(new ServoBack());
		auxJoystick.rightWhileHeld(new ArmBack());
		auxJoystick.leftWhileHeld(new ArmForward());
		auxJoystick.yWhenPressed(new RampUp());
		auxJoystick.aWhenPressed(new RampDown());
		//auxJoystick.rightThumbWhileHeld(command);
	}
	
	public static OI getInstance() {
		if (instance == null) {
			instance = new OI();
		}
		return instance;
	}
	
	public XBoxController getDriveJoystick() {
		return driveJoystick;
	}
}

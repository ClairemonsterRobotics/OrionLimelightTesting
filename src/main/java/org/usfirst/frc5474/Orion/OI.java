// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5474.Orion;

import org.usfirst.frc5474.Orion.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc5474.Orion.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
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

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton winchOnlyButton;
    public JoystickButton barButton;
    public JoystickButton climbButton;
    public Joystick xBOXController;
    public JoystickButton setPosBottom;
    public JoystickButton setPosHatch1;
    public JoystickButton setPosBall1;
    public JoystickButton setPosHatch2;
    public JoystickButton setPosBall2;
    public JoystickButton setPosHatch3;
    public JoystickButton setPosBall3;
    public Joystick proJoystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        proJoystick = new Joystick(1);
        
        setPosBall3 = new JoystickButton(proJoystick, 8);
        setPosBall3.whenPressed(new setPosition());
        setPosHatch3 = new JoystickButton(proJoystick, 7);
        setPosHatch3.whenPressed(new setPosition());
        setPosBall2 = new JoystickButton(proJoystick, 10);
        setPosBall2.whenPressed(new setPosition());
        setPosHatch2 = new JoystickButton(proJoystick, 9);
        setPosHatch2.whenPressed(new setPosition());
        setPosBall1 = new JoystickButton(proJoystick, 12);
        setPosBall1.whenPressed(new setPosition());
        setPosHatch1 = new JoystickButton(proJoystick, 11);
        setPosHatch1.whenPressed(new setPosition());
        setPosBottom = new JoystickButton(proJoystick, 3);
        setPosBottom.whenPressed(new setPosition());
        
        xBOXController = new Joystick(0);
        
        climbButton = new JoystickButton(xBOXController, 3);
        climbButton.whileHeld(new climbSequence());
        barButton = new JoystickButton(xBOXController, 2);
        barButton.whenPressed(new dropBar());
        winchOnlyButton = new JoystickButton(xBOXController, 1);
        winchOnlyButton.whileHeld(new runWinch());


        // SmartDashboard Buttons
        SmartDashboard.putData("climbSequence", new climbSequence());
        SmartDashboard.putData("arcadeDrive", new arcadeDrive());
        SmartDashboard.putData("tractionDrive", new tractionDrive());
        SmartDashboard.putData("openClaw", new openClaw());
        SmartDashboard.putData("closeClaw", new closeClaw());
        SmartDashboard.putData("pushBall", new pushBall());
        SmartDashboard.putData("runWinch", new runWinch());
        SmartDashboard.putData("dropBar", new dropBar());
        SmartDashboard.putData("setPosition", new setPosition());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getXBOXController() {
        return xBOXController;
    }

    public Joystick getProJoystick() {
        return proJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}


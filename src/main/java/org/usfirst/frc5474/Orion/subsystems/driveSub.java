// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5474.Orion.subsystems;


import org.usfirst.frc5474.Orion.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder.IndexingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class driveSub extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private Spark rightMotorPair;
    private Spark leftMotorPair;
    private DifferentialDrive diffDrive;
    public Encoder rightPairEncoder;
    public Encoder leftPairEncoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public driveSub() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        rightMotorPair = new Spark(8);
        addChild("rightMotorPair",rightMotorPair);
        rightMotorPair.setInverted(false);
        
        leftMotorPair = new Spark(9);
        addChild("leftMotorPair",leftMotorPair);
        leftMotorPair.setInverted(false);
        
        diffDrive = new DifferentialDrive(leftMotorPair, rightMotorPair);
        addChild("diffDrive",diffDrive);
        diffDrive.setSafetyEnabled(true);
        diffDrive.setExpiration(0.1);
        diffDrive.setMaxOutput(1.0);

        double encoderTickConstant = 1/(60/Math.PI); //gives approx 1in/1 encoder tick

        rightPairEncoder = new Encoder(6, 7, false); 
        addChild("rightPairEncoder",rightPairEncoder);
        rightPairEncoder.setDistancePerPulse(1.0);
        rightPairEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
        rightPairEncoder.setIndexSource(8, IndexingType.kResetOnRisingEdge);
        rightPairEncoder.setDistancePerPulse(encoderTickConstant);
        
        leftPairEncoder = new Encoder(9, 10, false);
        addChild("leftPairEncoder",leftPairEncoder);
        leftPairEncoder.setDistancePerPulse(1.0);
        leftPairEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
        leftPairEncoder.setIndexSource(11, IndexingType.kResetOnRisingEdge);
        leftPairEncoder.setDistancePerPulse(encoderTickConstant);
        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new arcadeDrive());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    public void arcadeDrive(Joystick stick){
        diffDrive.arcadeDrive(stick.getY(), stick.getX(), true);
    }
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    public void driveStraight(double power) {
		// used for autonomous mode
        leftMotorPair.set(power);
        rightMotorPair.set(power);
    }
    public void turnRight(double power) {
		// used for autonomous mode
		leftMotorPair.set(power);
    }
    public void turnLeft(double power) {
		// used for autonomous mode
		rightMotorPair.set(power);
    }
    public void stop() {
		// used for autonomous mode
		leftMotorPair.set(0);
        rightMotorPair.set(0);
	}
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}


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
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class armSub extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private Spark armMotor;
    private Spark hingeMotor;
    public Encoder armEncoder;
    public Encoder hingeEncoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public armSub() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        armMotor = new Spark(4);
        addChild("armMotor",armMotor);
        armMotor.setInverted(false);

        hingeMotor = new Spark(5);
        addChild("hingeMotor",hingeMotor);
        hingeMotor.setInverted(false);
        
        armEncoder = new Encoder(3, 4, false);
        addChild("armEncoder",armEncoder);
        armEncoder.setDistancePerPulse(1.0);
        armEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
        armEncoder.setIndexSource(5, IndexingType.kResetOnRisingEdge);

        hingeEncoder = new Encoder(12, 13, false); //12 and 13 values may not work!
        addChild("hingeEncoder",hingeEncoder);
        hingeEncoder.setDistancePerPulse(1.0);
        hingeEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
        //hingeEncoder.setIndexSource(5, IndexingType.kResetOnRisingEdge);
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    public boolean moveHinge( double angle){
        double hingePos = hingeEncoder.getDistance();
        double angleValue = 45;
        if(angle == 45.0){
            if(hingePos < angleValue){
                hingeMotor.set(0.35);
                return false;
            } else if(hingePos > angleValue){
                hingeMotor.set(-0.35);
                return false;
            } else{
                hingeMotor.set(0);
                return true;
            }
        }else{
            return true;
        }
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        //setDefaultCommand(new setPosition());
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}


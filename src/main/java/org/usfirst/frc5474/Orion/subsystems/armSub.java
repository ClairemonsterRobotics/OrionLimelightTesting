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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder.IndexingType;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

import java.text.DecimalFormat;

import org.usfirst.frc5474.Orion.Robot;

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
    private Encoder armEncoder;
    private Encoder hingeEncoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public armSub() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        armMotor = new Spark(4);
        addChild("armMotor", armMotor);
        armMotor.setInverted(false);

        hingeMotor = new Spark(5);
        addChild("hingeMotor", hingeMotor);
        hingeMotor.setInverted(false);

        armEncoder = new Encoder(0, 1, false);
        addChild("armEncoder", armEncoder);
        armEncoder.setDistancePerPulse(3 * Math.PI / 360);
        armEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
        //armEncoder.setIndexSource(2, IndexingType.kResetOnRisingEdge);

        hingeEncoder = new Encoder(2, 3, false);
        addChild("hingeEncoder", hingeEncoder);
        hingeEncoder.setDistancePerPulse(3 * Math.PI / 360);
        hingeEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
        //hingeEncoder.setIndexSource(5, IndexingType.kResetOnRisingEdge);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // @param armPos = double of desired arm position
    public boolean moveArmToPos(double armPos) {
        double currentArmPos = armEncoder.getDistance();
        //SmartDashboard.putNumber("arm encoder", currentArmPos);
        if (currentArmPos < armPos) {
            if (currentArmPos >= (armPos - 0.2)){
                armMotor.set(0);
                return true;
            } else {
                armMotor.set(1);
                return false;
            }
        } else if (currentArmPos > armPos) {
            if (currentArmPos <= (armPos + 0.2)){
                armMotor.set(1);
                return true;
            } else {
                armMotor.set(-0.6);
                return false;
            }
        } else {
            armMotor.set(0);
            return true;
        }
    }

    public double checkArmEncoder() {
        return armEncoder.getDistance();
    }

    public void resetArmEncoder() {
        armEncoder.reset();
    }

    /*public double getSensitivity() {
        double sensitivitySlider = Robot.oi.proJoystick.getRawAxis(3);
        return (sensitivitySlider + 1.0) / 2;
    }*/

    public void moveArmManual(double direction) {
        double currentArmPos = armEncoder.getDistance();
        if(direction>0){
            if(currentArmPos<=1.2){
                armMotor.set(direction);
            }else{
                armMotor.set(0);
            }
        }else{
            if (currentArmPos>=0){
                armMotor.set(direction);
            }else{
                armMotor.set(0);
            }
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
        //SmartDashboard.putNumber("Arm Encoder Value (periodic)", armEncoder.getDistance());
        //SmartDashboard.putBoolean("Moved to correct pos (periodic)", Robot.armSub.moveArmToPos(10));
        // Put code here to be run every loop

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

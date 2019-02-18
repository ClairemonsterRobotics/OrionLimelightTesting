// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc5474.Orion.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5474.Orion.Robot;
//import org.usfirst.frc5474.Orion.subsystems.driveSub;

/**
 *
 */
public class AutonomousCenter extends Command {
    public int autonState = 1;
    public final int AS_foward1 = 1;
    public final int foward1_Distance = 18; // 18 inches
    public final int AS_right = 2;
    public final int right_Distance = (int)Math.round(12 * 2 * Math.PI); // 4pi ft / 180 degree turn; 2pi for 90 deg
    public final int AS_foward2 = 3;
    public final int foward2_Distance = 0; // NEED value
    // public final int AS_Align = 4; //PIXY controlled?

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AutonomousCenter() {

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        resetEncoders();

    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        int encoderCurrR = Robot.driveSub.rightPairEncoder.get();
        int encoderCurrL = Robot.driveSub.leftPairEncoder.get();

        int encoderAvg = (encoderCurrR + encoderCurrL) / 2; // 1/19.1 res for 1:1 inch:tick

            if (encoderAvg < foward1_Distance) { // if not at the target location
                Robot.driveSub.driveStraight(.5); // drive straight at some power
            } else {
                Robot.driveSub.stop();
                resetEncoders();
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }

    void resetEncoders() {
        Robot.driveSub.rightPairEncoder.reset();
        Robot.driveSub.leftPairEncoder.reset();
    }

    public int distanceToTicks(double distance, String unit) { // in progress
        if (unit.toLowerCase().equals("feet")) {
            return ((int) (Math.round(distance * 12))); // 12 is current foot to tick conversion
        } else {
            return 0;
        }
    }
}

// class autonState {
// int executionNumber;
// int rotationDeg;
// int fowardInches;

// public autonState(int executionNumber){
// this.executionNumber = executionNumber;
// }

// }

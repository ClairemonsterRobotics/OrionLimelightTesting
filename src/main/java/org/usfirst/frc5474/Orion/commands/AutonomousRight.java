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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5474.Orion.Robot;
//import org.usfirst.frc5474.Orion.subsystems.driveSub;

/**
 *
 */
public class AutonomousRight extends Command {
    public int autonState = 1;
    public final int AS_SONIC = 1;
    public final int AS_Cruise = 2;
    public final int cruiseDistance = 6;
    public final int SONIC_Distance = 56; // 18 inches
    public final int AS_rightTurn = 3;
    public final int right_Distance = (int) Math.round(12 * 2 * Math.PI); // 4pi ft / 180 degree turn; 2pi for 90 deg
    public final int AS_foward2 = 4;
    public final int foward2_Distance = 0; // NEED value
    public double currentRightDistance;
    public double currentLeftDistance;

    // public final int AS_Align = 4; //PIXY controlled?
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AutonomousRight() {

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.driveSub.leftPairEncoder.setDistancePerPulse(6*Math.PI/360);
        Robot.driveSub.rightPairEncoder.setDistancePerPulse(6*Math.PI/360); //6 inch wheel, one pulse per inch
        Robot.driveSub.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double distanceR = Robot.driveSub.rightPairEncoder.getDistance();
        double distanceL = Robot.driveSub.leftPairEncoder.getDistance();

        double distanceAvg = (distanceL + distanceR) / 2; 

        switch (autonState) {
        case AS_SONIC: {
            if (distanceAvg < SONIC_Distance) { // if not at the target location
                SmartDashboard.putString("", "this is to see if this code works");
                Robot.driveSub.driveStraight(((.5/SONIC_Distance)*distanceAvg)+.1); // drive straight at some power l
                SmartDashboard.putString("", "we forgot sully doesnt have encoders");
            } else {
                Robot.driveSub.resetEncoders();
                autonState++;
            }
            
            break;
        }
        case (AS_Cruise): {
            if(distanceAvg < cruiseDistance){
                Robot.driveSub.driveStraight(-.04*(distanceAvg-56) +.6); //reduces speed to .36 in 6 in
            } else {
                Robot.driveSub.resetEncoders();
                autonState++;
            }
            break;
        }
        case (AS_rightTurn): {
            Robot.driveSub.stop();
        }
    }
    }


    // move foward 10 feet

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

}

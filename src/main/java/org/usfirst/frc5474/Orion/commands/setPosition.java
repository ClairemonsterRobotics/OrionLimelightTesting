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
import org.usfirst.frc5474.Orion.subsystems.armSub;


/**
 *
 */
public class setPosition extends Command {

    public int encHatch1 = (int) (1.5 * 12) * 2; // int to round, params: (feet[common measurement]*inch conversion)*2
    // for encoder ticks
    public int encBall1 = (int) (1.6 * 12) * 2;
    public double localArmPos;
    public double localhingePos;
    public int counter = 0;
    private boolean armMovingFinished = false;

    // NERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    //public int encHatch1 = (int)(1.5*12)*2; //int to round, params: (feet[common measurement]*inch conversion)*2 for encoder ticks
    //public int encBall1 = (int)(1.6*12)*2;

    private double armPosition;
    private boolean atTarget;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public setPosition(double armPos, int hingePos) {
        localArmPos = armPos;
        localhingePos = hingePos;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.armSub);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    
    public setPosition(){
        requires(Robot.armSub);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.armSub.armDirection(localArmPos);
        Robot.armSub.getHingeCurrentPos();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        //armMovingFinished = Robot.armSub.moveArmToPos(localArmPos);
        if (localhingePos == 1){
            Robot.armSub.bringLevel();
        } else if (localhingePos == 2){
            Robot.armSub.bringtoDropAngle();
        } else if (localhingePos == 3){
            Robot.armSub.bringUpright();
        }

        counter++;
        SmartDashboard.putNumber("counting up", counter);
        if (armMovingFinished == true) {
            Robot.armSub.verifyArmStop();
            isFinished();
        }
    }
    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return armMovingFinished;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        cancel();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}

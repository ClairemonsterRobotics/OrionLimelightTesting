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
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5474.Orion.Robot;
//import org.usfirst.frc5474.Orion.subsystems.driveSub;

/**
 *
 */
public class AutonomousSide extends Command {
    static double degToRad = Math.PI/180.0;
    static enum AutonState{
        BEGIN, DISMOUNT, ADVANCE, TURN, APPROACH, END
    }
    final double distancePerPulse = 6*Math.PI/360;
    AutonState curState = AutonState.BEGIN;
    private final double dismountDistance = 24;
    private final double dismountSpeed = 0.3;
    private final double advanceDistance = 56;
    private final double advanceSpeed = 0.1;
    private double turnDegrees = 30;
    private double turnSpeed = 0.1;
    private final double approachDistance = 24;
    private final double approachSpeed = 0.1;

    public AutonomousSide(boolean isLeft) {
        if(isLeft){
            turnDegrees*=-1;
            turnSpeed*=-1;
        }
    }

    private boolean AS_Dismount(double distR, double distL){
        double avg = 0.5*(distR+distL);
        Robot.driveSub.driveStraight(dismountSpeed);
        return (avg >= dismountDistance);
    }
    private boolean AS_Advance(double distR, double distL){
        double avg = 0.5*(distR+distL);
        Robot.driveSub.driveStraight(advanceSpeed);
        return (avg >= advanceDistance);
    }
    private boolean AS_Turn(double distR, double distL){
        double dist = -0.5*(distR-distL);
        double degreesTurned=degToRad*dist/16.0; // (arclength / robot radius)
        Robot.driveSub.swivelRight(turnSpeed);
        return (degreesTurned >= turnDegrees);
    }
    private boolean AS_Approach(double distR, double distL){
        double avg = 0.5*(distR+distL);
        Robot.driveSub.driveStraight(approachSpeed);
        return (avg >= approachDistance);
    }
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.driveSub.leftPairEncoder.setDistancePerPulse(distancePerPulse);
        Robot.driveSub.rightPairEncoder.setDistancePerPulse(distancePerPulse); //6 inch wheel, one pulse per inch
        Robot.driveSub.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double distanceR = Robot.driveSub.rightPairEncoder.getDistance();
        double distanceL = Robot.driveSub.leftPairEncoder.getDistance();

        switch(curState){
            case BEGIN:
                Robot.driveSub.resetEncoders();
                curState = AutonState.DISMOUNT;
                break;
            case DISMOUNT:
                if(AS_Dismount(distanceR,distanceL)){
                    Robot.driveSub.resetEncoders();
                    curState = AutonState.ADVANCE;
                }
                break;
            case ADVANCE:
                if(AS_Advance(distanceR,distanceL)){
                    Robot.driveSub.resetEncoders();
                    curState = AutonState.TURN;
                }
                break;
            case TURN:
                if(AS_Turn(distanceR,distanceL)){
                    Robot.driveSub.resetEncoders();
                    curState = AutonState.APPROACH;
                }
                break;
            case APPROACH:
                if(AS_Approach(distanceR,distanceL)){
                    Robot.driveSub.resetEncoders();
                    curState = AutonState.END;
                }
                break;
            case END:
                Robot.driveSub.resetEncoders();
                Robot.driveSub.stop();
                break;
            default:
                Robot.driveSub.resetEncoders();
                Robot.driveSub.stop();
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

}

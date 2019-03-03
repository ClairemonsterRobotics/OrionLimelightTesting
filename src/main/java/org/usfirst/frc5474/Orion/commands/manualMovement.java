/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5474.Orion.commands;

import org.usfirst.frc5474.Orion.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class manualMovement extends Command {
  public manualMovement() {
    requires(Robot.armSub);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.armSub.resetArmEncoder();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    Robot.armSub.moveArmManual(Robot.oi.proJoystick.getRawAxis(1));
    //SmartDashboard.putBoolean("Code Past Moving Arm:", true);

    SmartDashboard.putNumber("POV value??", Robot.oi.proJoystick.getRawAxis(4));
    if (Robot.oi.proJoystick.getPOV() != -1) {
      if ((Robot.oi.proJoystick.getPOV() < 80 || Robot.oi.proJoystick.getPOV() > 280)){
          //&& Robot.oi.proJoystick.getPOV() != 1) {
        Robot.armSub.armSmallMove(true);
        //Robot.armSub.manualHingeCIM(false);
        //SmartDashboard.putString("hinge state", "going up");
      } else if (100 < Robot.oi.proJoystick.getPOV() && Robot.oi.proJoystick.getPOV() < 260){
          //&& Robot.oi.proJoystick.getPOV() != 1) {
        Robot.armSub.armSmallMove(false);
        //Robot.armSub.manualHingeCIM(true);
        //SmartDashboard.putString("hinge state", "going down");
      }
    }
    else {
      //SmartDashboard.putString("hinge state", "nill");
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

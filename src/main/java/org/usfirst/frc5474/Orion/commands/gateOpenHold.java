/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5474.Orion.commands;

import org.usfirst.frc5474.Orion.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class gateOpenHold extends Command {

  public gateOpenHold() {

    //requires(Robot.pClawSub);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.pGateSub);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.pGateSub.gateExtend();
  }
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    cancel();
  }

  @Override
  public synchronized void cancel() {
    Robot.pGateSub.gateRetract();
    super.cancel();
  }


  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}

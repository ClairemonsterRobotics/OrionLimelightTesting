/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5474.Orion.commands;

import org.usfirst.frc5474.Orion.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveSlider extends Command {
  public MoveSlider() {
    requires(Robot.pGateSub);

    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.SliderToggle = !Robot.SliderToggle;
    if(Robot.SliderToggle){
      Robot.pGateSub.sliderExtend();
    } else {
      Robot.pGateSub.sliderRetract();
    }
    end();
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

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    cancel();
  }
}

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


// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class pGateSub extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private Compressor clawCompressor;
    private DoubleSolenoid clawSolenoid;
    private DoubleSolenoid pushSolenoid;
    private DoubleSolenoid R1Solenoid;
    private DoubleSolenoid R2Solenoid;
    private Spark clawLeftMotor;
    private Spark clawRightMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public pGateSub() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        //clawCompressor = new Compressor(1);
        //addChild("clawCompressor",clawCompressor);
        //clawCompressor.setClosedLoopControl(true);
        
        //first parameter is node, CAN address of PCM
        clawSolenoid = new DoubleSolenoid(1, 0, 7);
        addChild("clawSolenoid",clawSolenoid);
        clawSolenoid.set(DoubleSolenoid.Value.kReverse); //will close the claw at the start of the match
        
        
        
        pushSolenoid = new DoubleSolenoid(1, 1, 6);
        addChild("pushSolenoid",pushSolenoid);
        pushSolenoid.set(DoubleSolenoid.Value.kReverse);
       

        R1Solenoid = new DoubleSolenoid(1, 2, 5);
        addChild("R1Solenoid",R1Solenoid);
        R1Solenoid.set(DoubleSolenoid.Value.kReverse);

        R2Solenoid = new DoubleSolenoid(1, 3, 4);
        addChild("R2Solenoid",R2Solenoid);
        R2Solenoid.set(DoubleSolenoid.Value.kReverse);

        //clawLeftMotor = new Spark(10);
        //clawLeftMotor.setInverted(false);

        //clawRightMotor = new Spark(20);
        //clawRightMotor.setInverted(false);
        
    

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        //SmartDashboard.putBoolean("claw rev blacklist", clawSolenoid.isRevSolenoidBlackListed());
        //SmartDashboard.putBoolean("pusher rev blacklist", pushSolenoid.isRevSolenoidBlackListed());
        // Put code here to be run every loop

    }

    public void pistonExtend() { //claw is closed
        //SmartDashboard.putString("", "piston extend");
        clawSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void pistonRetract() { //claw is open
        //SmartDashboard.putString("", "piston retract");
        clawSolenoid.set(DoubleSolenoid.Value.kReverse);
        //clawSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public void pushBall() {
        pushSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void returnPusher() {
        pushSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public void runIntake(){
        clawLeftMotor.set(0.5);
        clawRightMotor.set(0.5);

    }
    
    public void runSpinningOut(){
        clawLeftMotor.set(-0.5);
        clawRightMotor.set(-0.5);
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}
//ground control to major tom (syncing test)

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

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.usfirst.frc5474.Orion.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class armSub extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private Spark armMotor;
    private Encoder armEncoder;
    private boolean goingUp;
    public boolean moveArmComplete = false;
    public static int hingeStartPos;
    public static int upright = 17500 + hingeStartPos;
    public static int dropangle = 8500 + hingeStartPos;
    public static int flat = 700 + hingeStartPos;
    //public static int downangle = -100 + hingeStartPos;
    public static TalonSRX hingeTalon;
    public int hingeCurrentPos = 0;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public armSub() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        armMotor = new Spark(4);
        addChild("armMotor", armMotor);
        armMotor.setInverted(false);

        armEncoder = new Encoder(0, 1, false);
        addChild("armEncoder", armEncoder);
        armEncoder.setDistancePerPulse(3 * Math.PI / 360); // ~3 inch gear
        armEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
        // armEncoder.setIndexSource(2, IndexingType.kResetOnRisingEdge);

        hingeTalon = new TalonSRX(0); // encoder / controller
        // final int kSlotIdx = 0;
        final int kPIDLoopIdx = 0;
        final int kTimeoutMs = 10;
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        hingeTalon.setNeutralMode(NeutralMode.Coast);

        hingeTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, kPIDLoopIdx, kTimeoutMs);

        hingeTalon.setSensorPhase(true);

        /* set the peak and nominal outputs, 12V means full */

        hingeTalon.configNominalOutputForward(0, kTimeoutMs);

        hingeTalon.configNominalOutputReverse(0, kTimeoutMs);

        hingeTalon.configPeakOutputForward(1, kTimeoutMs);

        hingeTalon.configPeakOutputReverse(-1, kTimeoutMs);

        /*
         * set the allowable closed-loop error,
         * 
         * Closed-Loop output will be neutral within this range.
         * 
         * See Table in Section 17.2.1 for native units per rotation.
         * 
         */

        hingeTalon.configAllowableClosedloopError(0, kPIDLoopIdx, kTimeoutMs); /* always servo */

        /* set closed loop gains in slot0 */

        hingeTalon.config_kF(kPIDLoopIdx, 0.0, kTimeoutMs);

        hingeTalon.config_kP(kPIDLoopIdx, 0.4, kTimeoutMs); // slows sooner to the stopping point

        hingeTalon.config_kI(kPIDLoopIdx, 0.0, kTimeoutMs);

        hingeTalon.config_kD(kPIDLoopIdx, 0.0, kTimeoutMs);

        // elevatorStartPos =
        // RobotMap.elevatorSubelevatorController.getSelectedSensorPosition(0);

        // SmartDashboard.putNumber("elevator start pos", elevatorStartPos);
        hingeTalon.configForwardSoftLimitEnable(false, 0);
        hingeTalon.configReverseSoftLimitEnable(false, 0);

        // SmartDashboard.putNumber("MOTOR OUTPUT %:",
        // hingeTalon.getMotorOutputPercent());

        // hingeTalon.set(ControlMode.PercentOutput, 0);
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
        hingeCurrentPos = hingeTalon.getSelectedSensorPosition();
        // Put code here to be run every loop
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void getHingeStartPos() {
        hingeStartPos = hingeTalon.getSelectedSensorPosition();
    }

    public void armDirection(double armPos) {
        double currentArmPos = armEncoder.getDistance();
        if (currentArmPos < armPos) {
            goingUp = true;
        } else {
            goingUp = false;
        }

    }

    public boolean moveArmToPosition(double armPos) {
        double currentArmPos = armEncoder.getDistance();
        if (goingUp == true) {
            if (currentArmPos < armPos) {
                armMotor.set(.1);

            } else {
                armMotor.set(0);
                moveArmComplete = true;
            }
        }

        else {
            if (currentArmPos > armPos) {
                armMotor.set(-.1);

            } else {
                armMotor.set(0);
                moveArmComplete = true;
            }
        }
        return (moveArmComplete);
    }

    public void goToPos(int goToPos, String targetPos) {
        if (hingeCurrentPos > goToPos) {
            SmartDashboard.putString("Target Position", targetPos);
            hingeTalon.set(ControlMode.Position, -goToPos);
            SmartDashboard.putNumber("Current Position", hingeTalon.getSelectedSensorPosition(0));
        } else {
            SmartDashboard.putString("Target Position", targetPos);
            hingeTalon.set(ControlMode.Position, goToPos);
            SmartDashboard.putNumber("Current Position", hingeTalon.getSelectedSensorPosition(0));
        }
    }

    public void bringUpright() {
        goToPos(upright, "Tucked In - " + upright);
    }

    public void bringtoDropAngle() {
        goToPos(dropangle, "Drop Angle" + dropangle);
    }

    public void bringLevel() {
        goToPos(flat, "Level 3 - " + flat);
    }

    public int getYDirection(){
        int armDirection = 0;
        double yhand =Robot.oi.proJoystick.getRawAxis(1);
        if (yhand > 0){
            armDirection = 1;
        }
        else if (yhand < 0){
            armDirection = 2;
        }
        else {
            armDirection = 0;
        }
        return armDirection;
    }

    public double getSensitivity(){
        double sensitivitySlider = Robot.oi.proJoystick.getRawAxis(3);
        return sensitivitySlider;
    }

    public void moveArmManual(int direction, double sensitivity){
        if (direction == 1){
            armMotor.set(sensitivity/1.2); //adjust the dividing values so that the slider doesnt impact the sensitivity TOO much
        }
        else if (direction == 2){
            armMotor.set(-sensitivity/1.2); // ^^, also sensitivity may need to be inverted
        }
        else if (direction == 0){
            armMotor.set(0);
        }
    }
    //public void bringtoDownAngle() {
    //    goToPos(downangle, "Level 1 - " + downangle);
    //}

}

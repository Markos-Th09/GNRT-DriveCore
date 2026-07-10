package org.firstinspires.ftc.teamcode.Tuners;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Config.HardwareMapConfig;
import org.firstinspires.ftc.teamcode.Subsystems.TankDrive;

// This TEST FILE: tunes the feedforward values for the drivebase motors
// (++ FTCDashboard Config Variables)

//@Disabled // TEST FILE: It is Disabled the OpMode so it doesnt show up in the driver station
@TeleOp(name="DrivetrainDirectionsTuner", group="Tuners")
public class DrivetrainDirectionsTuner extends LinearOpMode {
    private DcMotorEx leftMotor, rightMotor;

    @Override
    public void runOpMode() {
        leftMotor = hardwareMap.get(DcMotorEx.class, HardwareMapConfig.LEFT_DRIVE_ID);
        rightMotor = hardwareMap.get(DcMotorEx.class, HardwareMapConfig.RIGHT_DRIVE_ID);

        leftMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        rightMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        waitForStart();

        while (opModeIsActive()) {
            leftMotor.setPower(gamepad1.a ? 0.3 : 0);
            rightMotor.setPower(gamepad1.a ? 0.3 : 0);
        }
    }
}

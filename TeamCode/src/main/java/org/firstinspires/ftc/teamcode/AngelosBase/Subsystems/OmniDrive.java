package org.firstinspires.ftc.teamcode.AngelosBase.Subsystems;


import static org.firstinspires.ftc.teamcode.AngelosBase.Config.OmniDriveConfig.MAX_SPEED;

import com.qualcomm.hardware.bosch.BHI260IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.AngelosBase.Config.HardwareMapConfig;
import org.firstinspires.ftc.teamcode.AngelosBase.Config.OmniDriveConfig;

public class OmniDrive {
    public enum DriveMode {
        ROBOT_CENTRIC, FIELD_CENTRIC
    }

    private DriveMode driveMode = DriveMode.ROBOT_CENTRIC;

    private Telemetry telemetry;


    private final DcMotorEx leftFrontDrive;
    private final DcMotorEx leftBackDrive;
    private final DcMotorEx rightFrontDrive;
    private final DcMotorEx rightBackDrive;

    private IMU imu;

    public OmniDrive(HardwareMap hardwareMap, Telemetry telemetry) {
        leftFrontDrive = hardwareMap.get(DcMotorEx.class, HardwareMapConfig.LEFT_FRONT_DRIVE_ID);
        leftBackDrive = hardwareMap.get(DcMotorEx.class, HardwareMapConfig.LEFT_BACK_DRIVE_ID);
        rightFrontDrive = hardwareMap.get(DcMotorEx.class, HardwareMapConfig.RIGHT_FRONT_DRIVE_ID);
        rightBackDrive = hardwareMap.get(DcMotorEx.class, HardwareMapConfig.RIGHT_BACK_DRIVE_ID);

        leftFrontDrive.setDirection(OmniDriveConfig.LEFT_FRONT_DRIVE_DIRECTION);
        leftBackDrive.setDirection(OmniDriveConfig.LEFT_BACK_DRIVE_DIRECTION);
        rightFrontDrive.setDirection(OmniDriveConfig.RIGHT_FRONT_DRIVE_DIRECTION);
        rightBackDrive.setDirection(OmniDriveConfig.RIGHT_BACK_DRIVE_DIRECTION);

        imu = hardwareMap.get(IMU.class, HardwareMapConfig.IMU_ID);

        imu = hardwareMap.get(BHI260IMU.class, "imu");

        RevHubOrientationOnRobot orientationOnRobot =
                new RevHubOrientationOnRobot(
                        OmniDriveConfig.CONTROL_HUB_LOGO_DIRECTION,
                        OmniDriveConfig.CONTROL_HUB_USB_PORT_DIRECTION);

        imu.initialize(new IMU.Parameters(orientationOnRobot));
        imu.resetYaw();

        this.telemetry = telemetry;
        telemetry.addData("Drive Train", "INITIALIZED");
    }

    public void driveFieldCentric(double forward, double strafe, double rotate) {
        double botHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
        double rotX = strafe * Math.cos(-botHeading) - forward * Math.sin(-botHeading);
        double rotY = strafe * Math.sin(-botHeading) + forward * Math.cos(-botHeading);

        // Normalizing the motor powers
        double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rotate), 1);
        double frontLeftPower = (rotY + rotX + rotate) * MAX_SPEED / denominator;
        double backLeftPower = (rotY - rotX + rotate) * MAX_SPEED / denominator;
        double frontRightPower = (rotY - rotX - rotate) * MAX_SPEED / denominator;
        double backRightPower = (rotY + rotX - rotate) * MAX_SPEED / denominator;

        setPowers(frontLeftPower, backLeftPower, frontRightPower, backRightPower);
    }

    public void driveRobotCentric(double forward, double strafe, double rotate) {
        double denominator = Math.max(Math.abs(forward) + Math.abs(strafe) + Math.abs(rotate), 1);
        double frontLeftPower  = (forward + strafe + rotate) * MAX_SPEED / denominator;
        double backLeftPower   = (forward - strafe + rotate) * MAX_SPEED / denominator;
        double frontRightPower = (forward - strafe - rotate) * MAX_SPEED / denominator;
        double backRightPower  = (forward + strafe - rotate) * MAX_SPEED / denominator;

        setPowers(frontLeftPower, backLeftPower, frontRightPower, backRightPower);
    }

    private void setPowers(double leftFrontPower, double leftBackPower, double rightFrontPower, double rightBackPower) {
        leftFrontDrive.setPower(leftFrontPower);
        leftBackDrive.setPower(leftBackPower);
        rightFrontDrive.setPower(rightFrontPower);
        rightBackDrive.setPower(rightBackPower);
    }

    public void setDriveMode(DriveMode driveMode) {
        this.driveMode = driveMode;
    }

    public DriveMode getDriveMode() {
        return this.driveMode;
    }
}

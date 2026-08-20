package org.firstinspires.ftc.teamcode.Samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Config.HardwareMapConfig;
import org.firstinspires.ftc.teamcode.Subsystems.TankDrive;
import org.firstinspires.ftc.teamcode.Util.CurrentTracker;
import org.firstinspires.ftc.teamcode.Util.GamepadEx;

import java.util.Arrays;

@Disabled
@TeleOp(name = "Sample_CurrentTracker", group = "Samples")
public class Sample_CurrentTracker extends LinearOpMode {
    private GamepadEx controller;
    private TankDrive drivetrain;
    private CurrentTracker currentTracker;

    @Override
    public void runOpMode() {
        controller = new GamepadEx(gamepad1);

        drivetrain = new TankDrive(
                hardwareMap,
                telemetry,
                controller::getLeftStickY,
                controller::getRightStickX,
                controller::getRightTrigger);

        currentTracker = new CurrentTracker(
                Arrays.asList(
                        HardwareMapConfig.LEFT_DRIVE_ID,
                        HardwareMapConfig.RIGHT_DRIVE_ID),
                hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            controller.update();

            drivetrain.update();

            currentTracker.update();

            currentTracker.addTelemetry(telemetry);
            telemetry.update();
        }
    }
}

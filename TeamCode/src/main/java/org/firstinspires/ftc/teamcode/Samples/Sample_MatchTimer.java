package org.firstinspires.ftc.teamcode.Samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Util.GamepadEx;
import org.firstinspires.ftc.teamcode.Util.MatchTimer;

@Disabled
@TeleOp(name = "Sample_MatchTimer", group = "Samples")
public class Sample_MatchTimer extends LinearOpMode {
    private MatchTimer matchTimer;
    private GamepadEx controller;

    @Override
    public void runOpMode() {
        controller = new GamepadEx(gamepad1);
        matchTimer = new MatchTimer();

        waitForStart();

        while (opModeIsActive()) {
            controller.update();

            matchTimer.startOnFirstInput(controller);

            telemetry.addData("Timer Started", matchTimer.hasStarted());
            telemetry.addData("Elapsed Time", matchTimer.getElapsedTimeSeconds());
            telemetry.update();
        }
    }
}

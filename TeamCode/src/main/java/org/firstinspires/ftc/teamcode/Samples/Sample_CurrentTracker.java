package org.firstinspires.ftc.teamcode.Samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Config.HardwareMapConfig;
import org.firstinspires.ftc.teamcode.Util.CurrentTracker;

import java.util.Arrays;

@Disabled
@TeleOp
public class Sample_CurrentTracker extends LinearOpMode {
    private CurrentTracker currentTracker;

    @Override
    public void runOpMode() {
        currentTracker = new CurrentTracker(
                Arrays.asList(
                        HardwareMapConfig.LEFT_DRIVE_ID,
                        HardwareMapConfig.RIGHT_DRIVE_ID
                ),
                hardwareMap,
                telemetry
        );

        waitForStart();

        while (opModeIsActive()) {
            currentTracker.update();
        }
    }
}

package org.firstinspires.ftc.teamcode.AngelosBase.Config;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Config
public class OmniDriveConfig {

    // Non-Tunable constants
    public final static DcMotorSimple.Direction LEFT_FRONT_DRIVE_DIRECTION = DcMotorSimple.Direction.FORWARD;
    public final static DcMotorSimple.Direction LEFT_BACK_DRIVE_DIRECTION = DcMotorSimple.Direction.FORWARD;
    public final static DcMotorSimple.Direction RIGHT_FRONT_DRIVE_DIRECTION = DcMotorSimple.Direction.REVERSE;
    public final static DcMotorSimple.Direction RIGHT_BACK_DRIVE_DIRECTION = DcMotorSimple.Direction.REVERSE;

    public final static RevHubOrientationOnRobot.LogoFacingDirection CONTROL_HUB_LOGO_DIRECTION = RevHubOrientationOnRobot.LogoFacingDirection.UP;
    public final static RevHubOrientationOnRobot.UsbFacingDirection CONTROL_HUB_USB_PORT_DIRECTION = RevHubOrientationOnRobot.UsbFacingDirection.LEFT;


    // Tunable at runtime constants
    public static double MAX_SPEED = 0.8;
}

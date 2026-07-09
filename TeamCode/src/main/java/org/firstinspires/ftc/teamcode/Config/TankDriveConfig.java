package org.firstinspires.ftc.teamcode.Config;

import com.qualcomm.robotcore.hardware.DcMotorEx;

public class TankDriveConfig {
    public static final boolean TELEMETRY_ENABLED = true;

    // Motor Configuration
    public static final DcMotorEx.Direction LEFT_MOTOR_DIRECTION = DcMotorEx.Direction.FORWARD; // Set to REVERSE if left motor is reversed
    public static final DcMotorEx.Direction RIGHT_MOTOR_DIRECTION = DcMotorEx.Direction.FORWARD; // Set to REVERSE if right motor is reversed
    public static final DcMotorEx.ZeroPowerBehavior MOTOR_ZERO_POWER_BEHAVIOR = DcMotorEx.ZeroPowerBehavior.BRAKE; // Set to FLOAT if you want the robot to coast when no power is applied

    // Feedforward constants
    // KS: is the static gain -> for Static Friction
    // KV: is the velocity gain -> Fixes Motor Inaccuracies Linearly
    public static final double[] LEFT_FEEDFORWARD = {0.03, 1.0}; // KS, KV for left motor
    public static final double[] RIGHT_FEEDFORWARD = {0.03, 1.0}; // KS, KV for right motor
    public static final double KS_THETA = 0.08; // Static gain for turning

    // Power Mapping Constants
    public static final double DEFAULT_POWER = 0.6; // Default power for driving
    public static final double MAX_POWER = 1.0; // Maximum power for driving
}

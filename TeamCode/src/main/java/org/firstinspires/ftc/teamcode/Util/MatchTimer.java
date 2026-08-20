package org.firstinspires.ftc.teamcode.Util;

import androidx.annotation.NonNull;

public class MatchTimer {
    private long startTime;
    private boolean started;

    private static final long MILLIS_IN_NANO = 1_000_000;
    private static final long SECONDS_IN_NANO = 1_000_000_000;

    public MatchTimer() {
        this.started = false;
        this.startTime = 0;
    }

    /**
     * Starts the timer if it hasn't been started yet.
     */
    public void start() {
        if (!started) {
            startTime = System.nanoTime();
            started = true;
        }
    }

    /**
     * Resets and starts the timer.
     */
    public void resetAndStart() {
        startTime = System.nanoTime();
        started = true;
    }

    /**
     * Returns the elapsed time in nanoseconds
     *
     * @return elapsed time in nanoseconds, or 0 if the timer has not started.
     */
    public long getElapsedTimeNano() {
        if (!started) {
            return 0;
        }
        return (System.nanoTime() - startTime);
    }

    /**
     * Returns the elapsed time in milliseconds.
     *
     * @return elapsed time in milliseconds, or 0 if the timer has not started.
     */
    public long getElapsedTimeMillis() {
        return getElapsedTimeNano() / MILLIS_IN_NANO;
    }

    /**
     * Returns the elapsed time in seconds.
     *
     * @return elapsed time in seconds, or 0 if the timer has not started.
     */
    public double getElapsedTimeSeconds() {
        return (double) getElapsedTimeNano() / SECONDS_IN_NANO;
    }

    /**
     * Checks if the timer has been started.
     */
    public boolean hasStarted() {
        return started;
    }

    /**
     * Starts the timer if there is any input on the gamepad.
     * @param controller The gamepad to check for input.
     */
    public void startOnFirstInput(@NonNull GamepadEx controller) {
        if (controller.hasInput()) {
            start();
        }
    }

    /**
     * Starts the timer if there is any input on either gamepad.
     * @param controller1 The first gamepad to check for input.
     * @param controller2 The second gamepad to check for input.
     */
    public void startOnFirstInput(@NonNull GamepadEx controller1, @NonNull GamepadEx controller2) {
        if (controller1.hasInput() || controller2.hasInput()) {
            start();
        }
    }
}

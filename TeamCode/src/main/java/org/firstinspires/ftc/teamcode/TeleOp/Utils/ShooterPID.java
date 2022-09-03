package org.firstinspires.ftc.teamcode.TeleOp.Utils;

import android.util.Half;

import com.acmerobotics.roadrunner.control.PIDCoefficients;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.Utils.TuningController;
import org.firstinspires.ftc.teamcode.Utils.VelocityPIDFController;

public class ShooterPID {
    // Copy your PID Coefficients here
    public static PIDCoefficients MOTOR_VELO_PID = new PIDCoefficients(5, 0, 0.5);

    // Copy your feedforward gains here
    public static double kV = 1 / TuningController.rpmToTicksPerSecond(TuningController.MOTOR_MAX_RPM);
    public static double kA = 0.5;
    public static double kStatic = 0;

    // Timer for calculating desired acceleration
    // Necessary for kA to have an affect
    public static final ElapsedTime veloTimer = new ElapsedTime();
    private static double lastTargetVelo = 0.0;

    // Our velocity controller
    private static final VelocityPIDFController veloController = new VelocityPIDFController(MOTOR_VELO_PID, kV, kA, kStatic);

    public static double targetVelo = 0;

    public static void run(){

        // Call necessary controller methods
        veloController.setTargetVelocity(targetVelo);
        veloController.setTargetAcceleration((targetVelo - lastTargetVelo) / veloTimer.seconds());
        veloTimer.reset();

        lastTargetVelo = targetVelo;

        // Get the velocity from the motor with the encoder
        double motorPos = Hardware.shooterLeft.getCurrentPosition();
        double motorVelo = Hardware.shooterLeft.getVelocity();

        // Update the controller and set the power for each motor
        double power = veloController.update(motorPos, motorVelo);
        Hardware.shooterLeft.setPower(power);
        Hardware.shooterRight.setPower(power);
    }

}

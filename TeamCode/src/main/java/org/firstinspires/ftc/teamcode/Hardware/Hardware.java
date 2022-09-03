package org.firstinspires.ftc.teamcode.Hardware;

import static org.firstinspires.ftc.teamcode.Hardware.HardwareUtils.*;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.robotcore.external.Telemetry;


@Config
public class Hardware extends HardwareDeclarations{


    public static double Kp=60, Ki=0, Kd=0, Kf=18;

    public static void hardwareMapping(){
        front_left = getDc("front_left");
        front_right = getDc("front_right");
        back_right = getDc("back_right");
        back_left = getDc("back_left");
        intake = getDc("intake");
        shooterLeft = getDcEx("shooterLeft");
        shooterRight = getDcEx("shooterRight");
        actionIntakeLeft = getServo("actionIntakeLeft");
        actionIntakeRight = getServo("actionIntakeRight");
        indexerRight = getCRServo("indexerRight");
        indexerLeft = getCRServo("indexerLeft");
    }

    public static void configureHardware(){
        shooterLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shooterRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shooterLeft.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, new PIDFCoefficients(Kp, Ki, Kd, Kf));
        shooterRight.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, new PIDFCoefficients(Kp, Ki, Kd, Kf));
        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        shooterRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        shooterLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        indexerRight.setDirection(DcMotorSimple.Direction.REVERSE);
        shooterRight.setDirection(DcMotorSimple.Direction.REVERSE);
        actionIntakeLeft.setPosition(0.30);
        actionIntakeRight.setPosition(0.70);
        indexerRight.setPower(0);
        indexerLeft.setPower(0);
        intake.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public static void init(HardwareMap hm, Telemetry telemetry) {
        HardwareDeclarations.telemetry = telemetry;
        HardwareDeclarations.hardwareMap = hm;
        HardwareDeclarations.telemetry.addLine("Initializing robot...");
        hardwareMapping();
        HardwareDeclarations.telemetry.addLine("Hardware mapping done!");
        configureHardware();
        HardwareDeclarations.telemetry.addLine("Configuring done!");
    }
}

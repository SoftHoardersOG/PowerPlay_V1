package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class HardwareDeclarations {
    public static DcMotor front_left, front_right, back_left, back_right;
    public static Telemetry telemetry;
    public static HardwareMap hardwareMap;
    public static DcMotor intake;
    public static DcMotorEx shooterLeft;
    public static DcMotorEx shooterRight;
    public static Servo actionIntakeLeft;
    public static Servo actionIntakeRight;
    public static CRServo indexerLeft;
    public static CRServo indexerRight;
}

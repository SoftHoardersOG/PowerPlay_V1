package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

public class HardwareUtils {
    public static DcMotor getDc(String name) {
        return Hardware.hardwareMap.get(DcMotor.class, name);
    }

    public static AnalogInput getAnalogInput(String name) {
        return Hardware.hardwareMap.get(AnalogInput.class, name);
    }

    public static Servo getServo(String name) {
        return Hardware.hardwareMap.get(Servo.class, name);
    }

    public static CRServo getCRServo(String name) {
        return Hardware.hardwareMap.get(CRServo.class, name);
    }

    public static DistanceSensor getDistanceSensor(String name) {
        return Hardware.hardwareMap.get(DistanceSensor.class, name);
    }

    public static void changeDirection(DcMotor... dcMotors) {
        for (DcMotor dcMotor : dcMotors) {
            if (dcMotor.getDirection() == DcMotorSimple.Direction.FORWARD) {
                dcMotor.setDirection(DcMotorSimple.Direction.REVERSE);
            } else {
                dcMotor.setDirection(DcMotorSimple.Direction.FORWARD);
            }
        }
    }

    public static void changeDirection(CRServo... servos) {
        for (CRServo servo : servos) {
            if (servo.getDirection() == DcMotorSimple.Direction.FORWARD) {
                servo.setDirection(DcMotorSimple.Direction.REVERSE);
            } else {
                servo.setDirection(DcMotorSimple.Direction.FORWARD);
            }
        }
    }

    public static void RunningWithEncoders(DcMotor... dcMotors) {
        for (DcMotor dcMotor : dcMotors) {
            dcMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            dcMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
    }

    public static void RunningWithoutEncoders(DcMotor... dcMotors) {
        for (DcMotor dcMotor : dcMotors) {
            dcMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }

    public static void ResetEncoders(DcMotor... dcMotors) {
        for (DcMotor dcMotor : dcMotors) {
            dcMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            dcMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }
}

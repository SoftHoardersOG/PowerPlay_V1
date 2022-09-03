package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.Utils.OneTap;

public class Intake {
    private static final OneTap changeState = new OneTap();
    public static boolean isOuttaking = false;

    public static void run(Gamepad gamepad) {
        if (gamepad.b) {
            Hardware.intake.setPower(-1);
            Hardware.indexerLeft.setPower(-1);
            Hardware.indexerRight.setPower(-1);
            isOuttaking = true;
        } else {
            isOuttaking = false;
        }
        if (changeState.onPress(gamepad.a)) {
            if (Hardware.intake.getPower() == -1) {
                Hardware.intake.setPower(1);
            } else {
                Hardware.intake.setPower(1 - Hardware.intake.getPower());
                if (Hardware.intake.getPower()==1){
                    Hardware.indexerRight.setPower(-0.2);
                    Hardware.indexerLeft.setPower(-0.2);
                }
            }
        }
        if (gamepad.dpad_down) {
            lowerIntake();
        }
        if (gamepad.dpad_up) {
            raiseIntake();
        }
    }

    public static void lowerIntake() {
        Hardware.actionIntakeLeft.setPosition(1);
        Hardware.actionIntakeRight.setPosition(0);
    }

    public static void raiseIntake() {
        Hardware.actionIntakeLeft.setPosition(0.3);
        Hardware.actionIntakeRight.setPosition(0.7);
    }
}

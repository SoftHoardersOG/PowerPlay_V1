package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.Utils.OneTap;

public class Shooter {
    private static final OneTap toggleShooter = new OneTap();
    public static void run(Gamepad gamepad){
        if (toggleShooter.onPress(gamepad.x)){
            Hardware.shooter.setPower(1-Hardware.shooter.getPower());
        }
        if (gamepad.y){
            Hardware.indexerRight.setPower(1);
            Hardware.indexerLeft.setPower(1);
        }
        else{
            Hardware.indexerRight.setPower(0);
            Hardware.indexerLeft.setPower(0);
        }
    }
}

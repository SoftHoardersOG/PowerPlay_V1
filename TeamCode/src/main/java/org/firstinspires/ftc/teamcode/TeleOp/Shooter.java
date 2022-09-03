package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.Utils.OneTap;

public class Shooter {
    private static final OneTap toggleShooter = new OneTap();
    private static boolean isShooting = false;
    public static void run(Gamepad gamepad){
        if (toggleShooter.onPress(gamepad.x)){
            isShooting = !isShooting;
            if (isShooting){
                Hardware.shooterLeft.setVelocity(1400);
                Hardware.shooterRight.setVelocity(1400); 
            }
            else{
                Hardware.shooterLeft.setVelocity(0);
                Hardware.shooterRight.setVelocity(0);
            }
        }
        if (gamepad.y){
            Hardware.indexerRight.setPower(1);
            Hardware.indexerLeft.setPower(1);
            Hardware.intake.setPower(1);
        }
        else if (gamepad.right_bumper){
            Hardware.indexerRight.setPower(1);
            Hardware.indexerLeft.setPower(1);
            Hardware.intake.setPower(0);
        }
        else if(!Intake.isOuttaking){
            Hardware.indexerRight.setPower(0);
            Hardware.indexerLeft.setPower(0);
        }
    }
}

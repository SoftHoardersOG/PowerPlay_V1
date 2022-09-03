package org.firstinspires.ftc.teamcode.TeleOp;

import static org.firstinspires.ftc.teamcode.Hardware.HardwareUtils.getDc;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.RoadRunner.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.TeleOp.Utils.Initializations;

@TeleOp(name = "TestDrive", group = "Test")
public class TestDrive extends LinearOpMode{

    public static DcMotor front_left, front_right, back_left, back_right;
    @Override
    public void runOpMode() throws InterruptedException {
        front_left = getDc("front_left");
        front_right = getDc("front_right");
        back_right = getDc("back_right");
        back_left = getDc("back_left");
        while(opModeIsActive()&&!isStopRequested()){
            if (gamepad1.a){
                front_left.setPower(1);
            }
            if(gamepad1.b){
                front_right.setPower(1);
            }
            if(gamepad1.x){
                back_right.setPower(1);
            }
            if (gamepad1.y){
                back_left.setPower(1);
            }
        }
    }
}

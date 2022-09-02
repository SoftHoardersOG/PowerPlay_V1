package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RoadRunner.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.TeleOp.Utils.Initializations;

@TeleOp(name = "TeleOp", group = "Main")
public class MainTeleOp extends LinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        Initializations.TeleOpInitialization(drive, telemetry, hardwareMap);
        waitForStart();
        Intake.lowerIntake();
        while(opModeIsActive()&&!isStopRequested()){
            Movement.driving(gamepad1);
            Intake.run(gamepad1);
            telemetry.update();
        }
    }
}

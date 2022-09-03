package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.RoadRunner.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.TeleOp.Utils.Initializations;
import org.firstinspires.ftc.teamcode.TeleOp.Utils.ShooterPID;

@TeleOp(name = "TeleOp", group = "Main")
public class MainTeleOp extends LinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException {
        for (LynxModule module : hardwareMap.getAll(LynxModule.class)) {
            module.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        Initializations.TeleOpInitialization(drive, telemetry, hardwareMap);
        waitForStart();
        ShooterPID.veloTimer.reset();
        Intake.lowerIntake();
        while(opModeIsActive()&&!isStopRequested()){
            Movement.driving(gamepad1);
            Intake.run(gamepad1);
            Shooter.run(gamepad1);
            telemetry.addData("shooter left velo:", Hardware.shooterLeft.getVelocity());
            telemetry.addData("shooter right velo:", Hardware.shooterRight.getVelocity());
            telemetry.update();
        }
    }
}

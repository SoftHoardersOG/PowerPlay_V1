package org.firstinspires.ftc.teamcode.Hardware;

import static org.firstinspires.ftc.teamcode.Hardware.HardwareUtils.*;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Hardware extends HardwareDeclarations{

    public static void hardwareMapping(){
        front_left = getDc("front_left");
        front_right = getDc("front_right");
        back_right = getDc("back_right");
        back_left = getDc("back_left");
        intake = getDc("intake");
        shooter = getDc("shooter");
        actionIntakeLeft = getServo("actionIntakeLeft");
        actionIntakeRight = getServo("actionIntakeRight");
        indexerRight = getCRServo("indexerRight");
        indexerLeft = getCRServo("indexerLeft");
    }

    public static void configureHardware(){
        indexerRight.setDirection(DcMotorSimple.Direction.REVERSE);
        actionIntakeLeft.setPosition(0.30);
        actionIntakeRight.setPosition(0.70);
        indexerRight.setPower(0);
        indexerLeft.setPower(0);
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

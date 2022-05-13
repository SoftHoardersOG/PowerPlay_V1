package org.firstinspires.ftc.teamcode.Hardware;

import static org.firstinspires.ftc.teamcode.Hardware.HardwareUtils.getDc;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Hardware extends HardwareDeclarations{

    public static void hardwareMapping(){
        front_left = getDc("front_left");
        front_right = getDc("front_right");
        back_right = getDc("back_right");
        back_left = getDc("back_left");
    }

    public static void init(HardwareMap hm, Telemetry telemetry) {
        HardwareDeclarations.telemetry = telemetry;
        HardwareDeclarations.hardwareMap = hm;
        HardwareDeclarations.telemetry.addLine("Initializing robot...");
        hardwareMapping();
        HardwareDeclarations.telemetry.addLine("Hardware mapping done!");

        HardwareDeclarations.telemetry.addLine("Configurating done!");
    }
}

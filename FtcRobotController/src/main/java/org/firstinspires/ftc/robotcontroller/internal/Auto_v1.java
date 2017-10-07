package org.firstinspires.ftc.robotcontroller.internal;

/**
 * Created by Sagar on 10/7/2017.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous(name = "Auto Blue", group = "Dev")
public class Auto_v1 extends LinearOpMode {

    spellBook magic = new spellBook();

    @Override
    public void runOpMode() throws InterruptedException {

        magic.init(hardwareMap, telemetry);

        magic.gyroTel(telemetry);

        waitForStart();

        magic.Sense();

        magic.moveFwd(1, 1000);

    }

}

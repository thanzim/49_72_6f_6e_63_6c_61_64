package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Flash on 10/7/2017
 **/

@Autonomous(name = "vutest")

public class Vu_action extends LinearOpMode{

    spellBook magic = new spellBook();

    @Override
    public void runOpMode() throws InterruptedException{

        magic.initium(hardwareMap, telemetry);

        waitForStart();

        while(opModeIsActive()){

            magic.vu_arbitrium(hardwareMap, telemetry);

            break;

        }

    }

}

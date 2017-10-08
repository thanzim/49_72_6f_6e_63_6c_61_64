package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
/**
 * Created by Flash on 10/7/2017.
 */


@Autonomous(name = "Auto Blue", group = "Dev")
public class Auto_v1 extends LinearOpMode {

    spellBook magic = new spellBook(); //getting 'magic' objects from spellbook

    @Override
    public void runOpMode() throws InterruptedException {

        magic.initium(hardwareMap, telemetry);

        magic.conversus_autem(telemetry);

        waitForStart();


            magic.inveneris_comede(); //Hit jewel

            magic.movere_deinceps(1, 1000); //fwd

            magic.serpens_sinistram(1, 2500); // strafe left

            magic.recedite(1, 2000);//backwards

    }

}

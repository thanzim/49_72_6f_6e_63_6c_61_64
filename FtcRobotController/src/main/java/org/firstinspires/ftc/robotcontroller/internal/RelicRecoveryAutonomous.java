package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
/**
 * Created by Flash on 10/7/2017.
 */


@Autonomous(name = "Auto Blue", group = "Dev")
public class RelicRecoveryAutonomous extends LinearOpMode {

    robot robo = new robot(); //getting 'magic' objects from spellbook

    @Override
    public void runOpMode() throws InterruptedException {

        robo.init(hardwareMap, telemetry);

        robo.gyroTelemetry(telemetry);

        waitForStart();


            robo.bejewelblue(); //Hit jewel

            sleep(1500);

            robo.move(1, 1000); //fwd

            robo.strafeLeft(1, 2500); // strafe left

            robo.move(-1, 2000);//backwards

    }

}

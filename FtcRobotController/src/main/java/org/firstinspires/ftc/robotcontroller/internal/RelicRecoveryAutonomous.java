package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
/**
 * Created by Flash on 10/7/2017.
 */


@Autonomous(name = "Auto Bluee", group = "Dev")
public class RelicRecoveryAutonomous extends LinearOpMode {

    robot robo = new robot(); //getting 'magic' objects from spellbook

    @Override
    public void runOpMode() throws InterruptedException {

        robo.init(hardwareMap, telemetry);

        robo.returnGeneralTelemetry(telemetry);




        waitForStart();

        robo.leftArm.setPosition(0.4);
        robo.rightArm.setPosition(0.7);

        robo.returnGeneralTelemetry(telemetry);

        //sleep(10000);

        robo.Arm.setPower(0.2);

        sleep(200);

        robo.bejewelblue(); //Hit jewel

        robo.Arm.setPower(0.2);

        sleep(200);

        robo.strafeRight(1, 1000);

    }

}

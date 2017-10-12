package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Flash on 10/7/2017
 **/

@Autonomous(name = "vutest")


public class Vu_action extends LinearOpMode{

    robot robo = new robot();

    @Override
    public void runOpMode() throws InterruptedException{

        robo.init(hardwareMap, telemetry);

        waitForStart();

        while(opModeIsActive()){

            robo.vudoo(hardwareMap, telemetry);

            break;

        }

    }

}

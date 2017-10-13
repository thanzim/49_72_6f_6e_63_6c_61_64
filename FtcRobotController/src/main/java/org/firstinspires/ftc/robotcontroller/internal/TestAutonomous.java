package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Robotics15 on 10/12/2017.
 */

@Autonomous(name="testauto", group = "")
public class TestAutonomous extends LinearOpMode{

    robot robo = new robot();

    @Override
    public void runOpMode() throws InterruptedException {

        robo.init(hardwareMap, telemetry);

        waitForStart();

        robo.gyroAbsoluteTurn(90,1, this);
        robo.gyroRelativeTurn(-35, 1, this);
        robo.gyroAbsoluteTurn(90,1,this);


    }
}

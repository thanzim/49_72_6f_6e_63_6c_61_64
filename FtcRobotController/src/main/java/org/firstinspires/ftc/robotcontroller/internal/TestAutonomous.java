package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Thanzim on 10/12/2017.
 */

@Autonomous(name="testauto", group = "")
@Disabled
public class TestAutonomous extends LinearOpMode{

    robot robo = new robot();
    thanzim_gyro tgyro = new thanzim_gyro();

    @Override
    public void runOpMode() throws InterruptedException {

        robo.init(hardwareMap, telemetry);

        waitForStart();

        tgyro.gyroAbsoluteTurn(90,1, this);
        tgyro.gyroRelativeTurn(-35, 1, this);
        tgyro.gyroAbsoluteTurn(90,1,this);


    }
}

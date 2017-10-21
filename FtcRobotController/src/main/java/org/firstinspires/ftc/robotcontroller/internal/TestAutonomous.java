package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Thanzim on 10/12/2017.
 */

@Autonomous(name="testauto", group = "")
public class TestAutonomous extends LinearOpMode{

    robot robo = new robot();
    gyro_source gyro = new gyro_source();

    @Override
    public void runOpMode() throws InterruptedException {

        robo.init(hardwareMap, telemetry);

        waitForStart();

        gyro.gyroAbsoluteTurn(90,1, this);
        gyro.gyroRelativeTurn(-35, 1, this);
        gyro.gyroAbsoluteTurn(90,1,this);


    }
}

package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Thanzim on 10/12/2017.
 */

@Autonomous(name="testautooo", group = "")
public class TestAutonomous extends LinearOpMode{

    robot robo = new robot();
    gyro_source gyro = new gyro_source();
    ultrasensor_source ult = new ultrasensor_source();


    @Override
    public void runOpMode() throws InterruptedException {

        robo.init(hardwareMap, telemetry);

        waitForStart();

        ult.moveUntillLarger(0.8, 15, robo.ultra, false, this);
        gyro.gyroAbsoluteTurn(90,1,this,telemetry);
        ult.moveUntillLesser(1,7,robo.ultra, true, this);





    }

    public void quickCheck(){
        robo.returnGeneralTelemetry(telemetry);
        sleep(1000);
    }

}

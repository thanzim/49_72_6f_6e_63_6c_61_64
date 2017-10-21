package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by Robotics15 on 10/20/2017.
 */

public class SamatarSactionedProgram extends LinearOpMode{

    DcMotor m1;
    DcMotor m2;

    @Override
    public void runOpMode() throws InterruptedException {

        m1 = hardwareMap.dcMotor.get("m1");
        m2 = hardwareMap.dcMotor.get("m2");

        m1.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();







    }
}

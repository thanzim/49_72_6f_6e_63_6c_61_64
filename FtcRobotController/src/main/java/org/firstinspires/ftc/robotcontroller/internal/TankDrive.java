package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Robotics15 on 10/14/2017.
 */
@TeleOp(name="TankDrive", group = "")
public class TankDrive extends LinearOpMode{

    robot robo = new robot();

    double lvalue = 0;
    double rvalue = 0;

    @Override
    public void runOpMode() throws InterruptedException {

        robo.initDriveTrain(hardwareMap, telemetry);

        waitForStart();

        while(opModeIsActive()){


            lvalue = -gamepad1.left_stick_y;
            rvalue =  -gamepad1.right_stick_y;

            robo.RFMotor.setPower(rvalue);
            robo.RFMotor.setPower(rvalue);
            robo.RFMotor.setPower(lvalue);
            robo.RFMotor.setPower(lvalue);



        }

    }
}

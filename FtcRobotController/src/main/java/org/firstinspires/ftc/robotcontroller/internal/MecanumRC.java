package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Flash on 10/12/2017.
 */


@TeleOp(name = "MecRC")
public class MecanumRC extends LinearOpMode {

    DcMotor RFMotor;
    DcMotor RBMotor;
    DcMotor LFMotor;
    DcMotor LBMotor;

    DcMotor Slide;

    Servo leftArm;
    Servo rightArm;

    @Override
    public void runOpMode() throws InterruptedException{

        telemetry.addData("Status", "Starting...");
        telemetry.update();

        Slide = hardwareMap.get(DcMotor.class, "slide");

        RFMotor = hardwareMap.get(DcMotor.class, "RFMotor");
        RBMotor = hardwareMap.get(DcMotor.class, "RBMotor");
        LFMotor = hardwareMap.get(DcMotor.class, "LFMotor");
        LBMotor = hardwareMap.get(DcMotor.class, "LBMotor");

        leftArm = hardwareMap.get(Servo.class, "leftArm");
        rightArm = hardwareMap.get(Servo.class, "rightArm");

        leftArm.setPosition(0);
        rightArm.setPosition(1);

        RFMotor.setDirection(DcMotor.Direction.REVERSE);
        RBMotor.setDirection(DcMotor.Direction.REVERSE);

        sleep(2000);
        telemetry.addData("Status", "Initialized, go ahead and hit start papi");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()){

            float slideup  = gamepad2.right_trigger;
            float slidedwn = gamepad2.left_trigger;

            float Ch1 = -gamepad1.left_stick_y;
            float Ch2 =  gamepad1.left_stick_x;
            float Ch3 =  gamepad2.right_stick_x;

            float RFPower;
            float RBPower;
            float LFPower;
            float LBPower;

            float SlidePwr;

            if (gamepad2.a){

                leftArm.setPosition(0.5);
                rightArm.setPosition(0.5);

            }else if(gamepad2.b){

                leftArm.setPosition(0);
                rightArm.setPosition(1);

            }else{

                break;

            }

            RFPower = Range.clip(Ch1 + Ch2 - Ch3, -1, 1);
            RBPower = Range.clip(-Ch1 - Ch2 - Ch3, -1, 1);
            LFPower = Range.clip(Ch1 - Ch2 + Ch3, -1, 1);
            LBPower = Range.clip(-Ch1 + Ch2 + Ch3, -1, 1);

            SlidePwr = Range.clip(slideup - slidedwn, -1, 1);

            RFMotor.setPower(RFPower);
            RBMotor.setPower(RBPower);
            LFMotor.setPower(LFPower);
            LBMotor.setPower(LBPower);

            Slide.setPower(SlidePwr);

            idle();

        }
    }
}

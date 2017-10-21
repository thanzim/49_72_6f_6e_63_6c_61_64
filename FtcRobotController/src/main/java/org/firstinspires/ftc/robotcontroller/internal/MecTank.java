package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Flash on 10/20/2017.
 */

@TeleOp(name = "MecTank")
public class MecTank extends LinearOpMode{

    robot robo = new robot();
    ElapsedTime runtime = new ElapsedTime();


    //float slideup;
    //float slidedwn;
    float slide;

    float Ch1;
    float Ch2;
    float Ch3;
    float trR;
    float trL;



    float RFPower;
    float RBPower;
    float LFPower;
    float LBPower;

    float SlidePwr;

    double timePressed = -501;

    @Override
    public void runOpMode() throws InterruptedException{

        robo.initDriveTrain(hardwareMap, telemetry);

        robo.leftArm.setPosition(1);
        robo.rightArm.setPosition(0);

        waitForStart();

        while (opModeIsActive()){

            //slideup  = gamepad2.right_trigger;
            //slidedwn = gamepad2.left_trigger;

            slide = (-gamepad2.right_stick_y > 0.10 || -gamepad2.right_stick_y < -0.10 ? -gamepad2.right_stick_y : 0);

            Ch1 = -gamepad1.left_stick_y;
            Ch2 = -gamepad1.right_stick_y;
            trR = gamepad1.right_trigger;
            trL = gamepad1.left_trigger;
            Ch3 = trR - trL;


            if(gamepad2.a && (runtime.milliseconds() - timePressed) > 300) {
                if (gamepad2.a && robo.leftArm.getPosition() == 0.7) {

                    robo.leftArm.setPosition(0.4);
                    robo.rightArm.setPosition(0.7);
                    timePressed = runtime.milliseconds();

                }else{

                    robo.leftArm.setPosition(0.7);
                    robo.rightArm.setPosition(0.4);
                    timePressed = runtime.milliseconds();

                }
            }

            if(gamepad2.y){

                robo.leftArm.setPosition(1);
                robo.rightArm.setPosition(0);

            }

            if(gamepad2.dpad_up){

                robo.Flickr.setPosition(0.6);

            }

            if (gamepad2.dpad_down){

                robo.Flickr.setPosition(0.1);

            }

            RFPower = Range.clip(Ch2 - Ch3, -1, 1);
            RBPower = Range.clip(Ch2 + Ch3, -1, 1);
            LFPower = Range.clip(Ch1 + Ch3, -1, 1);
            LBPower = Range.clip(Ch1 - Ch3, -1, 1);

            SlidePwr = Range.clip(slide, -1, 1);

            robo.RFMotor.setPower(RFPower);
            robo.RBMotor.setPower(RBPower);
            robo.LFMotor.setPower(LFPower);
            robo.LBMotor.setPower(LBPower);

            robo.Arm.setPower(SlidePwr);

            idle();

        }
    }

}

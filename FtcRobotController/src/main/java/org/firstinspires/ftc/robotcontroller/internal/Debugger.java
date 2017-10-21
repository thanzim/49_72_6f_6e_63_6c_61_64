package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Robotics15 on 10/13/2017.
 */

@Autonomous(name = "Debugger", group = "3")
public class Debugger extends LinearOpMode {

    robot robo = new robot();
    thanzim_gyro tgyro = new thanzim_gyro();

    String[] method_ids = {"gyro_1", "gyro_2"};
    String selected_id = "none";
    boolean end_loop = false;

    @Override
    public void runOpMode() throws InterruptedException {

        for (int i = 0; i < method_ids.length; i++) {

            telemetry.addLine("Select Method with D-Pad");
            telemetry.addLine("Press A to confirm");
            sleep(200);
            if(end_loop){
                break;
            }
            telemetry.addLine(method_ids[i]);
            telemetry.update();


            while (!isStarted()) {

                idle();

                if (gamepad1.a) {
                    selected_id = method_ids[i];
                    end_loop = true;
                    break;
                }

                if (gamepad1.dpad_right) {
                    if(i == method_ids.length - 1){
                        i = -1;
                    }
                    break;
                }

                if (gamepad1.dpad_left) {
                    if (i == 0) {
                        i = method_ids.length - 1;
                    } else {
                        i = i - 2;
                        break;
                    }
                }

            }
        }

        telemetry.clear();
        requestOpModeStop();
    }


    }

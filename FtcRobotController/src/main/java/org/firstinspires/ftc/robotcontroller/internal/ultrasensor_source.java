package org.firstinspires.ftc.robotcontroller.internal;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * Created by Thanzim on 10/8/2017.
 */

public class ultrasensor_source extends robot {


    public void moveUntillLarger(double pwr, int distance, UltrasonicSensor ultra, boolean equalto, LinearOpMode method) {

        if (equalto) {
            while (ultra.getUltrasonicLevel() >= distance && method.opModeIsActive()) {
                move(pwr);
            }
        } else {
            while (ultra.getUltrasonicLevel() > distance && method.opModeIsActive()) {
                move(pwr);
            }
        }
    }

    public void moveUntillLesser(double pwr, int distance, UltrasonicSensor ultra, boolean equalto, LinearOpMode method) {

        if (equalto) {
            while (ultra.getUltrasonicLevel() <= distance && method.opModeIsActive()) {
                move(pwr);
            }
        } else {
            while (ultra.getUltrasonicLevel() < distance && method.opModeIsActive()) {
                move(pwr);
            }
        }
    }
}

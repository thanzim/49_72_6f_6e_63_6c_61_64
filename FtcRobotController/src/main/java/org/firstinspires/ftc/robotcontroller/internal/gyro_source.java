package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Thanzim on 10/8/2017.
 */

public class gyro_source extends robot {



    int heading;
    boolean CCW = false; // Stands for CounterClockwise
    int error = 1; // arbitrary value
    double pwfactor; //Power Factor

    public void gyroAbsoluteTurn(int angle, double factor, LinearOpMode method) {

        heading = mrGyro.getHeading();
        error = (angle - heading);

        if(error > 0){
            CCW = true;
        }
        else{
            CCW = false;
        }

        while(error != 0 && method.opModeIsActive()) {

            error = Math.abs(angle - heading);
            pwfactor = (factor * (error/90)+.25);

            if(CCW){
                left(pwfactor);
            }
            else{
                right(pwfactor);
            }

        }
    }

    public void gyroAbsoluteTurn(int angle, double factor, boolean ccw, LinearOpMode method) {

        heading = mrGyro.getHeading();
        error = (angle - heading);
        CCW = ccw;

        while(error != 0 && method.opModeIsActive()) {

            error = Math.abs(angle - heading);
            pwfactor = (factor * (error/90)+.25);

            if(CCW){
                left(pwfactor);
            }
            else{
                right(pwfactor);
            }

        }
    }

    public void gyroRelativeTurn(int angle, double factor, LinearOpMode method) {

        heading = mrGyro.getHeading();
        error = ((angle + heading) - heading);

        if(error > 0){
            CCW = true;
        }
        else{
            CCW = false;
        }

        while(error != 0 && method.opModeIsActive()) {

            error = Math.abs((angle + heading) - heading);
            pwfactor = (factor * (error/90)+.25);

            if(CCW){
                left(pwfactor);
            }
            else{
                right(pwfactor);
            }

        }
    }

    public void gyroRelativeTurn(int angle, double factor, boolean ccw, LinearOpMode method) {

        heading = mrGyro.getHeading();
        error = ((angle + heading) - heading);

        CCW = ccw;

        while(error != 0 && method.opModeIsActive()) {

            error = Math.abs((angle + heading) - heading);
            pwfactor = (factor * (error/90)+.25);

            if(CCW){
                left(pwfactor);
            }
            else{
                right(pwfactor);
            }

        }
    }

}

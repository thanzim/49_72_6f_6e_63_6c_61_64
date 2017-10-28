package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Thanzim on 10/8/2017.
 */

public class gyro_source extends robot {


    int heading;
    boolean CCW = false; // Stands for CounterClockwise
    int error = 1; // arbitrary value
    double pwfactor; //Power Factor

    public void gyroAbsoluteTurn(int angle, double factor, LinearOpMode method, Telemetry t) {

        heading = mrGyro.getHeading();
        error = (angle - heading);

        if(0 < error && error < 180){
            CCW = true;
        }
        else{
            CCW = false;
        }

        while(error != 0 && method.opModeIsActive()) {

            returnGeneralTelemetry(t);

            if(angle > mrGyro.getHeading() && angle > 0) {
                error = angle - mrGyro.getHeading();
            }else{
                error = mrGyro.getHeading() - angle;
            }
            pwfactor = (factor * (error/90)+.28);

            if(!CCW){
                left(pwfactor);
            }
            else{
                right(pwfactor);
            }

        }
        stop();
    }

    public void gyroAbsoluteTurn(int angle, double factor, boolean ccw, LinearOpMode method, Telemetry t) {

        heading = mrGyro.getHeading();
        error = (angle - heading);
        CCW = ccw;

        while(error != 0 && method.opModeIsActive()) {

            returnGeneralTelemetry(t);

            error = Math.abs(angle - mrGyro.getHeading());
            pwfactor = (factor * (error/90)+.25);

            if(!CCW){
                left(pwfactor);
            }
            else{
                right(pwfactor);
            }

        }
    }

    public void gyroRelativeTurn(int angle, double factor, LinearOpMode method, Telemetry t) {

        heading = mrGyro.getHeading();
        error = ((angle + heading) - angle);



        if(error > 0){
            CCW = true;
        }
        else{
            CCW = false;
        }

        while(error != 0 && method.opModeIsActive()) {

            returnGeneralTelemetry(t);

            error = Math.abs((angle + mrGyro.getHeading()) - mrGyro.getHeading());
            pwfactor = (factor * (error/90)+.25);

            if(!CCW){
                left(pwfactor);
            }
            else{
                right(pwfactor);
            }

        }
    }

    public void gyroRelativeTurn(int angle, double factor, boolean ccw, LinearOpMode method, Telemetry t) {

        heading = mrGyro.getHeading();
        error = ((angle + heading) - heading);

        CCW = ccw;

        while(error != 0 && method.opModeIsActive()) {

            returnGeneralTelemetry(t);

            error = Math.abs((angle + mrGyro.getHeading()) - mrGyro.getHeading());
            pwfactor = (factor * (error/90)+.25);

            if(!CCW){
                left(pwfactor);
            }
            else{
                right(pwfactor);
            }

        }
    }

}

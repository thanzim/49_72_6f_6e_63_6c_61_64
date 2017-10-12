package org.firstinspires.ftc.robotcontroller.internal;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * Created by Leopard on 10/8/2017.
 */

public class thanzim_ultrasensor extends robot {
    
    public thanzim_ultrasensor() {

    }

    public void moveUntillLargerThanValue(double pwr, int value, UltrasonicSensor ultra, boolean equalto, LinearOpMode method){

        if (equalto){
            while(ultra.getUltrasonicLevel() >= value && method.opModeIsActive() ){
                move(pwr);
            }
        }
        else{
            while(ultra.getUltrasonicLevel() > value && method.opModeIsActive()){
                move(pwr);
            }
        }
    }
}

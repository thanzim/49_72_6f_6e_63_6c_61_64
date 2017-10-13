package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.GyroSensor;

/**
 * Created by Thanzim on 10/7/2017.
 */

@Autonomous(name="Gyro_Testing_DONT_USE",group="Test")
public class GyroTest extends LinearOpMode {

    GyroSensor gyro; //gyrosensor
    ModernRoboticsI2cGyro mrGyro;

    @Override
    public void runOpMode() throws InterruptedException {

        // Configure Gyro to hardware map and assign it to physical gyro with name "g"
        gyro = hardwareMap.gyroSensor.get("g");

        //  Syntax; Actual meaning is lost on me, but what I can guess is that this line of code unlocks the full ability of MR Gyros
        mrGyro = (ModernRoboticsI2cGyro) gyro;

        // Meant to store a later value
        int zV;

        // To give the USER more time to allow the Gyro to callibrate
        Thread.sleep(1000);

        // Calibrate the gyro, this IS IMPORTANT
        mrGyro.calibrate();

        // Basic Syntax
        waitForStart();

        // This is in case the 'play' button is pressed while the robot is calibrating.
        while(mrGyro.isCalibrating()){
        }

        // Basic Linear Opmode Loop
        while(opModeIsActive()){

            // Stores a value to be returned
            zV = mrGyro.getIntegratedZValue();

            // Returns said value to the phone
            telemetry.addData(">", zV);
            telemetry.update();

            sleep(25);
            idle();
        }

    }
}

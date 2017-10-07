package org.firstinspires.ftc.robotcontroller.internal;



import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static java.lang.Thread.sleep;

/**
 * Created by Sagar on 10/7/2017.
 */

/**
 * THIS IS WHERE ALL THE MAGIC HAPPENS BOYS
 */

public class spellBook {



    DcMotor RFMotor;
    DcMotor RBMotor;
    DcMotor LFMotor;
    DcMotor LBMotor;

    Servo Flickr;

    ColorSensor colorSensor;

    GyroSensor gyro;
    ModernRoboticsI2cGyro mrGyro;

    int zV;

    public void init(HardwareMap hwm, Telemetry tel) throws InterruptedException {

        /**
         * Welcome to Ironclad 8080's spell-book.
         *
         * This is basically a method repository or cache for all of our methods
         *
         * This class is used in other programs for methods. Mainly Autonomous protocols
         */


        RFMotor = hwm.get(DcMotor.class, "RFMotor");
        RBMotor = hwm.get(DcMotor.class, "RBMotor");
        LFMotor = hwm.get(DcMotor.class, "LFMotor");
        LBMotor = hwm.get(DcMotor.class, "LBMotor");

        Flickr = hwm.get(Servo.class, "flickr");

        colorSensor = hwm.get(ColorSensor.class, "CS");

        gyro = hwm.gyroSensor.get("g");
        mrGyro = (ModernRoboticsI2cGyro) gyro;


        sleep(1000);

        mrGyro.calibrate();

        while (mrGyro.isCalibrating()){}

        RFMotor.setDirection(DcMotor.Direction.REVERSE);
        RBMotor.setDirection(DcMotor.Direction.REVERSE);

        colorSensor.enableLed(true);

        tel.addLine("Gyro has been calibrated");
        tel.addLine("Ready to go compadre");
        tel.update();
    }

    public void sensum_recta(double power, int angle )throws InterruptedException{

        //Turn right with gyro

        mrGyro.calibrate();
        Thread.sleep(1000);

        zV = mrGyro.getIntegratedZValue();

        RFMotor.setPower(-power);
        RBMotor.setPower(-power);
        LFMotor.setPower(power);
        LBMotor.setPower(power);

        while (zV != -angle) {

        }

        RFMotor.setPower(0);
        RBMotor.setPower(0);
        LFMotor.setPower(0);
        LBMotor.setPower(0);


    }

    public void sensum_sinistram(double power, int angle) throws InterruptedException{

        //turn left with gyro

        mrGyro.calibrate();
        Thread.sleep(1000);

        zV = mrGyro.getIntegratedZValue();

        RFMotor.setPower(power);
        RBMotor.setPower(power);
        LFMotor.setPower(-power);
        LBMotor.setPower(-power);

        while (zV != angle) {

        }

        RFMotor.setPower(0);
        RBMotor.setPower(0);
        LFMotor.setPower(0);
        LBMotor.setPower(0);

    }

    public void conversus_autem(Telemetry tel){

        //basic gyro telemetry

        zV = mrGyro.getIntegratedZValue();

        tel.addData(">", zV);
        tel.update();

    }

    public void inveneris_comede() throws InterruptedException{

        //Jewel mission decision method

        Flickr.setPosition(1);

        if (colorSensor.blue() > 2){

            recta_moveri(0.3, 500);

            movere_sinistram(0.3, 500);


        }

        if (colorSensor.red() > 2){

            movere_sinistram(0.3, 500);

            recta_moveri(0.3, 500);

        }

    }

    public void movere_sinistram(double power, long millis) throws InterruptedException{

        //Basic move left

        RFMotor.setPower(power);
        RBMotor.setPower(power);
        LFMotor.setPower(-power);
        LBMotor.setPower(-power);

        sleep(millis);

        RFMotor.setPower(0);
        RBMotor.setPower(0);
        LFMotor.setPower(0);
        LBMotor.setPower(0);

    }

    public void recta_moveri(double power, long millis) throws  InterruptedException{

        //Basic move right

        RFMotor.setPower(-power);
        RBMotor.setPower(-power);
        LFMotor.setPower(power);
        LBMotor.setPower(power);

        sleep(millis);

        RFMotor.setPower(0);
        RBMotor.setPower(0);
        LFMotor.setPower(0);
        LBMotor.setPower(0);

    }

    public void recedite(double power, long millis) throws InterruptedException{

        //Basic move backwards

        RFMotor.setPower(-power);
        RBMotor.setPower(-power);
        LFMotor.setPower(-power);
        LBMotor.setPower(-power);

        sleep(millis);

        RFMotor.setPower(0);
        RBMotor.setPower(0);
        LFMotor.setPower(0);
        LBMotor.setPower(0);

    }

    public void movere_deinceps(double power, long millis) throws  InterruptedException{

        //Basic move forwards

        RFMotor.setPower(power);
        RBMotor.setPower(power);
        LFMotor.setPower(power);
        LBMotor.setPower(power);

        sleep(millis);

        RFMotor.setPower(0);
        RBMotor.setPower(0);
        LFMotor.setPower(0);
        LBMotor.setPower(0);

    }


}


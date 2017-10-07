package org.firstinspires.ftc.robotcontroller.internal;

import static java.lang.Thread.sleep;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

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

    public void init(HardwareMap hwm, Telemetry tel) {

        RFMotor = hwm.get(DcMotor.class, "RFMotor");
        RBMotor = hwm.get(DcMotor.class, "RBMotor");
        LFMotor = hwm.get(DcMotor.class, "LFMotor");
        LBMotor = hwm.get(DcMotor.class, "LBMotor");

        Flickr = hwm.get(Servo.class, "flickr");

        colorSensor = hwm.get(ColorSensor.class, "CS");

        RFMotor.setDirection(DcMotor.Direction.REVERSE);
        RBMotor.setDirection(DcMotor.Direction.REVERSE);

        colorSensor.enableLed(true);

        tel.addLine("Ready to go compadre");
        tel.update();
    }

    public void Sense() throws InterruptedException{

        Flickr.setPosition(1);

        if (colorSensor.blue() > 2){

            moveRight(0.3, 500);

            moveLeft(0.3, 500);


        }

        if (colorSensor.red() > 2){

            moveLeft(0.3, 500);

            moveRight(0.3, 500);

        }

    }

    public void moveLeft(double power, long millis) throws InterruptedException{

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

    public void moveRight(double power, long millis) throws  InterruptedException{

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

    public void moveBack(double power, long millis) throws InterruptedException{

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

    public void moveFwd(double power, long millis) throws  InterruptedException{

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


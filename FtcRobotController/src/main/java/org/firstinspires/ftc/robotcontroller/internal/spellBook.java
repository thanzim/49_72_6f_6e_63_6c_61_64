package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import static java.lang.Thread.sleep;

/**
 * Created by Flash on 10/7/2017.
 */

/**
 * THIS IS WHERE ALL THE MAGIC HAPPENS BOYS
 **/

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

    VuforiaLocalizer vuforia;

    /**
     * Welcome to Ironclad 8080's spell-book.
     *
     * This is basically a method repository or cache for all of our methods
     *
     * This class is used in other programs for methods. Mainly Autonomous protocols
     **/

    public void initium(HardwareMap hwm, Telemetry tel) throws InterruptedException {

        //Initialization for Auto_v1.java

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

        while (mrGyro.isCalibrating()) {
        }

        RFMotor.setDirection(DcMotor.Direction.REVERSE);
        RBMotor.setDirection(DcMotor.Direction.REVERSE);

        colorSensor.enableLed(true);

        tel.addLine("Gyro has been calibrated");
        tel.addLine("Ready to go compadre");
        tel.update();
    }

    /**
     * The following are general movement methods for a 4wd mecanum chassis
     **/

    public void sensum_recta(double power, int angle) throws InterruptedException {

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

    public void sensum_sinistram(double power, int angle) throws InterruptedException {

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

    public void conversus_autem(Telemetry tel) {

        //basic gyro telemetry

        zV = mrGyro.getIntegratedZValue();

        tel.addData(">", zV);
        tel.update();

    }

    public void inveneris_comede() throws InterruptedException {

        //Jewel mission decision method

        Flickr.setPosition(1);

        if (colorSensor.blue() > 2) {

            recta_moveri(0.3, 500);

            movere_sinistram(0.3, 500);


        }

        if (colorSensor.red() > 2) {

            movere_sinistram(0.3, 500);

            recta_moveri(0.3, 500);

        }

    }

    public void movere_sinistram(double power, long millis) throws InterruptedException {

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

    public void recta_moveri(double power, long millis) throws InterruptedException {

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

    public void recedite(double power, long millis) throws InterruptedException {

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

    public void movere_deinceps(double power, long millis) throws InterruptedException {

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

    public void serpens_sinistram(double power, long millis) throws InterruptedException {

        //strafe left

        RFMotor.setPower(power);
        RBMotor.setPower(-power);
        LFMotor.setPower(-power);
        LBMotor.setPower(power);

        sleep(millis);

        RFMotor.setPower(0);
        RBMotor.setPower(0);
        LFMotor.setPower(0);
        LBMotor.setPower(0);

    }

    public void serpens_recta(double power, long millis) throws InterruptedException {

        //strafe right

        RFMotor.setPower(-power);
        RBMotor.setPower(power);
        LFMotor.setPower(power);
        LBMotor.setPower(-power);

        sleep(millis);

        RFMotor.setPower(0);
        RBMotor.setPower(0);
        LFMotor.setPower(0);
        LBMotor.setPower(0);

    }

    /**
     * Vuforia specific development methods
     **/

    public void vu_arbitrium(HardwareMap hwm, Telemetry tel) throws InterruptedException{

        /**
         * Make a decision based on vuforia decoding
         * For a better understanding @see TestVu
         **/

        int cameraMonitorViewId = hwm.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hwm.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = "AaoqgOL/////AAAAGbOH/YIsFkN4qAHOJSZVLf8gODe8T4TOfcAa/PBKY/8Py7aUNG/Hf2wvZT4OeCPqO+q4RYULQ1VjmxrsvwKtUPLpwH7InEZKH5MA9gD/X4j2Bz0O1say2B5okUBajZDZ6dnAY8q9ngcJNVKnFQqIBLlLIdRsy6S6JonETSJXNtVJpVLmL9A70AxEp4+0NwfAVH7rP5oTeckggK5lG/eRUPYVlOthkVCXTDEJCXB3vnGfbzy2hnUxwZtJkES3Hnk0w6RGJKazKOas1pM24dCiNHj2/Wtz3DrTK5IxHuICKplblKil2ecH6dV0+pDO8wCEjTJBAunIbLugU9ctKDQFaTOLL8Rdb9oJIzy/bhWyLM5s";

        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables relicTracktables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTracktables.get(0);
        relicTemplate.setName("relicVuMarkTemplate");

        sleep(1000);

        relicTracktables.activate();

        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);

        if(vuMark == RelicRecoveryVuMark.RIGHT){

            recta_moveri(1, 500);

            tel.addData("VuMark", "Right visible", vuMark);

            OpenGLMatrix pose = ((VuforiaTrackableDefaultListener) relicTemplate.getListener()).getPose();

            if(pose != null){

                VectorF trans = pose.getTranslation();
                Orientation rot = Orientation.getOrientation(pose, AxesReference.EXTRINSIC, AxesOrder.XYX, AngleUnit.DEGREES);

                double tX = trans.get(0);
                double tY = trans.get(1);
                double tZ = trans.get(2);

                double rX = rot.firstAngle;
                double rY = rot.secondAngle;
                double rZ = rot.thirdAngle;

            }

        }else if(vuMark == RelicRecoveryVuMark.LEFT){

            movere_sinistram(1, 500);

            tel.addData("VuMark", "Left visible", vuMark);

            OpenGLMatrix pose = ((VuforiaTrackableDefaultListener) relicTemplate.getListener()).getPose();

            if(pose != null){

                VectorF trans = pose.getTranslation();
                Orientation rot = Orientation.getOrientation(pose, AxesReference.EXTRINSIC, AxesOrder.XYX, AngleUnit.DEGREES);

                double tX = trans.get(0);
                double tY = trans.get(1);
                double tZ = trans.get(2);

                double rX = rot.firstAngle;
                double rY = rot.secondAngle;
                double rZ = rot.thirdAngle;

            }

        }else if(vuMark == RelicRecoveryVuMark.CENTER){

            recedite(1, 500);

            tel.addData("VuMark", "Center visible", vuMark);

            OpenGLMatrix pose = ((VuforiaTrackableDefaultListener) relicTemplate.getListener()).getPose();

            if(pose != null){

                VectorF trans = pose.getTranslation();
                Orientation rot = Orientation.getOrientation(pose, AxesReference.EXTRINSIC, AxesOrder.XYX, AngleUnit.DEGREES);

                double tX = trans.get(0);
                double tY = trans.get(1);
                double tZ = trans.get(2);

                double rX = rot.firstAngle;
                double rY = rot.secondAngle;
                double rZ = rot.thirdAngle;

            }else{

                tel.addData("Vumark", "not visible");

            }

            tel.update();
        }
    }
}




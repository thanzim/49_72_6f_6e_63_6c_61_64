package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
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

public class robot {




    public static DcMotor RFMotor;
    public static DcMotor RBMotor;
    public static DcMotor LFMotor;
    public static DcMotor LBMotor;

    public static DcMotor Arm;

    public static Servo Flickr;
    public static Servo leftArm;
    public static Servo rightArm;


    public static ColorSensor colorSensor;

    public static GyroSensor gyro;
    public static ModernRoboticsI2cGyro mrGyro;

    int zV;

    VuforiaLocalizer vuforia;

    /**
     * This is basically a method repository or cache for all of our methods
     *
     * This class is used in other programs for methods. Mainly Autonomous protocols
     * as well as initialization protocols
     **/





    public void init(HardwareMap hwm, Telemetry tel) throws InterruptedException {

        //Initialization for RelicRecoveryAutonomous.java

        RFMotor = hwm.get(DcMotor.class, "RF");
        RBMotor = hwm.get(DcMotor.class, "RB");
        LFMotor = hwm.get(DcMotor.class, "LF");
        LBMotor = hwm.get(DcMotor.class, "LB");

        Arm = hwm.get(DcMotor.class, "arm");

        Flickr = hwm.get(Servo.class, "flck");
        leftArm = hwm.get(Servo.class, "ls");
        rightArm = hwm.get(Servo.class, "rs");

        colorSensor = hwm.get(ColorSensor.class, "CS");

        gyro = hwm.gyroSensor.get("g");
        mrGyro = (ModernRoboticsI2cGyro) gyro;

        mrGyro.calibrate();

        while (mrGyro.isCalibrating()) {
        }

        LFMotor.setDirection(DcMotor.Direction.REVERSE);
        LBMotor.setDirection(DcMotor.Direction.REVERSE);

        colorSensor.enableLed(true);

        Flickr.setPosition(0.6);

        leftArm.setPosition(1);
        rightArm.setPosition(0);

        tel.addLine("Gyro has been calibrated");
        tel.addLine("Ready to go compadre");
        tel.update();
    }


    public void initDriveTrain(HardwareMap hwm, Telemetry tel) throws InterruptedException {

        //Initialization for RelicRecoveryAutonomous.java

        RFMotor = hwm.get(DcMotor.class, "RF");
        RBMotor = hwm.get(DcMotor.class, "RB");
        LFMotor = hwm.get(DcMotor.class, "LF");
        LBMotor = hwm.get(DcMotor.class, "LB");

        Arm = hwm.get(DcMotor.class, "arm");

        Flickr = hwm.get(Servo.class, "flck");
        leftArm = hwm.get(Servo.class, "ls");
        rightArm = hwm.get(Servo.class, "rs");

        colorSensor = hwm.get(ColorSensor.class, "CS");

        gyro = hwm.gyroSensor.get("g");
        mrGyro = (ModernRoboticsI2cGyro) gyro;


        LFMotor.setDirection(DcMotor.Direction.REVERSE);
        LBMotor.setDirection(DcMotor.Direction.REVERSE);

        colorSensor.enableLed(true);
        Flickr.setPosition(0.6);

        tel.addLine("Ready to go drivetrain");
        tel.update();


    }


    /**
     * The following are general movement methods for a 4wd mecanum chassis
     **/


    @Deprecated
    public void basic_gyroTurn(double power, int angle) throws InterruptedException {

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


    @Deprecated
    public void basic_leftGyroTurn(double power, int angle) throws InterruptedException {

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


    public void gyroTelemetry(Telemetry tel) {

        //basic gyro telemetry

        zV = mrGyro.getIntegratedZValue();

        tel.addData(">", zV);
        tel.update();

    }


    public void bejewelblue() throws InterruptedException {

        //Jewel mission decision method (blue)

        Flickr.setPosition(0);

        sleep(1500);

        if (colorSensor.blue() > 2) {

            right(0.3, 500);

            left(0.3, 500);

            Flickr.setPosition(0.6);


        }

        if (colorSensor.red() > 2) {

            left(0.3, 500);

            right(0.3, 500);

            Flickr.setPosition(0.6);

        }

    }


    public void bejewelred() throws InterruptedException {

        //Jewel mission decision method (red)

        Flickr.setPosition(0.1);

        if (colorSensor.blue() > 2) {

            right(0.3, 500);

            left(0.3, 500);


        }

        if (colorSensor.red() > 2) {

            left(0.3, 500);

            right(0.3, 500);

        }

    }


    public void left(double power, long millis) throws InterruptedException {

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


    public void left(double power) {

        //Basic move left

        RFMotor.setPower(power);
        RBMotor.setPower(power);
        LFMotor.setPower(-power);
        LBMotor.setPower(-power);

    }


    public void right(double power, long millis) throws InterruptedException {

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


    public void right(double power){

        //Basic move right

        RFMotor.setPower(-power);
        RBMotor.setPower(-power);
        LFMotor.setPower(power);
        LBMotor.setPower(power);
    }


    public void move(double power, long millis) throws InterruptedException {

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


    public void move(double power) {

        //Basic move forwards

        RFMotor.setPower(power);
        RBMotor.setPower(power);
        LFMotor.setPower(power);
        LBMotor.setPower(power);

    }


    public void stop(){
        move(0);  // lazy coding, amirite?
    }


    public void strafeLeft(double power, long millis) throws InterruptedException {

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


    public void strafeRight(double power, long millis) throws InterruptedException {

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


    public void vudoo(HardwareMap hwm, Telemetry tel) throws InterruptedException{

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

            right(1, 500);

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

            left(1, 500);

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

            move(-1, 500);

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




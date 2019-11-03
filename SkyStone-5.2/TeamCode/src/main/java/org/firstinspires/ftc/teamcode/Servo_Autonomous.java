package org.firstinspires.ftc.teamcode;


import android.content.Context;

import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Servo_Autonomous", group="test")
public class Servo_Autonomous extends LinearOpMode {
    boolean soundPlaying = false;
    int     soundID         = 16;

    Servo left_hook, right_hook;
    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor FrontRightMotor, FrontLeftMotor, BackRightMotor, BackLeftMotor;
    HolonomicDrive holonomicDrive;

    @Override
    public void runOpMode() {

        FrontRightMotor  = hardwareMap.get(DcMotor.class, "front_right_drive");
        FrontLeftMotor = hardwareMap.get(DcMotor.class, "front_left_drive");
        BackRightMotor  = hardwareMap.get(DcMotor.class, "back_right_drive");
        BackLeftMotor = hardwareMap.get(DcMotor.class, "back_left_drive");

        holonomicDrive = new HolonomicDrive(FrontRightMotor, FrontLeftMotor, BackRightMotor, BackLeftMotor);

        left_hook = hardwareMap.servo.get("left_hook");
        right_hook = hardwareMap.servo.get("right_hook");

        left_hook .setPosition(.5);
        right_hook.setPosition(0.7);

        waitForStart();

        runtime.reset();
        holonomicDrive.autoDrive(0, 0.5);
        while (opModeIsActive() && runtime.seconds() < 1.4){
            telemetry.addData("Path", "TIME: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        holonomicDrive.stopMoving();
        runtime.reset();
        left_hook.setPosition(.9);
        right_hook.setPosition(.4);
        while (opModeIsActive() && runtime.seconds() < 1.0) {
            telemetry.addData("Path", "TIME: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        holonomicDrive.stopMoving();
        runtime.reset();
        holonomicDrive.autoDrive(180, 0.5);
        while (opModeIsActive() && runtime.seconds() < 1.9
        ){
            telemetry.addData("Path", "TIME: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        holonomicDrive.stopMoving();
        runtime.reset();
        left_hook.setPosition(0.5);
        right_hook.setPosition(0.7);
        while (opModeIsActive() && runtime.seconds() < 1.0){
            telemetry.addData("Path", "TIME: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        Context myApp = hardwareMap.appContext;
        SoundPlayer.PlaySoundParams params = new SoundPlayer.PlaySoundParams();
        params.loopControl = 0;
        params.waitForNonLoopingSoundsToFinish = false;
        SoundPlayer.getInstance().startPlaying(myApp, soundID, params, null,
                new Runnable() {
                    public void run() {
                        soundPlaying = false;
                    }} );

    }


}

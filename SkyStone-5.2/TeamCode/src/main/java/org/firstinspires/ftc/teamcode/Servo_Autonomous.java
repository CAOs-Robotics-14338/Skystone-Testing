package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="Servo_Autonomous", group="test")
public class Servo_Autonomous extends LinearOpMode {

    Servo left_hook, right_hook;

    @Override
    public void runOpMode() {
        left_hook = hardwareMap.servo.get("left_hook");
        right_hook = hardwareMap.servo.get("right_hook");

        left_hook .setPosition(0);
        right_hook.setPosition(0);

        waitForStart();

        left_hook.setPosition(.5);
        right_hook.setPosition(.5);

        sleep(2000);

        left_hook.setPosition(0);
        right_hook.setPosition(0);


    }


}

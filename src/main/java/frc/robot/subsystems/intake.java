package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;


import java.lang.System.Logger;
import java.util.function.DoubleSupplier;


public class intake extends SubsystemBase{
    private final intakeIO wheel;
 
    public intake(intakeIO wheel) {
        this.wheel = wheel;
    }

    public void periodic() {
        wheel.periodic();
    }

    public void setWheelVelocity(double velocity) {
        wheel.setVelocity(velocity);
    }

}


package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

import java.util.function.DoubleSupplier;


public interface intakeIO {

    public default void setVelocity(double normalizedVelocity) {}


    public default double getVelocityPercent() {
        return 0.0;
    }

    public default void periodic() {

    }

    public default void setBrakeMode(boolean brake) {}
}

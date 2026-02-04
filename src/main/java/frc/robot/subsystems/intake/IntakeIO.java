package frc.robot.subsystems.intake;

<<<<<<< Updated upstream
=======
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

import java.util.function.DoubleSupplier;
>>>>>>> Stashed changes


public interface IntakeIO {

    public default void setVelocity(double normalizedVelocity) {}


    public default double getVelocityPercent() {
        return 0.0;
    }

    public default void periodic() {

    }

    public default void setBrakeMode(boolean brake) {}
}

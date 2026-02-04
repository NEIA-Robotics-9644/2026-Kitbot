package frc.robot.subsystems.intake;

<<<<<<< Updated upstream

import edu.wpi.first.wpilibj2.command.SubsystemBase;

=======
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;

import java.lang.System.Logger;
import java.util.function.DoubleSupplier;
>>>>>>> Stashed changes


public class Intake extends SubsystemBase{
    private final IntakeIO wheel;
 
    public Intake(IntakeIO wheel) {
        this.wheel = wheel;
    }

    public void periodic() {
        wheel.periodic();
    }

    public void setWheelVelocity(double velocity) {
        wheel.setVelocity(velocity);
    }

}


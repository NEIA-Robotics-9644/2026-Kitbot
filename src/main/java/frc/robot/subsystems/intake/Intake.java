package frc.robot.subsystems.intake;


import edu.wpi.first.wpilibj2.command.SubsystemBase;



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


package frc.robot.subsystems.intake;



public interface IntakeIO {

    public default void setVelocity(double normalizedVelocity) {}


    public default double getVelocityPercent() {
        return 0.0;
    }

    public default void periodic() {

    }

    public default void setBrakeMode(boolean brake) {}
}

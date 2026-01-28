package frc.robot.subsystems.Shooter;

import com.revrobotics.spark.SparkMax;

public class ShooterSubsystem {

    private SparkMax motor;

    public ShooterSubsystem (int id){
        this.motor = new SparkMax(id, null);
    }
    
    
    public void setVelocity(double normalizedVelocity){
        motor.set(normalizedVelocity);
    }

    public void periodic(){}

}

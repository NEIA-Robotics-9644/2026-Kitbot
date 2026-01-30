package frc.robot.subsystems.intake;
import com.revrobotics.spark.SparkMax;

public class IntakeIOSparkMax implements IntakeIO{

    
    private SparkMax motor;


    public IntakeIOSparkMax(int id) {
         this.motor = new SparkMax(id, null);
    }

    

    @Override
    public void setVelocity(double normalizedVelocity) {
        motor.set(normalizedVelocity);
    }

    @Override
    public void periodic() {}


}
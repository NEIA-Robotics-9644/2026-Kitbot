package frc.robot.subsystems.intake;
<<<<<<< Updated upstream
import com.revrobotics.spark.SparkMax;

=======

import com.revrobotics.spark.SparkMax;

//import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import frc.robot.subsystems.intake.IntakeIO;



 
>>>>>>> Stashed changes
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
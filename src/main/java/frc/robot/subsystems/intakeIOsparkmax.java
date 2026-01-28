package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;

//import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.motorcontrol.Spark;



 
public class intakeIOsparkmax implements intakeIO{

    
    private SparkMax motor;


    public intakeIOsparkmax(int id) {
         this.motor = new SparkMax(id, null);
    }

    

    @Override
    public void setVelocity(double normalizedVelocity) {
        motor.set(normalizedVelocity);
    }

    @Override
    public void periodic() {}


}
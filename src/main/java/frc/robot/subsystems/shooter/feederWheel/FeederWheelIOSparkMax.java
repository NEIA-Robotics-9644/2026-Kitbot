package frc.robot.subsystems.shooter.feederWheel;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

import com.revrobotics.spark.SparkLowLevel.MotorType;
// import com.revrobotics.can;

public class FeederWheelIOSparkMax implements FeederWheelIO {

    private final SparkMax feederMotor;

    private final SparkMaxConfig config = new SparkMaxConfig();
    
    private boolean newInput = false;

    private double normalizedVelocity = 0.0;

    private double maxSpeedRPM = 5000.0;

    final int maxCurrentA = 40;


    public FeederWheelIOSparkMax(int canID) {
        this.feederMotor = new SparkMax(canID, MotorType.kBrushless);
        this.config.smartCurrentLimit(maxCurrentA);
        this.feederMotor.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);       
        Shuffleboard.getTab("Current").addDouble("Feeder Motor Output Current", () -> feederMotor.getOutputCurrent());
        

    }

    @Override
    public void spinWheel(double normalizedVelocity) {
        this.normalizedVelocity = Math.max(-1.0, Math.min(1.0, normalizedVelocity));
        newInput = true;
    }

    @Override
    public double getVelocityPercent() {
        return feederMotor.getEncoder().getVelocity() / maxSpeedRPM;
    }

    @Override
    public void periodic() {
        if (newInput) {
            feederMotor.set(normalizedVelocity);
            newInput = false;
        } else {
            feederMotor.set(0.0);
        }

        
    }

    

    @Override
    public void setBrakeMode(boolean brake) {
        config.idleMode(brake ? IdleMode.kBrake : IdleMode.kCoast);
        feederMotor.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);

    }
}
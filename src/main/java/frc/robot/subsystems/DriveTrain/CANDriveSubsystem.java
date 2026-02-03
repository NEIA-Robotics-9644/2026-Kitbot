package frc.robot.subsystems.DriveTrain;

import java.util.function.DoubleSupplier;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.subsystems.DriveTrain.Constants.DriveConstants;

//import static frc.robot.Constants.DriveConstants.*;

public class CANDriveSubsystem extends SubsystemBase {

  private final SparkMax left_Leader;
  private final SparkMax left_Follower;
  private final SparkMax right_Leader;
  private final SparkMax right_Follower;

  private final DifferentialDrive drive;
  private final SparkMaxConfig config;

  public CANDriveSubsystem() {

    left_Leader = new SparkMax(DriveConstants.LEFT_LEADER_ID, MotorType.kBrushless);
    left_Follower = new SparkMax(DriveConstants.LEFT_FOLLOWER_ID, MotorType.kBrushless);

    right_Leader = new SparkMax(DriveConstants.RIGHT_LEADER_ID, MotorType.kBrushless);
    right_Follower = new SparkMax(DriveConstants.RIGHT_FOLLOWER_ID, MotorType.kBrushless);

    
    config = new SparkMaxConfig();
    config.inverted(true);
    left_Leader.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    drive = new DifferentialDrive(left_Leader, right_Leader);
  }

  public void driveArcade(double xSpeed, double zRotation) {
    drive.arcadeDrive(xSpeed, zRotation);
  }

  @Override
  public void periodic() {
    left_Follower.set(left_Leader.get());
    right_Follower.set(right_Leader.get());
    
  }
  public Command driveArcade(DoubleSupplier xSpeed, DoubleSupplier zRotation) {
    return this.run(
    () -> drive.arcadeDrive(xSpeed.getAsDouble(), zRotation.getAsDouble()));
  }

}
 



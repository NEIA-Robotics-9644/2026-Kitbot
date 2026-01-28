package frc.robot.subsystems.DriveTrain;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;




public class DriveSubsystem extends SubsystemBase {

  // Motors I Included followers now 
  private final SparkMax m_leftLeader = new SparkMax(1,MotorType.kBrushless);
  private final SparkMax m_leftFollower = new SparkMax(2, MotorType.kBrushless);
  
  private final SparkMax m_rightLeader = new SparkMax(3, MotorType.kBrushless);
  private final SparkMax m_rightFollower = new SparkMax(4, MotorType.kBrushless);

  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftLeader, m_rightLeader);

  private final SparkMaxConfig config = new SparkMaxConfig();

  public DriveSubsystem(){

    config.inverted(true);
    m_leftLeader.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

  }

  public void tankDrive(double leftSpeed, double rightSpeed){
    m_drive.tankDrive(0, 0);


  }

  public void periodic(){
    m_leftFollower.set(m_leftLeader.get());
    m_rightFollower.set(m_rightFollower.get());


  }
}
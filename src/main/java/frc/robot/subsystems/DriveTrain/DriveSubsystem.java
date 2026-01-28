package frc.robot.subsystems.DriveTrain;

import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;




public class DriveSubsystem extends SubsystemBase {

  // Motors I Included followers now 
  private final SparkMax m_leftLeader = new SparkMax(1, null);
  private final SparkMax m_leftFollower = new SparkMax(2, null);
  
  private final SparkMax m_rightLeader = new SparkMax(3, null);
  private final SparkMax m_rightFollower = new SparkMax(4, null);

  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftLeader, m_rightLeader);


  public DriveSubsystem(){

    m_leftLeader.setInverted(true);

  }

  public void tankDrive(double leftSpeed, double rightSpeed){
    m_drive.tankDrive(0, 0);


  }

  public void periodic(){
    m_leftFollower.set(m_leftLeader.get());
    m_rightFollower.set(m_rightFollower.get());


  }
}
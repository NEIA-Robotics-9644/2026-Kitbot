package frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;




public class DriveSubsystem extends SubsystemBase {

  // Motors I Included followers now 
  private final Spark m_leftLeader = new Spark(1);
  private final Spark m_leftFollower = new Spark(3);
  
  private final Spark m_rightLeader = new Spark(2);
  private final Spark m_rightFollower = new Spark(4);

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
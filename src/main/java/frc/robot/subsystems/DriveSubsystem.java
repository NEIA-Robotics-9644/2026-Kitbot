package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;




public class DriveSubsystem {

  // Motors 
  public static final int LEFT_MOTOR_ID = 1;
  public static final int RIGHT_MOTOR_ID = 2;

  private final Spark leftMotor = new Spark(LEFT_MOTOR_ID);
  private final Spark rightMotor = new Spark(RIGHT_MOTOR_ID);


// Groups for motors, this is crossed out because FRC says I should not use it 
  private final MotorControllerGroup leftGroup = new MotorControllerGroup(leftMotor);

  private final MotorControllerGroup rightGroup = new MotorControllerGroup(rightMotor);

  private final DifferentialDrive drive = new DifferentialDrive(leftGroup, rightGroup);

  /* 
  public DriveSubsystem() {
    rightGroup.setInverted(true);
  }
    */

  //Tank drive method 
  public void tankDrive(double leftSpeed, double rightSpeed) {
    drive.tankDrive(leftSpeed, rightSpeed);
  }
}

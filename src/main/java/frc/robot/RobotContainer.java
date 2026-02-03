package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Alert;
import edu.wpi.first.wpilibj.Alert.AlertType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.robot.subsystems.DriveTrain.CANDriveSubsystem;

public class RobotContainer {


  private final Alert driverDisconnected =
      new Alert("Driver controller disconnected (port 0).", AlertType.kWarning);

  private final Alert operatorDisconnected =
      new Alert("Operator controller disconnected (port 1).", AlertType.kWarning);

  // Controllers
  private final CommandXboxController driverCon =
      new CommandXboxController(0);

  private final CommandXboxController operatorCon =
      new CommandXboxController(1);

  // Subsystems
  private final CANDriveSubsystem driveSubsystem =
      new CANDriveSubsystem();

  private static final double DRIVE_SCALING = 0.5;
  private static final double ROTATION_SCALING = 0.5;

  public RobotContainer() {
    configureBindings();

    // drivetrain command
    driveSubsystem.setDefaultCommand(driveSubsystem.driveArcade(() -> -driverCon.getLeftY() * DRIVE_SCALING,() -> -driverCon.getRightX() * ROTATION_SCALING));
          }

  private void configureBindings() {
    
  }

  public Command getAutonomousCommand() {
    
    return Commands.none();
  }

  public void updateAlerts() {
    driverDisconnected.set(
        !DriverStation.isJoystickConnected(driverCon.getHID().getPort()));
    operatorDisconnected.set(
        !DriverStation.isJoystickConnected(operatorCon.getHID().getPort()));
  }
}

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.robot.subsystems.DriveTrain.CANDriveSubsystem;
import frc.robot.subsystems.DriveTrain.Constants.DriveConstants;

public class DriveCommand extends Command {

  private final CANDriveSubsystem driveSubsystem;
  private final CommandXboxController controller;

  public DriveCommand(
      CANDriveSubsystem driveSubsystem,
      CommandXboxController controller) {

    this.driveSubsystem = driveSubsystem;
    this.controller = controller;

    addRequirements(driveSubsystem);
  }

  @Override
  public void execute() {
    driveSubsystem.driveArcade(
        -controller.getLeftY() * DriveConstants.DRIVE_SCALING,
        -controller.getRightX() * DriveConstants.ROTATION_SCALING);
  }

  @Override
  public void end(boolean interrupted) {
    driveSubsystem.driveArcade(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

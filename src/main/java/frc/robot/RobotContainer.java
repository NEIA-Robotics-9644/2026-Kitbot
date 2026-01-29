package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.Alert;
import edu.wpi.first.wpilibj.Alert.AlertType;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.robot.subsystems.DriveTrain.CANDriveSubsystem;


public class RobotContainer {

  private final Alert driverDisconnected =
      new Alert("Driver controller disconnected (port 0).", AlertType.kWarning);
  private final Alert operatorDisconnected =
      new Alert("Operator controller disconnected (port 1).", AlertType.kWarning);
  private final Alert noAutoAlert =
      new Alert("Please select an auto routine!!! 😳", AlertType.kError);

  private Command noAuto = Commands.none();

  // Controller
  private final CommandXboxController driverCon = new CommandXboxController(0);
  private final CommandXboxController operatorCon = new CommandXboxController(1);

  private final CANDriveSubsystem driveSubsystem = new CANDriveSubsystem();
  public static int DRIVE_SCALING = 2;
  public static int ROATAION_SCALING = 3;




  public RobotContainer(){
    configureBindings();

    public Command driveArcade(DoubleSupplier xspeed, doubleSupplier zRotation){
      
    }

    driveSubsystem.setDefaultCommand(
      driveSubsystem.driveArcade(
        () -> -driverCon.getRightY()* DRIVE_SCALING, 
        () -> -driverCon.getLeftX()* ROATAION_SCALING ));
   }



   private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.none();
  }

  public void updateAlerts() {
    // Controller disconnected alerts
    driverDisconnected.set(!DriverStation.isJoystickConnected(driverCon.getHID().getPort()));
    operatorDisconnected.set(!DriverStation.isJoystickConnected(operatorCon.getHID().getPort()));

  }

/*public Command getAutonomousCommand() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAutonomousCommand'");
}
    */
}



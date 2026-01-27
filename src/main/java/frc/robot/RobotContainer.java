package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

import edu.wpi.first.wpilibj.Alert;
import edu.wpi.first.wpilibj.Alert.AlertType;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

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

  public RobotContainer(){
      //add things here
   }

  public Command getAutonomousCommand() {
    return Commands.none();
  }

  public void updateAlerts() {
    // Controller disconnected alerts
    driverDisconnected.set(!DriverStation.isJoystickConnected(driverCon.getHID().getPort()));
    operatorDisconnected.set(!DriverStation.isJoystickConnected(operatorCon.getHID().getPort()));

  }
}

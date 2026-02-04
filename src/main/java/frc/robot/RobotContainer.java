package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

// import org.jcp.xml.dsig.internal.dom.Utils;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.Alert;
import edu.wpi.first.wpilibj.Alert.AlertType;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.shooter.ShooterSubsystem;
import frc.robot.subsystems.shooter.feederWheel.FeederWheelIOSparkMax;

public class RobotContainer {

  private ShooterSubsystem shooter;

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

  Trigger xButton = operatorCon.x();

  public RobotContainer(){
      //add things here
      shooter = new ShooterSubsystem(
          new FeederWheelIOSparkMax(23),
          new double[] { 0, 25, 12, 52},
          new double[] { 1, 0.4, 1, 0.4},
          new double[] { 1, 0.4, 0, 1}
      );

      configureBindings();
   }

  public Command getAutonomousCommand() {
    return Commands.none();
  }

  public void updateAlerts() {
    // Controller disconnected alerts
    driverDisconnected.set(!DriverStation.isJoystickConnected(driverCon.getHID().getPort()));
    operatorDisconnected.set(!DriverStation.isJoystickConnected(operatorCon.getHID().getPort()));

  }

  private void configureBindings() {

    var operatorHID = operatorCon.getHID();
    var driverHID = driverCon.getHID();

    // SHOOTER COMMANDS

    // Bottom
    var oATrigger = new Trigger(() -> operatorHID.getAButton());
    oATrigger.whileTrue(Commands.run(() -> shooter.goToSetpoint(0)));
    
    // Protected Shot
    var oBTrigger = new Trigger(() -> operatorHID.getBButton());
    oBTrigger.whileTrue(Commands.run(() -> shooter.goToSetpoint(1)));
    
    // Source Intake
    var oXTrigger = new Trigger(() -> operatorHID.getXButton());
    oXTrigger.whileTrue(Commands.run(() -> shooter.goToSetpoint(2)));

    // Speaker
    var oYTrigger = new Trigger(() -> operatorHID.getYButton());
    oYTrigger.onTrue(Commands.runOnce(() -> shooter.goToSetpoint(3)));
    
    // Reset Shooter Angle
    // var oStartTrigger = new Trigger(() -> operatorHID.getStartButton());
    // oStartTrigger.whileTrue(new MoveShooterToBottomAndResetCmd(shooter, 0.2));

    // Adjust the shooter angle of this setpoint
    var oPOVUpTrigger = new Trigger(() -> operatorHID.getPOV() == 0);
    oPOVUpTrigger.onTrue(Commands.runOnce(() -> shooter.modifyAngleSetpoint(1)));
    
    var oPOVDownTrigger = new Trigger(() -> operatorHID.getPOV() == 180);
    oPOVDownTrigger.onTrue(Commands.runOnce(() -> shooter.modifyAngleSetpoint(-1)));
    


    // Adjust the shooter wheel speed of this setpoint
    
    var oPOVRightTrigger = new Trigger(() -> operatorHID.getPOV() == 90);
    oPOVRightTrigger.onTrue(Commands.runOnce(() -> shooter.modifyShooterSpeedSetpoint(0.01)));

    var oPOVLeftTrigger = new Trigger(() -> operatorHID.getPOV() == 270);
    oPOVLeftTrigger.onTrue(Commands.runOnce(() -> shooter.modifyShooterSpeedSetpoint(-0.01)));

    // Adjust the feeder wheel speed of this setpoint
    var oRightUpTrigger = new Trigger(() -> operatorHID.getRightY() > 0.7);
    oRightUpTrigger.onTrue(Commands.runOnce(() -> shooter.modifyFeederSetpoint(-0.01)));

    var oRightDownTrigger = new Trigger(() -> operatorHID.getRightY() < -0.7);
    oRightDownTrigger.onTrue(Commands.runOnce(() -> shooter.modifyFeederSetpoint(0.01)));

  }
}
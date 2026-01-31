package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveTrain.CANDriveSubsystem;

public class DriveCommand extends Command{

    CANDriveSubsystem driveSubsystem;
    CommandXboxController controller;

    public DriveCommand(CANDriveSubsystem driveSystem, CommandXboxController drivecontroller){
        addRequirements(driveSubsystem);
        driveSubsystem = driveSystem;
        controller = drivecontroller;
    }

    @Override
    public void initialize(){
    }

    @Override
    public void execute(){
        driveSubsystem.driveArcade(-controller.getLeftY(), -controller.getRightX());
    }
    @Override 
    public void end(boolean interrupted){
        driveSubsystem.driveArcade(0, 0);
    }
    @Override
    public boolean isFinished(){
        return false;

    }
    }
    


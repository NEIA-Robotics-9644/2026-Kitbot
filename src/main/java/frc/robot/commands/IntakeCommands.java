package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intake.*;

public class IntakeCommands extends Command{
    Intake intake;
    public IntakeCommands(Intake intake){
        addRequirements(intake);
        this.intake=intake;
    }

    @Override
    public void initialize(){
        intake.setIntakeLauncerRoller(-1*SmartDashboard.getNumber("intaking", INTAKING_INTAKE_VOLTAGE));
        intake.setFeederRoller(-1*smartDashboard.getNumber("intaking", INTAKE_FEEDER_VOLTAGE));

    }

    @Override
    public void execute(){}

    
}

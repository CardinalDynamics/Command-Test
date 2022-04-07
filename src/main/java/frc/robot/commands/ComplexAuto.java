package frc.robot.commands;

// import edu.wpi.first.wpilibj2.command.FunctionalCommand;
// import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
// import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.StartEndCommand;

// I'll be honest, I have no clue what any of this does, but it works.

public class ComplexAuto extends SequentialCommandGroup {
    /**
     * ComplexAuto is a command group that drives backwards for 2.5 seconds, and then shoots a ball.
     * 
     * @param driveSubsystem The drive subsystem
     * @param elevatorSubsystem The elevator subsystem
     * @param intakeSubsystem The intake subsystem
     * @param climberSubsystem The climber subsystem
     * @param shooterSubsystem The shooter subsystem
     *
     */
    public ComplexAuto(DriveSubsystem driveSubsystem, ElevatorSubsystem elevatorSubsystem, IntakeSubsystem intakeSubsystem, ClimberSubsystem climberSubsystem, ShooterSubsystem shooterSubsystem) {
        addCommands(
            
            // Thank you to Zack from 1540 for actually knowing how to write this.
            // a command that starts and then ends i guess
            new StartEndCommand(
                () -> driveSubsystem.drive(0.25, 0.25),
                () -> driveSubsystem.drive(0, 0),
                driveSubsystem
            ).withTimeout(2.5),

            // nyoom
            race(
                new WaitCommand(2).andThen(elevatorSubsystem.commandUp().withTimeout(3.5)),
                shooterSubsystem.runShooter()
            ));
        
    }
}
